package no.forsen.algdat; 

import javax.swing.JOptionPane;
import java.util.*;
import no.forsen.hjelpeklasser.*;

public class Main
{

	public static void main(String[] args)
	{
		long tid = System.currentTimeMillis();
		int[] a = Tabell.randPerm(1000000);
		tid = System.currentTimeMillis() - tid;

		int m = Tabell.maks(a, -1, 5);

	

		System.out.println(tid);
	}
}