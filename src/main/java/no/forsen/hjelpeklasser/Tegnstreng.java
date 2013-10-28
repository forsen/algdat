package no.forsen.hjelpeklasser; 

public class Tegnstreng implements Oppgave<Object>
{
	private StringBuilder utskrift; 

	public Tegnstreng()
	{
		utskrift = new StringBuilder(); 
		utskrift.append( '[' ); 
	}
	public void utførOppgave( Object verdi )
	{
		utskrift.append( verdi ); 
		utskrift.append( "," );
		utskrift.append( " " ); 
	}
	public String toString()
	{
		int n = utskrift.length();
		if( n > 2 )
			utskrift.delete( n - 2, n );

		utskrift.append( ']' );
		return utskrift.toString();
	}
}