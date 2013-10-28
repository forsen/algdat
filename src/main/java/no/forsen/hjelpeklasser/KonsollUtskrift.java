package no.forsen.hjelpeklasser;

public class KonsollUtskrift<T> implements Oppgave<T>
{
	private int n, antall; 

	public KonsollUtskrift( int n )
	{
		this.n = n; 
		antall = 0; 
	}

	public void utførOppgave( T verdi )
	{
		System.out.print( verdi + " " );
		if( ++antall % n == 0 )
			System.out.println();
	}
}