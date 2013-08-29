package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;


public class Program
{

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
	
	public static void main(String[] args)
	{

		int[] a = { 5, 2, 9, 11, 7, 8, 13, 5};

		int verdi = kvikksøk(a, 7 );

		System.out.println( verdi );

	}
}
