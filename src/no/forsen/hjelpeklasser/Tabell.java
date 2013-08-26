package no.forsen.hjelpeklasser;

import java.util.*; 
import java.lang.StringBuilder; 

/**
  * Tabell er en hjelpeklasse for tabeller. 
  *
  * @author Erik Haider Forsén
  */
public class Tabell
{
	private Tabell(){}

/**
  * Bytter om plassen til to verdier i en tabell.
  * @param a tabellen som skal endres
  * @param i indeksen til verdien som skal bytte plass med j
  * @param j indeksen til verdien som skal bytte plass med i
  */
	public static void bytt(int[] a, int i, int j)
	{
		int temp = a[i]; a[i] = a[j]; a[j] = temp;
	}

/**
  * Bytter om plassen til to tegn i en tabell.
  * @param c tabellen som skal endres
  * @param i indeksen til tegnet som skal bytte plass med j
  * @param j indeksen til tegnet som skal bytte plass med i
  */
	public static void bytt( char[] c, int i, int j )
	{
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp; 
	}
/**
  * Genererer en heltallstabell med lengde n og fyller den med tallene fra og med 1 til og med n på tilfeldige plasser.
  * @param n lengden på tabellen
  * @return tabellen
  */
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


/**
  * Finner maksverdien i et gitt intervall fra en tabell. 
  * @param a heltallstabellen som man skal finne maksverdien i
  * @param fra indeksposisjon man skal lete fra og med
  * @param til indeksposisjon man skal lete til (men ikke med)
  * @return returnerer posisjonen til maksverdien (dersom maksverdien forekommer flere ganger, vil første posisjon bli returnert)
  */
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
/**
  * Finner maksverdien i en heltallstabell
  * @param a heltallstabellen som man skal finne maksverdien i
  * @return returnerer posisjonen til maksverdien (dersom maksverdien forekommer flere ganger, vil første posisjon bli returnert)
  */
	public static int maks( int[] a )
	{
		return maks(a, 0, a.length );
	}

/**
  * Finner største og nest største verdien i en heltallstabell
  * @param a heltallstabellen som man skal finne verdiene i
  * @return returnerer en tabell som inneholder posisjonen til maksverdi og nestmaksverdi. Returnerer to høyeste verdiene, uavhengig om de er like eller ei.
  */
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
/**
  * Finner minverdien i et gitt intervall fra en tabell. 
  * @param a heltallstabellen som man skal finne minverdien i
  * @param fra indeksposisjon man skal lete fra og med
  * @param til indeksposisjon man skal lete til (men ikke med)
  * @return returnerer posisjonen til minverdien (dersom minverdien forekommer flere ganger, vil første posisjon bli returnert)
  */
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
/**
  * Finner minverdien i en heltallstabell
  * @param a heltallstabellen som man skal finne minverdien i
  * @return returnerer posisjonen til minverdien (dersom minverdien forekommer flere ganger, vil første posisjon bli returnert)
  */
	public static int min( int[] a )
	{
		return min( a, 0, a.length );
	}

	private static void fratilKontroll(int tablengde, int fra, int til)
	{
		if (fra < 0)                                  // fra er negativ
			throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");

		if (til > tablengde)                          // til er utenfor tabellen
			throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");

		if (fra > til)                                // fra er større enn til
			throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
	}

/**
  * Skriver ut innholdet i en heltallstabell innenfor et gitt intervall. Tallene blir skrevet ut på én linje, med mellomrom, uten linjeskift.
  * @param a heltallstabellen til å skrive ut
  * @param fra indeksposisjon man skal starte å skrive ut
  * @param til indeksposisjonen etter siste tall som blir skrevet ut
  */
	public static void skriv( int[] a, int fra, int til )
	{
		fratilKontroll( a.length, fra, til ); 

		StringBuilder utskrift = new StringBuilder();

		for( int i = fra; i < til; i++ )
			utskrift.append(a[i] + " ");

		System.out.print(utskrift); 
	}
/**
  * Skriver ut alle tallene i a, på én linje, med mellomrom som skille, uten linjeskift.
  * @param a inneholder tallene som skal skrives ut
  */
	public static void skriv(int... a )
	{
		StringBuilder utskrift = new StringBuilder(); 

		for( int i : a )
			utskrift.append( i + " " );

		System.out.print(utskrift);

	}
/**
  * Skriver ut innholdet i en heltallstabell innenfor et gitt intervall. Tallene blir skrevet ut på én linje, med mellomrom, med linjeskift til slutt.
  * @param a heltallstabellen til å skrive ut
  * @param fra indeksposisjon man skal starte å skrive ut
  * @param til indeksposisjonen etter siste tall som blir skrevet ut
  */
	public static void skrivln( int[] a, int fra, int til )
	{
		fratilKontroll( a.length, fra, til );

		StringBuilder utskrift = new StringBuilder(); 

		for( int i = fra; i < til; i++ )
			utskrift.append(a[i] + " " );

		System.out.println(utskrift);
	}
/**
  * Skriver ut alle tallene i a, på én linje, med mellomrom som skille, med linjeskift til slutt.
  * @param a inneholder tallene som skal skrives ut
  */
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