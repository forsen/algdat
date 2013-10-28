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
		int[] a = {1,2,3,5,6,7,10,11,12,13,21,24,25,42,43};

		Character[] b = {'D','I','H','L','O','B','A','E','N','G','K','M','J','F','C'};

		BinTre<Character> tre = new BinTre<>( a, b ); 

		int[] c = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};
		Character[] d = {'E','I','B','G','A','H','K','L','O','D','N','M','C','J','F'};

		BinTre<Character> tre2 = new BinTre<>( c, d );

		System.out.println( tre2 );
	}
}
