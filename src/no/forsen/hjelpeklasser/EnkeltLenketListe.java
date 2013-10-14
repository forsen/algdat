package no.forsen.hjelpeklasser;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EnkeltLenketListe<T> implements Liste<T>
{
	private static final class Node<T>
	{
		private T verdi;
		private Node<T> neste;

		private Node( T verdi, Node<T> neste )
		{
			this.verdi = verdi;
			this.neste = neste;
		}

	}

	private Node<T> hode;
	private Node<T> hale;  
	private int antall;
	private int antallEndringer;
	public EnkeltLenketListe()
	{
		hode = null; 
		hale = null;
		antall = 0;
	}

	public EnkeltLenketListe( Iterable<T> itererbar )
	{
		this(); 
		for( T t : itererbar )
			leggInn( t );
	}

	private static <T> void nullTest( T t )
	{
		if( t == null )
			throw new NullPointerException( "Ikke tillatt med null-verdier" );
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


	private Node<T> finnNode(int indeks )
	{
		Node<T> p = hode; 

		for( int i = 0; i < indeks; i++ )
			p = p.neste; 

		return p; 
	}

	public boolean leggInn( T t )
	{
		nullTest(t);

		if( antall == 0 )
		{
			hode = new Node<T>( t, null );
			hale = hode; 
		}
		else
		{
			hale.neste = new Node<T>( t, null );
			hale = hale.neste; 
		}
		antall++;
		return true; 
	}
	public void leggInn( int indeks, T t )
	{
		nullTest( t );
		if( indeks < 0 || indeks > antall )
			throw new IndexOutOfBoundsException( "Indeks " + indeks + " er ulovlig!" );

		if( indeks == 0 )
		{
			hode = new Node<T>( t, hode );
			if(antall == 0 )
				hale = hode; 
		}
		else if( indeks == antall )
		{
			hale = hale.neste = new Node<T>(t, null);
		}
		else
		{
			Node<T> p = finnNode( indeks - 1 );
			p.neste = new Node<T>(t, p.neste);
		}

		antall++;
	}
	public int antall()
	{
		return antall;
	}

	public boolean tom()
	{
		return antall == 0; 
	}
	public Iterator<T> iterator()
	{
		return new EnkeltLenketListeIterator(); 
	}

	private class EnkeltLenketListeIterator implements Iterator<T> 
	{
		private Node<T> p = hode; 
		private boolean fjernOK = false; 

		public boolean hasNext()
		{
			return p != null;  
		}	
		public T next()
		{
			if( !hasNext() )
				throw new NoSuchElementException( "Listen er tom eller har ikke flere verdier!" );

			fjernOK = true; 
			T verdi = p.verdi; 
			p = p.neste; 
			return verdi;
		}
		public void remove()
		{
			throw new UnsupportedOperationException("Ikke kodet!");
		}
	} // end of class EnkeltLenketListeIterator

	public void nullstill()
	{

	}
	public T fjern( int indeks )
	{
		indeksKontroll( indeks );

		Node<T> q,p = null;

		if( indeks == 0 )
		{
			q = hode; 
			hode = hode.neste; 
		}
		else
		{
			p = finnNode( indeks - 1 );
			q = p.neste; 
			p.neste = q.neste; 
		}
		if( q == hale )
			hale = p; 

		T verdi = q.verdi; 
		q.verdi = null; 
		q.neste = null; 
		antall--; 
		return verdi; 
	}
	public boolean fjern( T t )
	{
		return false;
	}

	public T oppdater( int indeks, T t )
	{
		nullTest( t );
		indeksKontroll( indeks );

		Node<T> p = finnNode( indeks ); 

		T gammelverdi = p.verdi; 
		p.verdi = t; 
		return gammelverdi;
	}
	public int indeksTil( T t )
	{
		return -1; 
	}
	public T hent( int indeks )
	{
		indeksKontroll( indeks );
		return finnNode( indeks ).verdi; 	
	}
	public boolean inneholder( T t )
	{
		return false;
	}

	public String toString()
	{
		if( tom() )
			return "[]";
		StringBuilder s = new StringBuilder();

		s.append('[');

		Node<T> p = hode; 

		s.append( p.verdi );

		p = p.neste;

		while( p != null )
		{
			s.append( "," ).append( " " ).append( p.verdi );
			p = p.neste; 
		}

		s.append(']');

		return s.toString();




	}



}