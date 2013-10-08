package no.forsen.hjelpeklasser; 

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

	public void nullstill()
	{

	}

	public String toString()
	{
		StringBuilder s = new StringBuilder(); 
		s.append('[');
		if( !tom() )
		{
			s.append( hode.verdi );

			Node<T> p = hode.neste; 
			// mangler masse kode

		}
		s.append(']');
		return s;
	}
}