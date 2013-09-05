package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;


public class Program
{


	
	public static void main(String[] args)
	{

		int[] a = { 2,4,7,12,15,16,20,25};

		int p = Tabell.lineærsøk(a, 26 );

//		if( p < 0 ) 
//			System.out.println( -(p+1) );
//		else
			System.out.print(p);


		//System.out.println( verdi );

	}
}
