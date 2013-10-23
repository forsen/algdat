package no.forsen.algdat;

import java.util.*;
import java.net.*;
import java.io.*;
import no.forsen.hjelpeklasser.*;

import no.forsen.oblig.*;



public class Program
{
	public static void main( String[] args )
	{
		long tid = System.currentTimeMillis();

		Stakk<Integer> s = new LenketStakk<>();
		Integer k = 0; 

		for( int i = 0; i < 10000000; i++ ) 
		{
			s.leggInn( k );
		}

		while( !s.tom() )
			s.taUt();

		tid = System.currentTimeMillis() - tid; 
		System.out.println( tid );

	}

	public static <T> void kopier( Stakk<T> a, Stakk<T> b )
	{
		int størrelse = a.antall(); 
		



		/*for( int i = 0; i < størrelse; i++ )
		{
			T verdi = a.taUt(); 
			b.leggInn( verdi );
			c.leggInn( verdi ); 
		}

		for( int i = 0; i < størrelse; i++ ) 
			a.leggInn( b.taUt() );
		
		for( int i = 0; i < størrelse; i++ )
			b.leggInn( c.taUt() );*/
	}

	public static boolean sjekkParanteser( String s, char v, char h )
	{
		Stakk<Integer> a = new TabellStakk<>(); 
		try
		{

			for( int i = 0; i < s.length(); i++ )
			{
				if( s.charAt(i) == v )
					a.leggInn(1);
				else if ( s.charAt(i) == h )
					a.taUt();
			}
		}
		catch( Exception e )
		{
			return false;
		}

		return a.tom();
	}

	public static <T> void sorter( Stakk<T> a, Comparator<? super T> c )
	{
		int antall = a.antall(); 
		Stakk<T> b = new TabellStakk<>(antall);
		boolean endring = true;  
		while( endring )
		{
			endring = false; 
			T maks = a.taUt();
			T verdi = a.taUt(); 
	
			for( int i = 0; i < antall-2; i++ ) 
			{
				if( c.compare(maks,verdi) > 0 )
				{
					b.leggInn( maks );
					maks = verdi;
					verdi = a.taUt();
				}
				else
				{
					b.leggInn( verdi );
					verdi = a.taUt(); 
					endring = true; 	
				}
			}
			if( c.compare(maks,verdi) > 0)
			{
				b.leggInn( maks );
				b.leggInn( verdi );
			}
			else
			{
				b.leggInn( verdi );
				b.leggInn( maks );
			}
			for( int i = 0; i < antall; i++ ) 
				a.leggInn( b.taUt() );
		}
	}

	public static <T> void snu( Stakk<T> a )
	{
		int størrelse = a.antall(); 
		Stakk<T> b = new TabellStakk<T>( størrelse );
		 		
		for( int i = 1; i < størrelse; i++ )
		{
			for( int j = 0; j < i ; j++ )
			{
				b.leggInn( a.taUt() );
			}
			T verdi = a.taUt(); 


			for( int j = 0; j < i; j++)
				a.leggInn( b.taUt() );
			a.leggInn( verdi );
		}
	}


}
