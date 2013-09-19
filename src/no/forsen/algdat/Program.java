package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;
import javax.swing.JOptionPane;


public class Program
{
	public static void main(String[] args)
	{
		Student[] s = new Student[5];

		s[0] = new Student( "Kari","Svendsen","2AA" );
		s[1] = new Student( "Boris", "Zukanovic", "2IA" );
		s[2] = new Student( "Ali", "Khan", "2IA" );
		s[3] = new Student( "Azra", "Zukanovic", "1AB" );
		s[4] = new Student( "kari", "Pettersen", "3AA" );

		int cmp = s[3].compareTo(s[3]);

		Comparator<Person> c = new FornavnKomparator();
		Tabell.innsettingssortering( s,c );

		Arrays.sort(s,c);



	}
}
