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
		SBinTre2<String> tre = SBinTre2.lagTre(); 

		tre.leggInn("Første");
		tre.leggInn("Andre");
		tre.leggInn("Tredje");
		tre.leggInn("Fjerde");

		System.out.println( tre );

		for( String k : tre ) 
		{
			System.out.println( k );
		}
	}
}
