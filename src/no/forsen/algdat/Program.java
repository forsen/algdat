package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;
import javax.swing.JOptionPane;


public class Program
{
	public static void main(String[] args)
	{
/*
		Integer[] a = {6,3,8,2,1,10,7,5,4,9};

		class IntegerKomparator implements Comparator<Integer>
		{
			public int compare( Integer i1, Integer i2 )
			{
				return i1.compareTo(i2);
			}
		}

		Tabell.innsettingssortering(a, new IntegerKomparator() );

		System.out.println(Arrays.toString(a));
*/
/*
		Student[] s = new Student[5];

		s[0] = new Student( "Kari","Svendsen","2AA" );
		s[1] = new Student( "Boris", "Zukanovic", "2IA" );
		s[2] = new Student( "Ali", "Khan", "2IA" );
		s[3] = new Student( "Azra", "Zukanovic", "1AB" );
		s[4] = new Student( "kari", "Pettersen", "3AA" );

		int cmp = s[3].compareTo(s[3]);

		String[] p = {"Ola","Kari","Per","Åse","Bo","Petter"};

		Tabell.innsettingssortering(p, new StrenglengdeKomparator() );

		System.out.println(Arrays.toString( p ));
*/

		int[] a = {1,3,5,2};

		
		Tabell.skrivln( a );
		Tabell.skriv( a );
	}
}
