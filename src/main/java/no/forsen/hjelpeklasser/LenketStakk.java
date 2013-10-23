package no.forsen.hjelpeklasser; 

import java.util.*;

public class LenketStakk<T> implements Stakk<T>
{
	private static final class Node<T>
	{
		T verdi; 
		Node<T> neste; 

		Node( T verdi, Node<T> neste )
		{
			this.verdi = verdi; 
			this.neste = neste; 
		}
	}

	private Node<T> hode; 
	private int antall; 



	public LenketStakk()
	{
		hode = null; 
		antall = 0; 
	}
	public void leggInn( T verdi )
	{
		hode = new Node<>( verdi, hode );
		antall++;
	}

	public T kikk()
	{
		if( tom() ) 
			throw new NoSuchElementException( "Stakken er tom!" ); 
	
		return hode.verdi;  	
	}

	public T taUt()
	{
		if( tom() )
			throw new NoSuchElementException("Stakken er tom!");
		T temp = hode.verdi; 
		hode = hode.neste; 
		return temp; 
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
		hode.neste = null; 
		hode = null; 
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder(); 
		s.append('[');
		if( !tom() )
		{
			s.append( hode.verdi );

			Node<T> p = hode.neste;
			while( p != null )
			{
				s.append( ',' ).append( ' ' ).append( p.verdi ); 
				p = p.neste; 
			} 

		}
		
		s.append(']');
		return s.toString();
	}
}