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
		EnkeltLenketListe<String> liste = new EnkeltLenketListe<>(); 

		System.out.println( liste.tom() );

		liste.leggInn("Erik");
		liste.leggInn("Lars");
		liste.leggInn("Per");

		System.out.println( liste.tom() );

		liste.leggInn( 3, "Lisa");

		System.out.println( liste.antall() );

		System.out.println( liste );

		System.out.println( liste.inneholder( "Lis" )  );

		System.out.println( liste );
	}

}
