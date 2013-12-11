package no.forsen.eksamen; 

import java.util.*;
import no.forsen.hjelpeklasser.*; 

public class H12
{
	public static void halvbytt( int[] a )
	{
		int n = a.length; 
		if( n % 2 != 0 )
			throw new IllegalArgumentException(); 

		for( int i = 0; i < n/2; i++ )
			Tabell.bytt( a, i, i+(n/2) );

	}

	public static <T> void kopier( Stakk<T> a, Stakk<T> b )
	{
		int n = a.antall(); 
		Stakk<T> c = new TabellStakk<>();


		for( int i = 0; i < n; i++ )
			c.leggInn( a.taUt() ); 
		
		
		for( int i = 0; i < n; i++ )
		{
			a.leggInn( c.kikk() );
			b.leggInn( c.taUt() ); 
		}
	}

	public static void main( String[] args ) 
	{
/*
		// oppgave 1A
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		halvbytt( a ); 
		System.out.println( Arrays.toString(a) );	

		// oppgave 1B
		String[] navn = {"Per", "Kari", "Anton", "Ali", "Jasmin", "Hansine", "Knut", "Anders"};

		Arrays.sort( navn, new StringKomparator() );

		System.out.println( Arrays.toString( navn ) );

		// oppgave 1C
		Stakk<Integer> a = new TabellStakk<>(); 
		Stakk<Integer> b = new LenketStakk<>(); 

		int[] tall = {1,2,3,4,5};
		for( int k : tall )
			a.leggInn( k );

		kopier( a, b );

		b.leggInn( 6 ); 

		System.out.println( a + " " + b );
*/	
		Comparator<Integer> c = Komparator.naturlig(); 
		SBinTre3<Integer> tre = new SBinTre3<>( c ); 	

		int[] a = {7,2,9,1,5,8,10,3,6,4};

		for( int k : a )
			tre.leggInn( k ); 

		// oppgave 3B 
		//System.out.println( tre.inneholder( 0 ) );

		// oppgave 3C
		System.out.println( tre.andrePostorden() );
	}

}