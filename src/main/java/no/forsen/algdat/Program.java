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

		SBinTre2<Integer> tre = SBinTre2.lagTre(); 

		tre.leggInn( 10 );

		System.out.println( tre.antallIngenBarn() );
		System.out.println( tre.antallEttBarn() );
		System.out.println( tre.antallToBarn() );
		System.out.println( tre.høyde() );
	}
}
