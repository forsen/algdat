package no.forsen.oblig; 

import java.util.NoSuchElementException;

public class Oblig1
{

	// Oppgave 1
	public static int maks( int[] a )
	{
		int n = a.length; 
		if( n < 1 )
			throw new NoSuchElementException("Denne tabellen er tom");

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
	// Det vil bli gjennomført n - 1 sammenligninger i metoden over.
	// Det blir færrest ombyttinger når tabellen er sortert stigende.
	// Det blir flest ombyttinger når den største verdien ligger først i tabellen. Resten av verdiene spiller ingen rolle, 
	// da den største verdien vil bli flyttet alle plassene uansett.


	// Oppgave 2
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
	// For en tabell med lengde n vil det bli (n^2 - n) / 2 sammenligninger.


	// Oppgave 3
	public static int antallUlikeSortert( int[] a )
	{
		if( a.length == 0 )
			return 0;

		int antall = 1;
		for( int i = 0; i < a.length - 1; i++ )
		{
			if( a[i] > a[i+1] )
				throw new IllegalStateException("Tabellen må være sortert");
		
			if( a[i] != a[i+1])
				antall++;
		}

		return antall;
	}
}


