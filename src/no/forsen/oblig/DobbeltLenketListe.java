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
		if( !tom() )
		{
			hode.neste = null; 
			hale.forrige = null; 
			hode = hale = null; 
			antall = 0; 
			antallEndringer++;
		}
	}

	public boolean inneholder(T verdi)
	{
		return indeksTil( verdi ) != -1; 
	}

	public void leggInn(int indeks, T verdi)
	{
/*	
		Vurderte koden under, men selv om det gir unntak i riktige tilfeller, blir feilmeldingen litt misvisende
		if( indeks != 0 )	
			indeksKontroll( indeks - 1 ); 
*/
		if (indeks < 0 )
			throw new IndexOutOfBoundsException("Indeks " + indeks + " er negativ!");
		else if (indeks > antall)
			throw new IndexOutOfBoundsException("Indeks " + indeks + " > antall(" + antall + ") noder!");		
	
		nullSjekk( verdi ); 

		if( tom() )
			hode = hale = new Node<T>( verdi, null, null );
		else if( indeks == 0 )
		{
			Node<T> p = new Node<T>( verdi, null, hode );
			hode = hode.forrige = p; 
		}

		else if( indeks == antall )
		{
			Node<T> p = new Node<T>( verdi, hale, null );
			hale = hale.neste = p; 
		}
		else
		{
			Node<T> settEtter = finnNode( indeks - 1 ); 
			Node<T> settFør = settEtter.neste; 
			settEtter.neste = settFør.forrige = new Node<T>( verdi, settEtter, settFør ); 
		}

		antall++;
		antallEndringer++; 

		
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
		if( verdi == null )
			return -1; 

		Node<T> p = hode;
		
		for( int i = 0; i < antall; i++ ) 
		{
			if( p.verdi == verdi )
				return i;	

			p = p.neste;
		}

		return -1; 
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
		indeksKontroll( indeks ); 
		T returverdi; 

		if( indeks == 0 )
		{
			returverdi = hode.verdi; 
			hode = hode.neste; 
			if( hode != null )
				hode.forrige = null;
		}
		else if( indeks == antall - 1 )
		{
			returverdi = hale.verdi; 
			hale = hale.forrige; 
			hale.neste = null; 
		}
		else
		{
			Node<T> p = hode; 

			for( int i = 0; i < indeks - 1; i++ ) 
				p = p.neste; 	
			
			returverdi = p.neste.verdi; 

			p.neste = p.neste.neste; 
			p.neste.forrige = p; 
		}

		antallEndringer++;
		antall--;

		return returverdi;


	}

	public boolean fjern(T verdi)
	{
		if( verdi == null || tom() )
			return false; 

		Node<T> p = hode; 

		for( int i = 0; i < antall; i++ ) 
		{
			if( p.verdi == verdi )
			{
				if( i == 0 || i == antall - 1 )
					fjern( i );
				else
				{
					p = p.forrige; 

					p.neste = p.neste.neste;
					p.neste.forrige = p;  
				}

				antall--;
				antallEndringer++;

				return true;
			}

			p = p.neste; 
		}

		return false; 
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