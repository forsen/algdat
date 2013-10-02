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

	private static class Omvendt1<T extends Comparable<? super T>> implements Comparator<T> 
	{
		public int compare( T t1, T t2 )
		{
			return t2.compareTo( t1 );
		}
	}

	public static <T extends Comparable<? super T>> Comparator<T> omvendt()
	{
		return new Omvendt1<T>();
	}

	private static class Omvendt2<T> implements Comparator<T> 
	{
		private Comparator<? super T> c;

		private Omvendt2( Comparator<? super T> c )
		{
			this.c = c;
		}

		public int compare( T t1, T t2 )
		{
			return c.compare( t2, t1 );
		}
	}

	public static <T> Comparator<T> omvendt( Comparator<? super T> c )
	{
		return new Omvendt2<T>(c);
	}
}