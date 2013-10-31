package no.forsen.hjelpeklasser;

import java.util.Comparator;

public class SBinTre<T>
{
	private static final class Node<T>
	{
		private T verdi; 
		private Node<T> venstre, høyre; 

		private Node( T verdi, Node<T> v, Node<T> h )
		{
			this.verdi = verdi; 
			venstre = v; 
			høyre = h; 
		}

		private Node( T verdi )
		{
			this( verdi, null, null );
		}
	}

	private Node<T> rot; 
	private int antall; 
	private final Comparator<? super T> comp; 

	public SBinTre( Comparator<? super T> c )
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

	public void nullstill()
	{
		rot = null; 
		antall = 0; 
	}
}
