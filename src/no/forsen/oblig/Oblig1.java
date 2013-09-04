package no.forsen.oblig; 

/*
		Erik Haider Forsén
		s188086
		2AA
*/

import java.lang.StringBuilder;
import java.util.*;
import java.io.*;
import java.net.URL;

public class Oblig1
{

	// Oppgave 1

	// Det vil bli gjennomført n - 1 sammenligninger i metoden over.
	// Det blir færrest ombyttinger når tabellen er sortert stigende.
	// Det blir flest ombyttinger når den største verdien ligger først i tabellen. Resten av verdiene spiller ingen rolle, 
	// da den største verdien vil bli flyttet alle plassene uansett.

	public static int maks( int[] a )
	{
		int n = a.length; 
		if( n < 1 )
			throw new NoSuchElementException( "Denne tabellen er tom" );

		if( n == 1 )
			return a[0];

		for( int i = 0; i < n - 1; i++ )
		{
			if( a[i] > a[i+1] )
			{
				int temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}
		}
		return a[n - 1];
	}


	// Oppgave 2

	// For en tabell med lengde n vil det bli (n^2 - n) / 2 sammenligninger.

	public static void sortering( int[] a )
	{
		int n = a.length;

		if( n <= 1 )
			return; 

		for( int i = n; i > 0; i-- )
		{
			for( int j = 0; j < i - 1 ; j++ )
			{
				if( a[j] > a[j + 1])
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp; 
				}
			}
		}
	}



	// Oppgave 3

	// Metoden er av første orden uansett tilfelle.

	public static int antallUlikeSortert( int[] a )
	{
		int n = a.length; 
		if( n == 0 )
			return 0;

		int antall = 1;
		for( int i = 0; i < n - 1; i++ )
		{
			if( a[i] > a[i+1] )
				throw new IllegalStateException("Tabellen må være sortert");
		
			if( a[i] != a[i+1])
				antall++;
		}

		return antall;
	}



	// Oppgave 4

	// Metoden er av andre orden i verste tilfelle

	public static int antallUlikeUsortert( int[] a )
	{
		int n = a.length;
		if( n == 0 )
			return 0;

		int antall = 0;

		for( int i = 0; i < n; i++ ) 
		{
			antall++;

			for( int j = i + 1; j < n; j++ )
			{
				if( a[i] == a[j] )
				{
					antall--;
					break;
				}
			}
		}

		return antall;
	}


	// Oppgave 5
	public static void rotasjon( char[] a )
	{
		int n = a.length;

		if( n == 0 )
			return; 

		char siste = a[n - 1]; 

		for( int i = n - 1; i > 0; i-- )
		{
			a[i] = a[i - 1];
		}

		a[0] = siste;
	}

	// Oppgave 6

	// to forskjellige tilnærminger her. Den ene (dersom k er negativ) flytter hvert element en og en plass til antall rotasjoner er fullført
	// den andre (dersom ko er positiv) flytter elementet så mange plasser som den skal flyttes direkte. Elementene i randsonen blir bevart 
	// med en hjelpetabell.

	public static void rotasjon( char[] a, int k )
	{
		int n = a.length;

		if( n == 0 )
			return; 

		k = k % n; // er dette juks? Resultatet blir det samme, men antallet rotasjoner stemmer jo ikke.. 

		char[] h = new char[Math.abs(k)];

		if( k > 0 )
		{
			int hjelp = 0;
			for( int i = n-k; i < n; i++ )
			{
				h[hjelp++] = a[i];
			}

			for( int i = n - 1; i >= 0; i-- )
			{
				if( i - k < 0 )
					a[i] = h[i];
				else
					a[i] = a[i - k];
			}

		}
		else
		{
			while( k != 0 )
			{
				char første = a[0];
				for( int i = 0; i < n - 1; i++ )
					a[i] = a[i + 1];

				a[n - 1] = første; 

				k++;
			}
		} 
	}


	// Oppgave 7
	public static String toString( int[] a, char v, char h, String mellomrom )
	{
		StringBuilder utskrift = new StringBuilder(); 

		utskrift.append( v );

		int n = a.length; 

		if( n != 0 )
		{
			utskrift.append( a[0] );

			for( int i = 1; i < n; i++ )
			{
				utskrift.append( mellomrom ); 
				utskrift.append( a[i] );
			}
		}

		utskrift.append( h );

		return utskrift.toString(); 
	}

	// Oppgave 8 a)
	public static int[] tredjeMinst( int[] a )
	{
		int n = a.length;

		if( n == 0 )
			throw new NoSuchElementException( "Tabellen er tom" ); 

		if( n < 3 )
			throw new IllegalArgumentException( "a.length(" + n + ") < 3!");

		int m = 0;
		int nm = 1;
		int nnm = 2; 

		if( a[1] < a[0] )
		{
			m = 1;
			nm = 0; 
		}

		if( a[2] < a[nm] )
		{

			if( a[2] < a[m] )
			{
				nnm = nm;
				nm = m; 
				m = 2;
			}
			else
			{
				nnm = nm;
				nm = 2; 
			}
		}

		int minverdi = a[m];
		int nestminverdi = a[nm];
		int nestnestminverdi = a[nnm];

		for( int i = 3; i < n; i++ )
		{
			if( a[i] < nestnestminverdi )
			{
				if( a[i] < nestminverdi )
				{
					if( a[i] < minverdi )
					{
						nnm = nm;
						nestnestminverdi = nestminverdi;
						
						nm = m; 
						nestminverdi = minverdi;
						
						m = i;
						minverdi = a[m]; 
					}
					else
					{
						nnm = nm; 
						nestnestminverdi = nestminverdi;
						
						nm = i;
						nestminverdi = a[nm];
					}
				}
				else
				{
					nnm = i;
					nestnestminverdi = a[nnm];
				}
			}
		}
		return new int[] {m,nm,nnm};
	}

	// Oppgave 8b
	public static void tredjeMinstTest()
	{
		int[][] a = {{0,1,2}, {0,2,1}, {1,0,2}, {1,2,0}, {2,0,1}, {2,1,0} };

		for( int i = 0; i < a.length; i++ )
		{
			int[] b = tredjeMinst( a[i] );

			if( a[i][b[0]] > a[i][b[1]] || a[i][b[1]] > a[i][b[2]] )
				System.out.println("Gir feil posisjon for min, nestmin og nestnestmin " );
		}

		int[] b = new int[0]; 
		boolean unntak = false; 

		try
		{
			tredjeMinst(b);
		}
		catch( Exception e )
		{
			unntak = true; 
			if( !(e instanceof NoSuchElementException) )
				System.out.println("Feil unntak for en tom tabell");
		
		}

		if(!unntak)
			System.out.println( "Det skal kastes unntak for en tom tabell" ); 

		unntak = false;
		b = new int[2];

		try
		{
			tredjeMinst(b);
		}
		catch( Exception e )
		{
			unntak = true;
			if( !(e instanceof IllegalArgumentException ) )
				System.out.println( "Feil unntak for en tabell med færre enn 3 verdier" );
		}

		if(!unntak)
			System.out.println( "Det skal kastes unntak for tabell med færre enn 3 verdier" );
	}

	// Oppgave 9
	public static int[] kMinst( int[] a, int k )
	{
		int n = a.length; 
		if( k < 1 || k > n )
			throw new IllegalArgumentException( "1 < k(" + k + ") < a.length(" + n +")");

		int[] verdier = new int[k];

		for( int i = 0; i < k; i++ )
			verdier[i] = a[i];
		
		sortering(verdier);

		for( int i = k; i < n; i++ )
		{
			if( a[i] < verdier[k - 1] )
			{
				verdier[k-1] = a[i];
				sortering( verdier );
			}
		}

		return verdier;
	}


	// Oppgave 10
	public static int[] bokstavfrekvens( String url ) throws IOException
	{
		InputStream inn = new BufferedInputStream((
			new URL(url)).openStream());

		int i;

		int a[] = new int[29];
		while( (i=inn.read()) != -1 )
		{
			switch( Character.toLowerCase((char) i) )
			{
				case 'a': 
					a[0]++;
					break;
				case 'b': 
					a[1]++;
					break;
				case 'c': 
					a[2]++;
					break;
				case 'd': 
					a[3]++;
					break;
				case 'e': 
					a[4]++;
					break;
				case 'f': 
					a[5]++;
					break;
				case 'g': 
					a[6]++; 
					break;
				case 'h': 
					a[7]++;
					break;
				case 'i': 
					a[8]++;
					break;
				case 'j': 
					a[9]++;
					break;
				case 'k': 
					a[10]++;
					break;
				case 'l': 
					a[11]++;
					break;
				case 'm':
					a[12]++;
					break;
				case 'n':
					a[13]++;
					break;
				case 'o':
					a[14]++;
					break;
				case 'p':
					a[15]++;
					break;
				case 'q':
					a[16]++;
					break;
				case 'r':
					a[17]++;
					break;
				case 's':
					a[18]++;
					break;
				case 't':
					a[19]++;
					break;
				case 'u':
					a[20]++;
					break;
				case 'v':
					a[21]++;
					break;
				case 'w':
					a[22]++;
					break;
				case 'x':
					a[23]++;
					break;
				case 'y':
					a[24]++;
					break;
				case 'z':
					a[25]++;
					break;
				case 'æ':
					a[26]++;
					break;
				case 'ø':
					a[27]++;
					break;
				case 'å':
					a[28]++;
					break; 
					default: 
					break;
			}

		}
		return a;
	}

}


