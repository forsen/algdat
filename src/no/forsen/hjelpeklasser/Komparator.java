package no.forsen.hjelpeklasser;

import java.util.*; 

public class Komparator
{
	private Komparator()
	{

	}

	private static class Naturlig<T extends Comparable<? super T>> implements Comparator<T>
	{
		public int compare( T t1, T t2 )
		{
			return t1.compareTo(t2);
		}
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturlig()
	{
		return new Naturlig<T>();
	}
}