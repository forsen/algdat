package no.forsen.oblig; 

import java.util.*;
import no.forsen.hjelpeklasser.*;

public class DobbeltLenketListe<T> implements Liste<T>
{
	private static final class Node<T>       // en indre nodeklasse
	{
		private T verdi;
		private Node<T> forrige, neste;

		private Node(T verdi, Node<T> forrige, Node<T> neste)   // konstruktør
		{
			this.verdi = verdi;
			this.forrige = forrige;
			this.neste = neste;
		}
	}

	private Node<T> hode;         // peker til den første i listen
	private Node<T> hale;         // peker til den siste i listen
	private int antall;           // antall noder i listen
	private int antallEndringer;  // antall endringer i listen

	private void indeksKontroll(int indeks)
	{
		if (indeks < 0 )
		throw new IndexOutOfBoundsException("Indeks " +
		indeks + " er negativ!");
		else if (indeks >= antall)
		throw new IndexOutOfBoundsException("Indeks " +
		indeks + " >= antall(" + antall + ") noder!");
	}

	private static <T> void nullSjekk(T verdi)
	{
		if( verdi == null )
			throw new NullPointerException( "Objektet eksisterer ikke" );
	}

	private Node<T> finnNode(int indeks)
	{ 
		Node<T> p;

		if( indeks < antall/2 )
		{
			p = hode; 

			for( int i = 0; i < indeks; i++ )
				p = p.neste; 	
		}
		else
		{
			p = hale; 

			for( int i = antall - 1; i > indeks; i-- ) 
				p = p.forrige; 
		}

		return p; 
	}

	public DobbeltLenketListe()  // konstruktør
	{
		hode = hale = null;
		antall = 0;
		antallEndringer = 0;
	}

	public boolean tom()
	{
		return antall == 0;
	}

	public int antall()
	{
		return antall;
	}

	public void nullstill()
	{
		// foreløpig kode
	}

	public boolean inneholder(T verdi)
	{
		return false;  // foreløpig kode
	}

	public void leggInn(int indeks, T verdi)
	{
		// foreløpig kode
	}

	public boolean leggInn(T verdi)
	{
		nullSjekk( verdi ); 

		if( tom() )
		{
			Node<T> p = new Node<T>( verdi, null, null );
			hode = hale = p; 
		}
		else
		{
			Node<T> p = new Node<T>( verdi, hale, null );
			hale = hale.neste = p; 
		}

		antall++; 
		antallEndringer++; 

		return true; 
	}

	public T hent(int indeks)
	{
		indeksKontroll( indeks ); 

		return finnNode( indeks ).verdi;
	}

	public int indeksTil(T verdi)
	{
		return -1;  // foreløpig kode
	}

	public T oppdater(int indeks, T nyverdi)
	{
		nullSjekk( nyverdi );
		indeksKontroll( indeks );

		Node<T> p = finnNode( indeks ); 
		T gammelverdi = p.verdi; 
		p.verdi = nyverdi; 

		antallEndringer++; 

		return gammelverdi; 

	}

	public T fjern(int indeks)
	{
		return null;  // foreløpig kode 
	}

	public boolean fjern(T verdi)
	{
		return false;  // foreløpig kode
	}

	private class DobbeltLenketListeIterator implements Iterator<T>
	{
		private Node<T> p;
		private boolean fjernOK;
		private int forventetAntallEndringer;

		private DobbeltLenketListeIterator()
		{
			p = hode;         // p starter på den første i listen
			fjernOK = false;  // blir sann når next() kalles
			forventetAntallEndringer = antallEndringer;  // teller endringer
		}

		public boolean hasNext()
		{
			return false;  // foreløpig kode 
		}

		public T next()
		{
			return null;  // foreløpig kode
		}

		public void remove()
		{
			// foreløpig kode
		}

	} // class DobbeltLenketListeIterator  

	public Iterator<T> iterator()
	{
		return new DobbeltLenketListeIterator();
	}

	public Iterator<T> iterator(int indeks)
	{
		return null; // foreløpig kode
	}

	public String toString()
	{
		if( tom() )
			return "[]";

		StringBuilder utskrift = new StringBuilder();

		utskrift.append( '[' );
		
		Node<T> p = hode; 

		utskrift.append( p.verdi ); 

		p = p.neste; 

		while( p != null )
		{
			utskrift.append( ", " ).append( p.verdi );
			p = p.neste; 
		} 

		utskrift.append( ']' );
		return utskrift.toString();
	}

	public String omvendtString()
	{
		if( tom() )
			return "[]";

		StringBuilder utskrift = new StringBuilder(); 

		utskrift.append( '[' );

		Node<T> p = hale; 

		utskrift.append( p.verdi ); 

		p = p.forrige; 

		while( p != null )
		{
			utskrift.append( ", " ).append( p.verdi );
			p = p.forrige;
		}

		utskrift.append( ']' );
		return utskrift.toString();

	}

} // class DobbeltLenketListe