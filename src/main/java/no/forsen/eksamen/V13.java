package no.forsen.eksamen; 

import no.forsen.hjelpeklasser.*; 


public class V13
{

	public static <T> void kopier( Ko<T> a, Ko<T> b)
	{
		int n = a.antall(); 

		for( int i = 0; i < n; i++ )
		{
			T verdi = a.taUt();
			b.leggInn( verdi );
			a.leggInn( verdi ); 
		}

	}
	public static void main( String[] args )
	{
/*	
		Ko<Integer> a = new TabellKo<>();
		Ko<Integer> b = new TabellKo<>(); 

		int[] tall = {1,2,3,4,5};

		for( int k : tall )
			a.leggInn( k ); 

		kopier( a, b );
		System.out.println( a + " " + b );
	*/
/*		EnkelListe<Integer> a = new EnkelListe<>(); 

		a.leggInnFørst( 5 );
		a.leggInnFørst( 4 );
		a.leggInnFørst( 3 );
		a.leggInnFørst( 2 );
		a.leggInnFørst( 1 );
		a.leggInnSist( 6 ); 

		System.out.println( a );*/
		char[] tegn = "ABCDEFGHIJ".toCharArray();

		EnkelListe<Character> liste = new EnkelListe<>(); 
		for( char c : tegn )
			liste.leggInnFørst( c );

		System.out.println( liste );
		liste.snu();
		System.out.println( liste );
	}
}