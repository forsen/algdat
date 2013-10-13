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
		System.out.println( sum(5,10) );
	}

	public static int sum( int k, int n )
	{
		if( k == n )
			return n; 
		int m = (k + n)/2;
		return sum( m+1, n) + sum(k, m);
	}
}
