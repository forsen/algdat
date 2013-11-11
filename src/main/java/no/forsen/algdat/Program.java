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
		SBinTre2<Integer> tre = SBinTre2.lagTre();
//		tre.leggInn( 5 );
//		tre.leggInn( 3 );
//		tre.leggInn( 8 );
//		tre.leggInn( 7 );
//		tre.leggInn( 10 );
//		tre.leggInn( 9 );
//		tre.leggInn( 10 );
//		tre.leggInn( 10 );
//		tre.leggInn( 11 );

		System.out.println( tre.høyreGren() );
/*
		System.out.println( "antall: " + tre.antall() );
		System.out.println( "ingen: " + tre.antallIngenBarn() );
		System.out.println( "ett: " + tre.antallEttBarn() );
		System.out.println( "to: " + tre.antallToBarn() );
		System.out.println( tre );

		System.out.println( tre.maksFjernAlle() );
		

		System.out.println( "antall: " + tre.antall() );
		System.out.println( "ingen: " + tre.antallIngenBarn() );
		System.out.println( "ett: " + tre.antallEttBarn() );
		System.out.println( "to: " + tre.antallToBarn() );
		System.out.println( tre );
*/
	}
}
