package no.forsen.algdat;

import java.util.*;
import java.net.*;
import java.io.*;
import no.forsen.hjelpeklasser.*;

import no.forsen.oblig.*;



public class Program
{
	public static <T> void snu( Stakk<T> a )
	{
		if( a.antall() < 2 ) 
		{
			return; 
		}

		Stakk<T> b = new TabellStakk<>(); 

		int n = a.antall() - 1; 

		while( n > 0 )
		{
			T temp = a.taUt(); 
			for( int i = 0; i < n; i++ ) 
				b.leggInn( a.taUt() ); 
			
			a.leggInn( temp );
			while( !b.tom() )
				a.leggInn( b.taUt() );
			n--;
		}
	}
	public static void main( String[] args )
	{
		Stakk<String> a = new TabellStakk<>(0);

		a.leggInn( "Per" );
		a.leggInn( "Kari" );
		a.leggInn( "Ole" );
		a.leggInn( "Aase" );

		System.out.println( a );

		snu( a );

		System.out.println( a );


	}
}
