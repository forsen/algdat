package no.forsen.hjelpeklasser;
//å
import java.util.Comparator;

public class FornavnKomparator implements Comparator<Person>
{
	public int compare( Person p1, Person p2 )
	{
		int cmp = p1.fornavn().compareTo( p2.fornavn() );

		if( cmp != 0) 
			return cmp;

		return p1.etternavn().compareTo( p2.etternavn() );
	}
}