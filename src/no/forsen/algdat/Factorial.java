package no.forsen.algdat; 

public class Factorial
{
	public static long fac( int n )
	{
		long m = n; 
		for( long i = n; i>1; i--)
			m *= --n; 

		return m;
	}
}