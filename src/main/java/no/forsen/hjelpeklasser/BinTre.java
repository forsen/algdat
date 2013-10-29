package no.forsen.hjelpeklasser; 



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

	public int nodetype( int k ) 
	{
		if( k < 1 )
			throw new IllegalArgumentException( "Må ha k > 0!" );

		Node<T> p = finnNode( k ); 

		if( p == null )
			return -1; 
		else if( p.venstre != null || p.høyre != null )
			return 0; 
		else 
			return 1; 
	}

	public T fjern( int k ) 
	{
		if( k < 1 )
			throw new IllegalArgumentException( "Må ha k > 0!" );

		Node<T> p = finnNode( k );
		if( p == null )
			throw new IllegalArgumentException( "Posisjon k(" + k + ") er ukjent!" );
		else if( p.venstre != null || p.høyre != null )
			throw new IllegalArgumentException( "Posisjon k(" + k + ") er ikke en bladnode. Kan ikke fjernes!" ); 

		T verdi = p.verdi; 
		
		if( k == 1 )
		{
			rot = null; 
			antall = 0;
			return verdi; 
		}

		Node<T> q = finnNode( k/2 );

		if( k % 2 == 0 )
			q.venstre = null; 
		else 
			q.høyre = null; 
		p = null; 
		antall--; 
		return verdi; 
	}

	public void nivåorden( Oppgave<? super T> oppgave )
	{
		if( tom() )
			return; 

		Ko<Node<T>> kø = new TabellKo<>(); 
		kø.leggInn( rot ); 

		while( !kø.tom() )
		{
			Node<T> p = kø.taUt(); 
			oppgave.utførOppgave( p.verdi ); 
			if( p.venstre != null )
				kø.leggInn( p.venstre );
			if( p.høyre != null ) 
				kø.leggInn( p.høyre ); 
		} 
	}

	private static <T> void preorden( Node<T> p, Oppgave<? super T> oppgave )
	{
		while( true )
		{
			oppgave.utførOppgave( p.verdi );
			if( p.venstre != null )
				preorden( p.venstre, oppgave );
			p = p.høyre; 
			if( p == null ) 
				return;
		}
	}

	public void preorden( Oppgave<? super T> oppgave )
	{
		if( rot != null )
			preorden( rot, oppgave ); 
	}

	private static <T> void inorden( Node<T> p, Oppgave<? super T> oppgave )
	{
		if( p.venstre != null )
			inorden( p.venstre, oppgave );
		oppgave.utførOppgave( p.verdi ); 
		if( p.høyre != null )
			inorden( p.høyre, oppgave ); 
	}

	public void inorden( Oppgave<? super T> oppgave )
	{
		if( rot != null )
			inorden( rot, oppgave ); 
	}

	private static <T> void postorden( Node<T> p, Oppgave<? super T> oppgave )
	{
		if( p.venstre != null )
			postorden( p.venstre, oppgave );
		if( p.høyre != null )
			postorden( p.høyre, oppgave );
		oppgave.utførOppgave( p.verdi );
	}

	public void postorden( Oppgave<? super T> oppgave )
	{
		if( rot != null )
			postorden( rot, oppgave );
	}

	public String toNivåString()
	{
		Tegnstreng s = new Tegnstreng();
		nivåorden( s ); 
		return s.toString(); 
	}

	public String toPostString()
	{
		Tegnstreng s = new Tegnstreng(); 
		postorden( s );
		return s.toString();
	}

	public String toPreString()
	{
		Tegnstreng s = new Tegnstreng(); 
		preorden( s ); 
		return s.toString();
	}
}