package no.forsen.algdat; 

import javax.swing.JOptionPane;
import java.util.*;
import no.forsen.hjelpeklasser.*;

public class Main
{

	public static void main(String[] args)
	{
		int[] a = Tabell.randPerm(20);
		System.out.println(Arrays.toString(a));

		int m = Tabell.maks(a); 

		Tabell.bytt(a, m, 0 );

		int nm = Tabell.maks(a, 1, a.length); 
	
		if( nm == m )
			nm = 0;

		Tabell.bytt(a, m, 0);

		System.out.println(m);
		System.out.println(nm );
	}
}