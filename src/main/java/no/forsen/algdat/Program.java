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
		int[] a = {3,1,2,5,4,6,8,12,13};
		System.out.println( girBinærtre( a ) );
	}

	public static boolean girBinærtre( int[] a )
	{
		if( a.length == 0 )
			return true; 

		Arrays.sort( a );

		if( a[0] != 1 )
			return false; 

		for( int i = 0; i < a.length - 1; i++ )
		{
			if( a[i+1] == a[i] )
				return false; 

		}

		for( int i = 1; i < a.length; i++ )
		{
			int j = i - 1; 
			int forelder = a[i]/2; 

			for(; j >= 0; j-- )
				if( forelder == a[j] )
					break; 

			if( j < 0 )
				return false; 
		}

		return true;
	}
}
