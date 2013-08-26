package no.forsen.hjelpeklasser;

import java.util.*; 
import java.lang.StringBuilder; 

public class Tabell
{
	private Tabell(){}

	public static void bytt(int[] a, int i, int j)
	{
		int temp = a[i]; a[i] = a[j]; a[j] = temp;
	}

	public static void bytt( char[] c, int i, int j )
	{
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp; 
	}

	public static int[] randPerm(int n)
	{
		Random r = new Random();         // en randomgenerator
		int[] a = new int[n];            // en tabell med plass til n tall
		for (int i = 0; i < n; i++)
			a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

		for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
		{
			int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
			bytt(a,k,i);                   // bytter om
		}

		return a;                        // permutasjonen returneres
	}

	public static void randPerm( int[] a )
	{
		Random r = new Random();

		for (int k = a.length - 1; k > 0; k--)
		{
			int i = r.nextInt( k + 1 );
			bytt( a,k,i );
		}
	}



	public static int maks( int[] a, int fra, int til )
	{
		fratilKontroll(a.length, fra, til);

		if( fra == til )
			throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
		
		
		int m = fra; 
		int maksverdi = a[fra];

		for( int i = fra + 1; i < til; i++ )
		{
			if (a[i] > maksverdi )
			{
				maksverdi = a[i];
				m = i;
			}
		}
		return m;

	} 
	
	public static int maks( int[] a )
	{
		return maks(a, 0, a.length );
	}

	public static int[] nestMaks(int[] a)
	{
		int m = 0, nm = 1; 

		if( a[1] > a[0] )
		{
			m = 1; 
			nm = 0; 
		}

		int maksverdi = a[m]; 
		int nestmaksverdi = a[nm];

		for( int i = 2; i < a.length; i++ )
		{
			if( a[i] > nestmaksverdi )
			{
				if( a[i] > maksverdi )
				{
					nm = m; 
					nestmaksverdi = maksverdi; 

					m = i; 
					maksverdi = a[m];
				}
				else
				{
					nm = i; 
					nestmaksverdi = a[nm];
				}
			}
		}

		int[] b = {m,nm};

		return b; 

	}

	public static int min( int[] a, int fra, int til )
	{
		fratilKontroll( a.length, fra, til );

		if( fra == til )
			throw new NoSuchElementException( "fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!" );

		int m = fra;
		int minverdi = a[fra];

		for( int i = fra + 1; i < til; i++ )
		{
			if( a[i] < minverdi )
			{
				minverdi = a[i];
				m = i;
			}
		}

		return m; 
	}

	public static int min( int[] a )
	{
		return min( a, 0, a.length );
	}

	public static void fratilKontroll(int tablengde, int fra, int til)
	{
		if (fra < 0)                                  // fra er negativ
			throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");

		if (til > tablengde)                          // til er utenfor tabellen
			throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");

		if (fra > til)                                // fra er større enn til
			throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
	}

	public static void skriv( int[] a, int fra, int til )
	{
		fratilKontroll( a.length, fra, til ); 

		StringBuilder utskrift = new StringBuilder();

		for( int i = fra; i < til; i++ )
			utskrift.append(a[i] + " ");

		System.out.print(utskrift); 
	}

	public static void skriv(int... a )
	{
		StringBuilder utskrift = new StringBuilder(); 

		for( int i : a )
			utskrift.append( i + " " );

		System.out.print(utskrift);

	}

	public static void skrivln( int[] a, int fra, int til )
	{
		fratilKontroll( a.length, fra, til );

		StringBuilder utskrift = new StringBuilder(); 

		for( int i = fra; i < til; i++ )
			utskrift.append(a[i] + " " );

		System.out.println(utskrift);
	}

	public static void skrivln( int... a )
	{
		StringBuilder utskrift = new StringBuilder(); 

		for( int i : a )
			utskrift.append( i + " " );

		System.out.println( utskrift ); 
	}

	public static void skriv( char[] c, int fra, int til )
	{
		fratilKontroll( c.length, fra, til );

		StringBuilder utskrift = new StringBuilder(); 

		for( int i = fra; i < til; i++ )
			utskrift.append( c[i] + " " );

		System.out.print( utskrift ); 
	}

	public static void skriv( char... c )
	{
		StringBuilder utskrift = new StringBuilder(); 

		for( int i : c )
			utskrift.append( i + " " ); 

		System.out.print( utskrift ); 
	}

	public static void skrivln( char[] c, int fra, int til )
	{
		fratilKontroll( c.length, fra, til );

		StringBuilder utskrift = new StringBuilder(); 

		for( int i = fra; i < til; i++ )
			utskrift.append( c[i] + " " );

		System.out.println( utskrift ); 
	}

	public static void skrivln( char... c )
	{
		StringBuilder utskrift = new StringBuilder(); 

		for( int i : c )
			utskrift.append( i + " " ); 

		System.out.println( utskrift ); 
	}

	public static int[] naturligeTall( int n )
	{
		if( n < 1 )
			throw new IllegalArgumentException( "Argumentet må være et positivt heltall" ); 

		int[] a = new int[n]; 

		for( int i = 0; i < n; i++ )
			a[i] = i+1 ; 

		return a; 
	}

	public static int[] heleTall( int fra, int til )
	{
		if( fra > til )
			throw new IllegalArgumentException( "Illegalt intervall: fra " + fra + ", til " + til );

		int[] a = new int[til - fra];

		int indeks = 0;

		for( int i = fra; i < til; i++ )
		{
			a[indeks++] = i; 
		}

		return a;

	}


}