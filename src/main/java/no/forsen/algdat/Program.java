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
		
		String s = "(((1 + 2) * (3)) - 4 + (5 / 6)";

		System.out.println(sjekkParanteser( s, '(', ')' ));

		/*
		Stakk<String> a = new TabellStakk<>(4);
		
		a.leggInn( "1234" );
		a.leggInn( "123" );
		a.leggInn( "12345" );
		a.leggInn( "12" );
		a.leggInn( "123456789");
		a.leggInn( "123456");
		a.leggInn( "1234567");
		a.leggInn( "12345678");


		a.leggInn( "12345" );
		a.leggInn( "123" );
		a.leggInn( "1234" );
		a.leggInn( "12" );

		Comparator c = new StrenglengdeKomparator(); 

		System.out.println( a );
		//snu(a);
		//System.out.println( c.compare("12345","1234") );
		sorter( a, c );
		System.out.println( a );
		*/
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
