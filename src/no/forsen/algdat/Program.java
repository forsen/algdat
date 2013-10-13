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
		System.out.println( fakultet(5) );
	}

	public static int fakultet( int n )
	{
		if( n == 1 )
			return 1; 

		return fakultet( n - 1 ) * n; 
	}
}
