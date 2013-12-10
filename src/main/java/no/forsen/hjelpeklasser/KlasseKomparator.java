package no.forsen.hjelpeklasser;
//å
import java.util.Comparator;

public class KlasseKomparator implements Comparator<Student>
{
	public int compare( Student s1, Student s2 )
	{
		int cmp = s1.klasse().compareTo( s2.klasse() );

		if( cmp != 0 )
			return cmp; 

		return s1.compareTo( s2 );
	}
}