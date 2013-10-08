package no.forsen.hjelpeklasser; 

import java.util.*; 

public class TabellStakk<T> implements Stakk<T> 
{
	private T[] a;
	private int antall;

	public TabellStakk()
	{
		this(8);
	}

	public TabellStakk( int lengde )
	{
		if( lengde < 0 ) 
			throw new IllegalArgumentException( "Negativ tabellengde!" );
		
		a = (T[])new Object[lengde];
		antall = 0; 
	}

	public int antall() 
	{
		return antall;
	}

	public boolean tom() 
	{
		return antall == 0; 
	}

	public void leggInn( T verdi ) 
	{
		if( antall == a.length ) 
		{
			a = Arrays.copyOf( a, 2*antall );
		}
		a[antall++] = verdi; 
	}

	public T kikk()
	{
		if( tom() ) 
			throw new NoSuchElementException( "Stakken er tom!" ); 
	
		return a[antall - 1]; 	
	}

	public T taUt()  
	{
		if( tom() )
			throw new NoSuchElementException( "Stakken er tom!" );

		antall--;
		T temp = a[antall];
		a[antall] = null;
		return temp; 
	}

	public void nullstill() 
	{
		
	}



}