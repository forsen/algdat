package no.forsen.algdat;

import java.util.*;
import java.net.*;
import java.io.*;
import no.forsen.hjelpeklasser.*;
import javax.swing.JOptionPane;


public class Program
{
	public static void main( String[] args )
	{
		Liste<String> liste = new EnkeltLenketListe<>();
		liste.leggInn("Per");
		liste.leggInn("Kari");
		liste.leggInn("Ole");
		liste.leggInn("Åse");
		liste.leggInn("Jens");

		

		System.out.println( liste );

		for( String s : liste )
			System.out.print( s + " " );
		

		// System.out.println( liste.hent(2) );
		//Comparator<String> c = new Komparator.<String>naturlig();
		//Tabell.innsettingssortering( a, c );
		//Tabell.skriv(a); 
/*		Student[] s = new Student[5]; 

		s[0] = new Student("Kari", "Svendsen", "2AA");
		s[1] = new Student("Boris", "Zukanovic", "2IA");
		s[2] = new Student("Ali", "Kahn", "2IA");
		s[3] = new Student("Azra", "Zukanovic", "1AB");
		s[4] = new Student("Kari", "Pettersen", "3AA");

		Arrays.sort( s, new FornavnKomparator() );

		for( Student t : s )
			System.out.println( t );*/
	}

/*	public static void HanoisTårn( char a, char b, char c, int n) 
	{
		if (n == 1 ) 
		{
			System.out.println("Flytt brikke " + n + " fra " + a + " til " + c );
		}
		else
		{
			HanoisTårn( a, c, b, n - 1 );
			System.out.println( "Flytt brikke " + n + " fra " + a + " til " + c );
			HanoisTårn( b, a, c, n - 1 );
		}
	}
*/
/*
	public static byte[][] hentLabyrint(String url) throws IOException
	{
		BufferedReader inn = 
			new BufferedReader( new InputStreamReader( (new URL(url)).openStream())); 
	
		String[] dim = inn.readLine().split(" ");
		int m = Integer.parseInt(dim[0]);
		int n = Integer.parseInt(dim[1]);

		byte[][] labyrint = new byte[m][n];

		for (int i = 0; i < m; i++) 
		{
			String linje = inn.readLine();
			for (int j = 0; j < n; j++) 
			{
				if( linje.charAt(j) == '1' )		
					labyrint[i][j] = 1;
			}	
		}

		inn.close(); 
		return labyrint; 

	}

	public static int teller = 0; 

	public static boolean finnVei( byte[][] a, int i, int j, int iut, int jut )
	{
		a[i][j] = 2; 
		if( i == iut && j == jut )
		{
			System.out.println( "Vi fant en vei" );
			return true; 
		}

		int m = a.length, n = a[0].length;


		boolean funnet = false;

		if( !funnet && j + 1 < n && a[i][j+1] == 0 )
			funnet = finnVei( a, i, j + 1, iut, jut );
		if( !funnet && i + 1 < m && a[i+1][j] == 0 )
			funnet = finnVei( a, i + 1, j, iut, jut );
		if( !funnet && j > 0 && a[i][j-1] == 0 )
			funnet = finnVei( a, i, j - 1, iut, jut );
		if( !funnet && i > 0 && a[i-1][j] == 0 )
			funnet = finnVei( a, i - 1, j, iut, jut ); 

		if( !funnet )
			a[i][j] = 0;

		return funnet;
	}

	public static void skrivLabyrint( byte[][] a )
	{
		int m = a.length;
		int n = a[0].length;

		for( int i = 0; i < m; i++)
		{
			for( int j = 0; j < n; j++ )
			{
				System.out.print(a[i][j]);
			}

			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException
	{
		byte[][] labyrint = hentLabyrint( "http://www.iu.hio.no/~ulfu/appolonius/kap1/5/labyrint.txt" );

		//teller = 0; 

		finnVei( labyrint, 0, 0, 19, 19 );
		//System.out.println( teller );
		skrivLabyrint( labyrint );

	}*/
}
