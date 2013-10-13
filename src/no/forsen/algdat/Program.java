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
		System.out.println( "main() utføres!" );
		int sum = tverrsum(72958);
		System.out.println( "main() er ferdig!" );
	}

	public static int tverrsum( int n )
	{
		System.out.println( "tverrsum(" + n + ") utføres!" );
		int sum = (n < 10) ? n : tverrsum( n / 10 ) + ( n % 10 );
		System.out.println( "tverrsum(" + n + ") er ferdig!" );
		return sum; 
	}

}
