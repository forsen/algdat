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
}