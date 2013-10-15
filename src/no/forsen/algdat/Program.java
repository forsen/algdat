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

		a.leggInn( 4 );
		a.leggInn( 3 );
		a.leggInn( 2 );
		a.leggInn( 1 );

		System.out.println( a );

		snu( a );

		System.out.println( a );
	}

	public static <T> void snu( Stakk<T> a )
	{
		int størrelse = a.antall(); 
		Stakk<T> b = new TabellStakk<T>( størrelse );
		Stakk<T> c = new TabellStakk<T>( størrelse );

		for( int i = 0; i < størrelse; i++ )
			b.leggInn( a.taUt() );
	
		for( int i = 0; i < størrelse; i++ ) 
			c.leggInn( b.taUt() );
		
		for( int i = 0; i < størrelse; i++ )
			a.leggInn( c.taUt() );
	}


}
