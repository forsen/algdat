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
		System.out.println( a(10) );
	}

	public static int a( int n )
	{
		int an = 0; 
		int an1 = 2;
		int an2 = 1; 

		for( int i = 1; i < n; i++ )
		{
			an = 2*an1 + 3*an2; 
			an2 = an1; 
			an1 = an; 
		}

		return an; 
	}
}
