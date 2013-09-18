package no.forsen.hjelpeklasser; 

public class Person implements Comparable<Person>
{
	private String fornavn;
	private String etternavn;

	public Person( String fornavn, String etternavn )
	{
		this.fornavn = fornavn;
		this.etternavn = etternavn; 
	}

	public String fornavn() 
	{
		return fornavn;
	}

	public String etternavn()
	{
		return etternavn;
	}

	public int compareTo( Person p )
	{
		int cmp = etternavn.compareTo( p.etternavn );
		
		if( cmp != 0 )
			return cmp; 
		return fornavn.compareTo(p.fornavn); 
	}

	public boolean equals( Object o )
	{
		if( this == o )
			return true; 
		if( !(o instanceof Person ) )
			return false; 

		//return etternavn == ((Person).o).etternavn && fornavn == ((Person)o).fornavn;
		return true;
	}

	public String toString()
	{
		return fornavn + " " + etternavn;
	}
}