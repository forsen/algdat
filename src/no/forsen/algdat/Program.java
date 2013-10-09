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
		System.out.println( siffersum(956847) );
	}

	public static int tverrsum( int n )
	{
		int tverrsum = 0; 
		while( n > 0 )
		{
			tverrsum += n%10;
			n = n/10;
		}

		return tverrsum;
	}

	public static int siffersum( int n )
	{
		while( n > 9 )
			n = tverrsum( n );

		return n;
	}
}
