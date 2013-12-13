package no.forsen.eksamen; 

public class SBinTre4<T>
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

	public SBinTre4( Comparator<? super T> c )
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
			throw new NullPointerException( "Nullverdier er ulovlig!" );

		Node<T> p = rot, q = null; 
		int cmp = 0; 

		while( p != null )
		{
			q = p; 
			cmp = comp.compare( verdi, p.verdi );
			if( cmp < 0 )
				p = p.venstre;
			else p = p.høyre;
		}

		p = new Node<>( verdi );

		if( q == null )
			rot = p; 
		else if( cmp < 0 )
			q.venstre = p;
		else q.høyre = p;

		antall++;
	}

	public T sistePreorden()
	{
		return null;
	}

	private Node<T> nestePreorden( Node<T> p )
	{
		return null;
	}

	public void preorden( Oppgave<T> oppgave )
	{

	}

	public String lengstgren()
	{
		return null;
	}
}