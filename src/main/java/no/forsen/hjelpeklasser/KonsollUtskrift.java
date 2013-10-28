package no.forsen.hjelpeklasser;

public class KonsollUtskrift<T> implements Oppgave<T>
{
	public void utførOppgave( T verdi )
	{
		System.out.println( verdi + " " );
	}
}