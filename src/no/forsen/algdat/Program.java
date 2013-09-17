package no.forsen.algdat;

import java.util.*;
import no.forsen.hjelpeklasser.*;


public class Program
{


	
	public static void main(String[] args)
	{
		Heltall a = new Heltall(5);
		Heltall b = new Heltall(5);

		List<Heltall> liste = new ArrayList<>();
		liste.add(a);

		boolean x = a.compareTo(b) == 0;
		boolean y = a.equals(b);

		System.out.println( x + " " + y );

	}
}
