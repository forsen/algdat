package no.forsen.hjelpeklasser;

import java.lang.Comparable;


public class Dato implements Comparable<Dato>
{
	private final int dag, mnd, år; 
	private final String måned;

	public Dato( int dag, int mnd, int år )
	{
		this.dag = dag;
		this.mnd = mnd;
		this.år = år; 
		this.måned = null;
	}

	public Dato( int dag, String måned, int år )
	{
		this.måned = måned;
		if( måned == null )
			throw new NullPointerException("Måned er ikke spesifisert!");

		switch( måned.toLowerCase() )
		{
			case "januar":
				mnd = 1;
				break;
			case "februar":
				mnd = 2;
				break;
			case "mars":
				mnd = 3;
				break; 
			case "april":
				mnd = 4; 
				break; 
			case "mai":
				mnd = 5;
				break;
			case "juni":
				mnd = 6;
				break;
			case "juli":
				mnd = 7;
				break; 
			case "august":
				mnd = 8;
				break;
			case "september":
				mnd = 9;
				break; 
			case "oktober":
				mnd = 10;
				break;
			case "november":
				mnd = 11;
				break;
			case "desember":
				mnd = 12; 
				break; 
			default:
				mnd = 0;
				break; 
		}
		this.dag = dag;
		this.år = år;
	}

	public int compareTo( Dato d ) 
	{
		if( år < d.år)
			return -1;
		else if( år > d.år ) 
			return 1;
		else if( mnd < d.mnd )
			return -1;
		else if( mnd > d.mnd )
			return 1; 
		else 
			return dag - d.dag; 
	}

	public boolean equals( Object o )
	{
		if( o == this )
			return true; 
		if( !(o instanceof Dato ) ) 
			return false; 
		return compareTo( (Dato) o ) == 0;
	}

	public String toString()
	{
		if( måned == null )
			return "" + dag + '/' + mnd + '-' + år; 
		else
			return dag + ". " + måned + " " + år;
	}

	public int hashCode()
	{
		return år*10000 + mnd*100 + dag; 
	}
}