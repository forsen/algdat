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
		Stakk<Integer> a = new TabellStakk<>(4);
		Stakk<Integer> b = new TabellStakk<>(3);
		a.leggInn( 4 );
		a.leggInn( 3 );
		a.leggInn( 2 );
		a.leggInn( 1 );

		System.out.println( a );
		snu( a );

		System.out.println( "hei" );
	}

	public static <T> void kopier( Stakk<T> a, Stakk<T> b )
	{
		int størrelse = a.antall(); 
		Stakk<T> c = new TabellStakk<>(størrelse);

		for( int i = 0; i < størrelse; i++ )
		{
			T verdi = a.taUt(); 
			b.leggInn( verdi );
			c.leggInn( verdi ); 
		}

		for( int i = 0; i < størrelse; i++ ) 
			a.leggInn( b.taUt() );
		
		for( int i = 0; i < størrelse; i++ )
			b.leggInn( c.taUt() );
	}

	public static <T> void snu( Stakk<T> a )
	{
		int størrelse = a.antall(); 
		Stakk<T> b = new TabellStakk<T>( størrelse );
		
		for( int i = 1; i < størrelse; i++ )
		{
			T verdi = a.taUt(); 

			for( int j = 0; j < størrelse - 1; j++ )
				b.leggInn( a.taUt() );

			a.leggInn( verdi ); 

			for( int j = 0; j < størrelse - 1; j++)
				a.leggInn( b.taUt() );
		}
	}


}
