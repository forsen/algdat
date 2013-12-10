package no.forsen.algdat;
//å
import java.util.*;
import java.net.*;
import java.io.*;
import no.forsen.hjelpeklasser.*;

import no.forsen.oblig.*;



public class Program
{
	public static void main( String[] args )
	{
	    BinTre<Character> tre = new BinTre<>(); 

//	    int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};
//	    String v = "EIBGAHKLODNMCJF";

	    char[] c = "EHBFAIDCG".toCharArray();
	    int[] p = {1,2,3,4,5,6,7,12,13};

	    for ( int i = 0; i < p.length; i++ )
	    	tre.leggInn( p[i], c[i] );
	    
	    tre.postorden( new KonsollUtskrift<>(50));

	    Iterator<Character> it = tre.postordeniterator(); 

	    System.out.println( "\n" );
	    while( it.hasNext() )
	    {
	    	System.out.print( it.next() + " " );
	    }



	}
}
