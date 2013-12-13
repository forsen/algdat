package no.forsen.eksamen; 

public class EnkelListe<T>
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
	private int antall; 

	public EnkelListe()
	{
		hode = null;
		antall = 0; 
	}

	public void leggInnFørst( T verdi )
	{
		hode = new Node<>(verdi, hode);
		antall++; 
	}

	public void leggInnSist( T verdi )
	{
		Node<T> p = hode; 

		while( p.neste != null )
			p = p.neste; 

		Node<T> q = new Node<>( verdi, null );
		p.neste = q; 
	}

	public boolean tom()
	{
		return antall == 0;
	}

	public int antall()
	{
		return antall;
	}

	public void snu()
	{
		Node<T> p = hode.neste;
		hode.neste = null;  
 
		while( p != null )
		{
			Node<T> q = p.neste; 
			p.neste = hode; 
			hode = p; 
			p = q; 
		}
	}

	public String toString()
	{
		if( tom() )
			return "[]";

		StringBuilder s = new StringBuilder();
		Node<T> p = hode; 
		s.append('[').append(p.verdi); 
		p = p.neste; 

		while( p != null )
		{
			s.append(',').append(' ').append(p.verdi);
			p = p.neste;
		}
		s.append(']');
		return s.toString();
	}
}