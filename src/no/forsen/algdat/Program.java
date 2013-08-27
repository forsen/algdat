package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;


public class Program
{
	public static void main(String[] args)
	{

		int[] a = Tabell.randPerm(20);
		Tabell.skrivln(a);

		Tabell.skrivln(Tabell.nestMin(a));

 
	}
}
