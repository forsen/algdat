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
		Stakk<Integer> a = new TabellStakk<>(5);

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

}
