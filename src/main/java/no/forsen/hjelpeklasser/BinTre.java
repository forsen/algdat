package no.forsen.hjelpeklasser; 

import java.util.IllegalArgumentException;

public class BinTre<T>
{
	private static final class Node<T>
	{
		private T verdi;
		private Node<T> venstre;
		private Node<T> høyre;

		private Node( T verdi, Node<T> v, Node<T> h )
		{
			this.verdi = verdi; 
			venstre = v; 
			høyre = h; 
		}

		private Node( T verdi )
		{
			this.verdi = verdi;
		}
	}
	private Node<T> rot; 
	private int antall; 

	public BinTre()
	{
		rot = null;
		antall = 0;
	}

	public BinTre( int[] p, T[] v )
	{
		if( p.length > v.length )
			throw new IllegalArgumentException( "Tabell v har for få verdier!" );

		for( int i = 0; i < p.length; i++ )
			leggInn( p[i], v[i] );
	}

	public int antall()
	{
		return antall; 
	}

	public boolean tom()
	{
		return antall == 0; 
	}

	public void leggInn( int k, T verdi ) 
	{
		if( k < 1 ) 
		{
			throw new IllegalArgumentException( "Posisjon k(" + k + ") < 1!" );
		}

		Node<T> p = rot, q = null; 

		int n = Integer.highestOneBit( k >> 1 );

		while( p != null && n > 0 )
		{
			q = p; 
			p = ( n & k ) == 0 ? p.venstre : p.høyre; 
			n >>= 1; 
		}

		if( n > 0 )
			throw new IllegalArgumentException( "Posisjon k(" + k + ") mangler forelder!" );
		else if( p != null )
			throw new IllegalArgumentException( "Posisjon k(" + k + ") finnes fra før!" );

		p = new Node<>( verdi ); 

		if( q == null )
			rot = p; 
		else if( (k & 1) == 0 )
			q.venstre = p; 
		else
			q.høyre = p; 

		antall++; 
	}

	public boolean finnes( int k  ) 
	{
		return finnNode( k ) != null; 
	}

	public T hent( int k ) 
	{
		Node<T> p = finnNode( k ); 
		if( p == null )
			throw new IllegalArgumentException( "Posisjon k(" + k + ") er ukjent!" );

		return p.verdi;
	}

	public T oppdater( int k, T nyverdi )
	{
		Node<T> p = finnNode( k ); 

		if( p == null )
			throw new IllegalArgumentException( "Posisjon k(" + k + ") er ukjent!" );

		T gammelverdi = p.verdi; 
		p.verdi = nyverdi; 
		return gammelverdi; 
	}

	public Node<T> finnNode( int k ) 
	{
		if( k < 1 )
			return null; 

		Node<T> p = rot; 

		int n = Integer.highestOneBit( k >> 1 );

		for( ; p != null && n > 0; n>>= 1 )
			p = (k & n) == 0 ? p.venstre : p.høyre; 

		return p; 
	}
}