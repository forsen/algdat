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
		int n = a.length;
		if( n < 2 ) 
			throw new NoSuchElementException("a.length(" + n + ") < 2!" );
		
		int m = 0, nm = 1; 

		if( a[1] > a[0] )
		{
			m = 1; 
			nm = 0; 
		}

		int sist = n-1; 

		int maksverdi = a[m]; 
		int nestmaksverdi = a[nm];

		int temp = a[sist];
		a[sist] = 0x7fffffff; 

		for( int i = 2; ; i++ )
		{
			if( a[i] > nestmaksverdi )
			{
				if( a[i] > maksverdi )
				{
					if(i == sist)
					{

						if(temp >= maksverdi ) 
						{
							nm = m;
							m = i; 
						}
						else if( temp >= nestmaksverdi )
						{
							nm = i; 
						}

						a[sist] = temp; 
						
						return new int[] {m,nm}; 	 
					}
					else
					{	
						nm = m; 
						nestmaksverdi = maksverdi; 

						m = i; 
						maksverdi = a[m];
					}
									
				}
				else
				{
					nm = i; 
					nestmaksverdi = a[nm];
				}
			}
		}



	}

/**
  * Finner største og nest største verdien i en heltallstabell
  * @param a heltallstabellen som man skal finne verdiene i
  * @return returnerer en tabell som inneholder posisjonen til maksverdi og nestmaksverdi. Returnerer to høyeste verdiene, uavhengig om de er like eller ei.
  */

	public static int[] nestMin( int[] a )
	{
		int n = a.length;
		if( n < 2 ) 
			throw new NoSuchElementException("a.length(" + n + ") < 2!" );
		
		int m = 0, nm = 1; 

		if( a[1] < a[0] )
		{
			m = 1; 
			nm = 0; 
		}

		int minverdi = a[m];
		int nestminverdi = a[nm]; 

		for( int i = 2; i < n; i++ )
		{
			if( a[i] < nestminverdi )
			{
				if( a[i] < minverdi )
				{
					nm = m;
					nestminverdi = minverdi; 

					m = i;
					minverdi = a[m];
				}
				else
				{
					nm = i; 
					nestminverdi = a[nm];
				}
			}
		}

		return new int[] {m,nm};

	}
/**
  * Sorterer en gitt heltallstabell i stigende rekkefølge.
  * @param a heltallstabellen som skal sorteres
  */
	public static void sortering( int[] a )
	{
		int n = a.length;
		if( n < 2 )
			throw new NoSuchElementException("a.length(" + n + ") < 2!" );

		for( int i = a.length - 1; i > 0; i-- )
		{
			int m = maks(a,0,i+1);
			bytt(a,m,i); 
		}
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

		if( a == null )
			throw new NullPointerException( "a = null" );

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

	private static void vhKontroll( int tablengde, int v, int h )
	{
		if( v < 0 )
			throw new ArrayIndexOutOfBoundsException( "v(" + v + ") < 0" );

		if( h >= tablengde )
			throw new ArrayIndexOutOfBoundsException( "h(" + h + ") >= tablengde(" + tablengde + ")" );

		if( v > h + 1 )
			throw new IllegalArgumentException( "v = " + v + ", h = " + h );
	}

/**
  *	Snur rekkefølgen på tallene i intervallet a[v:h].
  * @param a tabellen for å snu tallene i 
  * @param v fra og med posisjon for intervallet
  * @param h til og med posisjon for intervallet
  */

	public static void snu( int[] a, int v, int h )
	{
		vhKontroll( a.length, v, h );
		int il = h - v; 
		int[] b = new int[il];

		for( int  i = v; i <= h; i++ )
			bytt( a, i, h--);


	}

/**
  * Snur rekkefølgen på verdiene i en tabell.
  * @param a tabellen der rekkefølgen skal snus
  */
	public static void snu( int[] a )
	{
		if( a.length < 2 )
			return;

		int v = 0;
		int h = a.length - 1;

		do
		{
			bytt(a, v++, h--);
		} while (v>h); 
	}

/**
  * Finner neste permutasjon i stigende rekkefølge
  * @param a permutasjonen du skal finne etterfølgeren til
  * @return true dersom det finnes flere permutasjoner
  */
	public static boolean nestePermutasjon( int[] a )
	{
		int n = a.length;
		int i = n - 2; 

		while( i >= 0 && a[i] > a[i+1])
			i--;

		if( i < 0 )
			return false; 

		int verdi = a[i];
		int j = n - 1; 

		while( verdi > a[j] ) 
			j--; 

		bytt(a, i, j); 

		// kan man bruke snu her?

		i++;
		j = n-1;
		while(i < j) 
			Tabell.bytt(a, i++, j--);


		return true;
	}

	public static int parter(int[] a, int v, int h, int skilleverdi)
	{
		int antall = 0; 

		while( v <= h && a[v] < skilleverdi ) 
			v++; 
		while( v <= h && a[h] >= skilleverdi )
			h--; 

		while( true )
		{
			if( v < h )
			{
				Tabell.bytt( a, v, h );
				antall++;
			}

			else 
				return v; 

			while( a[v] < skilleverdi ) 
				v++;

			while( a[h] >= skilleverdi ) 
				h--;

		}
	}


	public static int sParter( int[] a, int v, int h, int indeks )
	{
		Tabell.bytt( a, indeks, h );

		int p = parter( a, v, h - 1, a[h] ); 

		Tabell.bytt( a, p, h );

		return p; 

	}

	public static void kvikksortering( int[] a, int v, int h )
	{
		if( v < h )
		{
			int m = (v+h)/2; 
			int p = sParter( a, v, h, m );

			kvikksortering( a, v, p - 1 );
			kvikksortering( a, p + 1, h );
		}
	}

	public static void kvikksortering( int[] a )
	{
		kvikksortering( a, 0, a.length - 1 );
	}

	public static int kvikksøk( int[] a, int k )
	{
		if( k < 0 || k >= a.length )
			throw new IllegalArgumentException( "k(" + k + ") er ulovlig!" );

		int v = 0, h = a.length - 1; 

		while( true )
		{
			int p = sParter( a, v, h, (v+h)/2 );
			if( k < p )
				h = p - 1;
			else if ( k > p )
				v = p + 1;
			else return a[p]; 
		}
	}
	

	public static double median( int[] a )
	{
		int n = a.length; 

		double r1 = (double) kvikksøk( a, (n/2) );

		if( n % 2 == 0 )
		{
			double r2 = (double) kvikksøk( a, (n/2) - 1 );
			r1 = (r1+r2)/2; 
		}

		return r1; 

	}

	public static void utvalgssortering( int[] a )
	{
		for( int k = a.length; k > 1; k-- )
			bytt( a, maks(a, 0, k), k-1);
	}

	public static int lineærsøk( int[] a, int verdi )
	{
		if( a.length < 1 || verdi > a[a.length - 1] )
			return -(a.length + 1);

		int i = 0; 

		for( ; a[i] < verdi; i++ ); 

		if ( a[i] == verdi )
			return i; 
		else
			return -(i + 1);
	}

	public static int lineærsøk( int[] a, int k, int verdi )
	{
		if( k < 1)
			throw new IllegalArgumentException( "k: " + k + " må være større enn 0");

		if( a.length < 1 || verdi > a[a.length - 1] )
			return -(a.length + 1);

		int i = 0; 

		for( ; a[i] < verdi; i += k);

		if( a[i] >= verdi )
		{
			for( i -= k ; a[i] < verdi; i++ );

			if( a[i] == verdi )
				return i;
			else
				return -(i + 1);
		}

		return i;


	}

	public static int binærsøk( int[] a, int fra, int til, int verdi )
	{
		fratilKontroll( a.length, fra, til );

		int v = fra; 
		int h = til - 1; 

		while( v < h )
		{
			int m = (v+h) / 2; 
			if( verdi > a[m] ) 
				v = m + 1; 
			else
				h = m; 
		}

		if( h < v || verdi < a[v] ) 
			return -( v + 1 );
		else if( verdi == a[v] )
			return v;
		else 
			return -( v + 2 ); 
	}

	public static int binærsøk( int[] a, int verdi )
	{
		return binærsøk(a, 0, a.length, verdi );
	}

	public static boolean erSortertAvtagende( int[] a )
	{
		for( int i = 1; i < a.length; i++ )
		{
			if( a[i - 1] < a[i] )
				return false;
		}

		return true;
	}

	public static boolean erSortertStigende( int[] a, int fra, int til )
	{
		fratilKontroll( a.length, fra, til );

		for( int i = fra + 1; i < til; i++ )
		{
			if( a[i - 1] > a[i] )
				return false;
		}

		return true;
	}

	public static void minimumssortering( int[] a )
	{


		for( int i = 0; i < a.length; i++ )
		{
			int indeks = i; 
			int minverdi = a[i];

			for( int j = i; j < a.length; j++ )
			{
				
				if( a[j] < minverdi )
				{
					minverdi = a[j];
					indeks = j; 
				}
			}
			int temp = a[i]; 
			a[i] = minverdi; 
			a[indeks] = temp; 

		}
	}

	public static int søkUsortert( int[] a, int verdi )
	{
		int n = a.length;
		int vakt = a[n - 1];
		a[n - 1] = verdi; 
		for( int i = 0; ; i++ )
		{
			if( verdi == a[i] )
			{
				a[n - 1] = vakt;
				if( i == n - 1 && vakt != verdi )
					return -1;
				else
					return i; 
			}
		}
	}

	public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			T temp = a[i];
			int j = i -1;

			for(; j >= 0 && temp.compareTo(a[j]) < 0; j--)
			{
				a[j+1] = a[j];
			}

			a[j+1] = temp;
		}
	}

	public static <T> void innsettingssortering(T[] a, Comparator<? super T> c )
	{
		for (int i = 1; i < a.length; i++)
		{
			T temp = a[i];
			int j = i -1;

			for(; j >= 0 && c.compare( temp, a[j] ) < 0; j--)
			{
				a[j+1] = a[j];
			}

			a[j+1] = temp;
		}
	}
}