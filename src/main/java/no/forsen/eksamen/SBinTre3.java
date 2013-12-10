package no.forsen.eksamen; 

import java.util.*; 

public class SBinTre3<T>
{
	private static final class Node<T>
	{
		private T verdi; 
		private Node<T> venstre, høyre; 

		private Node( T verdi )
		{
			this.verdi = verdi; 
			venstre = høyre = null; 
		}
	}

	private Node<T> rot; 
	private int antall;
	private final Comparator<? super T> comp; 

	public SBinTre3( Comparator<? super T> c )
	{
		rot = null; 
		antall = 0; 
		comp = c;
	}

	public int antall()
	{
		return antall; 
	}

	public boolean tom()
	{
		return antall == 0;
	}

	public void leggInn( T verdi )
	{
		if( verdi == null )
			throw new NullPointerException( "Nullverdier er ulovlig" );

		Node<T> p = rot, q = null; 
		int cmp = 0; 

		while( p != null )
		{
			q = p;
			cmp = comp.compare( verdi, p.verdi );
			if( cmp < 0 ) p = p.venstre; 
			else p = p.høyre;  
		}

		p = new Node<>( verdi ); 

		if( q == null ) rot = p; 
		else if ( cmp < 0 ) q.venstre = p; 
		else q.høyre = p; 

		antall++; 
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder(); 
		s.append('[');
		if( !tom() )
			toString( rot, s );
		s.append(']');
		return s.toString(); 
	}

	private static <T> void toString( Node<T> p, StringBuilder s )
	{
		if( p.venstre != null )
		{
			toString( p.venstre, s );
			s.append(',').append(' ');
		}

		s.append( p.verdi );

		if( p.høyre != null )
		{
			s.append( ',' ).append( ' ' );
			toString( p.høyre, s );
		}
	}

	public boolean inneholder( T verdi )
	{
		Node<T> p = rot; 

		int cmp = 0; 
		while( p != null )
		{
			cmp = comp.compare( verdi, p.verdi );
			if( cmp < 0 )
				p = p.venstre; 
			else if( cmp > 0 )
				p = p.høyre; 
			else
				return true; 

		}

		return false; 
	}

	public T andrePostorden()
	{
		
	}

	public static <T> SBinTre3<T> kopi( SBinTre3<T> tre )
	{
		return null; 
	}
}