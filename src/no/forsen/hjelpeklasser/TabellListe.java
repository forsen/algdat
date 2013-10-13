package no.forsen.hjelpeklasser;

import java.util.*;


public class TabellListe<T> implements Liste<T>
{
	private T[] a;
	private int antall;
	private int antallEndringer = 0; 

	public TabellListe( int størrelse )
	{
		a = (T[])new Object[størrelse];
		antall = 0;
	}

	public TabellListe()
	{
		this(8);
	}

	public void leggInn( int indeks, T t )
	{
		if( t == null )
			throw new NullPointerException( "Ikke tillat med null-verdier!" );

		if( indeks < 0 || indeks > antall )
			throw new IndexOutOfBoundsException( "Indeks " + indeks + " er ulovlig!" );

		if( antall == a.length )
			a = Arrays.copyOf(a, (3*antall)/2 + 1);

		for( int i = antall; i > indeks; i-- )
			a[i] = a[i-1];

		a[indeks] = t;
		antall++;
		antallEndringer++;
	}
	public boolean leggInn( T t )
	{
		leggInn(antall, t );
		return true;
	}

	public int antall()
	{
		return antall;
	}

	public boolean tom()
	{
		return antall == 0; 
	}

	private void indeksKontroll( int indeks )
	{
		if( indeks < 0 )
			throw new IndexOutOfBoundsException( "Indeks " +
				indeks + " er negativ!" );
		else if( indeks >= antall )
			throw new IndexOutOfBoundsException( "Indeks " +
				indeks + " >= antall(" + antall + ") noder!" );
	}

	public T hent( int indeks )
	{
		indeksKontroll(indeks);
		return a[indeks];
	}

	public int indeksTil( T t )
	{
		for( int i = 0; i < antall; i++ )
		{
			if( a[i].equals(t))
				return i;
		}

		return -1;
	}

	public boolean inneholder( T t )
	{
		return indeksTil(t) != -1; 
	}

	public Iterator<T> iterator()
	{
		return new TabellListeIterator();
	}
	public T oppdater( int indeks, T t )
	{
		indeksKontroll(indeks);
		T verdi = a[indeks];
		a[indeks] = t; 
		antallEndringer++;
		return verdi;
	}
	public T fjern( int indeks )
	{
		indeksKontroll( indeks );

		T verdi = a[indeks];

		antall--; 

		for( int i = indeks; i < antall; i++ )
			a[i] = a[i+1];

		a[antall] = null;
		antallEndringer++;
		return verdi;
	}
	public boolean fjern( T t )
	{
		for( int i = 0; i < antall; i++ )
		{
			if( a[i].equals( t ))
			{
				fjern(i); 
				return true;
			}
		}
		return false;
	}
	public void nullstill()
	{
		if( a.length > 10 )
			a = (T[])new Object[10];
		else
			for( int i = 0; i < antall; i++)
				a[i] = null; 
		antall = 0; 
		antallEndringer++;
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append('[');

		if( antall > 0 )
			s.append(a[0]);

		for (int i = 1; i < antall; i++) {
			s.append(',').append(' ').append(a[i]);
		}

		s.append(']');

		return s.toString();
	}

	private class TabellListeIterator implements Iterator<T>
	{
		private int denne = 0; 
		private boolean removeOk = false;
		private int forventetAntallEndringer = antallEndringer; 

		public boolean hasNext()
		{
			return denne < antall; 
		}

		public T next()
		{
			if( !hasNext() ) 
				throw new NoSuchElementException("Tomt eller ikke flere igjen"); 

			if( antallEndringer != forventetAntallEndringer )
				throw new ConcurrentModificationException("Det er gjort endringer!");
			removeOk = true; 

			T verdi = a[denne++];
			return verdi;  
		}

		public void remove()
		{
			if( !removeOk )
				throw new IllegalStateException();

			denne--;
			antall--;

			antallEndringer++;
			forventetAntallEndringer++;

			for( int i = denne; i < antall; i++ )
				a[i] = a[i + 1];

			a[antall] = null; 

			removeOk = false; 
		}
	}
}