package no.forsen.algdat; 

import javax.swing.JOptionPane;

public class Main
{
	public static void main(String[] args)
	{
		int[] m = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19, 20};

		System.out.println( "min: " + Minmax.min(m) + ", maks: " + Minmax.max(m));
	}
}