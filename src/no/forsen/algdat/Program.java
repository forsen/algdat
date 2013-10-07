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
		int[] a = {4,1,8,6,3,7,9,10,5,2};
		Liste<Integer> liste = new EnkeltLenketListe<>(); 
		for( int k : a ) 
			liste.leggInn(k);

		System.out.println( liste );
		int m = DobbeltLenketListe.maks( liste, Komparator.<Integer>naturlig() );
		System.out.println( m );
	}
}
