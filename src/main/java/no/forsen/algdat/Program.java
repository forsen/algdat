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
		BinTre<Character> tre = new BinTre<>(); 
		int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};
		//String v = "EIBGAHKLODNMCJF";    
		String v = "EIOBGDMAHNCKLJF";

		for (int i = 0; i < p.length; i++)
			tre.leggInn(p[i],v.charAt(i));

		Tegnstreng s = new Tegnstreng(); 

		tre.preorden( s ); 
		System.out.println( s );

	}
}
