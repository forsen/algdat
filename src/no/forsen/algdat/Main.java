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

		int[] b = Tabell.nestMaks(a);

		System.out.println(b[0] + " " + b[1] );
	}
}