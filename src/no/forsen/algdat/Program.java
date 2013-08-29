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
	public static void main(String[] args)
	{

		
		int[] a = Tabell.randPerm( 10000000 );

		//Tabell.skrivln( a ); 

		
		long tid = System.currentTimeMillis();
		kvikksortering( a );
		tid = System.currentTimeMillis() - tid;
		System.out.println( tid );

		//System.out.println( v );

		//Tabell.skrivln( a ); 
 
	}
}
