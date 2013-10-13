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
		System.out.println( kvadratsum(5) );
	}

	public static int kvadratsum( int n )
	{
		if( n == 1 )
			return 1; 
		int sum = n*n; 
		return kvadratsum(n - 1) + sum; 
	}
}
