package no.forsen.hjelpeklasser; 
//å
public class Student extends Person
{
	private final String klasse;

	public Student( String fornavn, String etternavn, String klasse )
	{
		super(fornavn,etternavn);
		this.klasse = klasse;
	}

	public String klasse() 
	{
		return klasse;
	}

	@Override
	public String toString()
	{
		return super.toString() + " " + klasse;
	}
}