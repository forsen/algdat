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
		Ko<Integer> a = new TabellKo<>(100);

		a.leggInn(1);
		a.leggInn(2);
		a.leggInn(3);
		a.leggInn(4);
		a.leggInn(5);

		System.out.println( a );
		snu( a );
		System.out.println( a );
	}

	public static <T> void snu( Stakk<T> a )
	{
		int antall = a.antall(); 
		Ko<T> b = new TabellKo<>(antall); 

		for( int i = 0; i < antall; i++ ) 
			b.leggInn( a.taUt() );
		
		for( int i = 0; i < antall; i++ )
			a.leggInn( b.taUt() );
	}

	public static <T> void snu( Ko<T> a )
	{
		int antall = a.antall(); 
		Ko<T> b = new TabellKo<>(100);

		int j = antall - 1;  
		T verdi = null; 
		while( j > 0 )
		{
			for(int i = 0; i < j + 1; i++ )
			{
				if( i == j )
					verdi = a.taUt(); 
				else
					b.leggInn(a.taUt());
			}

			a.leggInn( verdi );
			for( int i = 0; i < j; i++ )
				a.leggInn( b.taUt() );
			j--;
		}

	}

}
