package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;


public class Program
{


	
	public static void main(String[] args)
	{

		// a) 2 3 6 1 4 5 skal bli 2 3 6 1 5 4
		// b) 2 3 6 1 5 4 skal bli 2 3 6 4 1 5
		// c) 2 3 1 6 5 4 skal bli 2 3 4 1 5 6
		// d) 2 3 6 5 4 1 skal bli 2 4 1 3 5 6
		// e) 2 6 5 4 3 1 skal bli 3 1 2 4 5 6 

		// 3 1 7 9 4 10 8 6 5 2 

		// 3 1 7 9 5 2 4 6 8 10
		// 3 1 7 9 5 2 4 6 10 8
		// 3 1 7 9 5 2 4 8 6 10
		// 3 1 7 9 5 2 4 8 10 6 
		// 3 1 7 9 5 2 4 10 6 8
		// 3 1 7 9 5 2 4 10 8 6
		// 3 1 7 9 5 2 6 4 8 10
		// 3 1 7 9 5 2 6 4 10 8
		// 3 1 7 9 5 2 6 8 4 10
		// 3 1 7 9 5 2 6 8 10 4

		int[] a = new int[100000000];
		for( int i = 0 ; i < 100000000; i++ )
		{
			a[i] = i;
		}
		//Tabell.skrivln( a );

		long tid;
		tid = System.currentTimeMillis();
		Tabell.skrivln( Tabell.lineærsøk( a, 4000000 ) );
		tid = System.currentTimeMillis() - tid;
		System.out.println( tid );

		tid = System.currentTimeMillis();
		Tabell.skrivln( Tabell.lineærsøk( a, (int) Math.sqrt(a.length), 4000000) );
		tid = System.currentTimeMillis() - tid;
		System.out.println( tid );
	}
}
