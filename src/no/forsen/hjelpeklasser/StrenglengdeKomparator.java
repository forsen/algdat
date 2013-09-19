package no.forsen.hjelpeklasser;

import java.util.Comparator;

public class StrenglengdeKomparator implements Comparator<String>
{
	public int compare( String a, String b )
	{
		int cmp = a.length() - b.length();
		if( cmp != 0 )
			return cmp;

		return a.compareTo(b);
	}
}