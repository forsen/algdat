package no.forsen.eksamen; 

import java.util.*; 

public class StringKomparator implements Comparator<String>
{
	public int compare( String s, String t )
	{
		if( s.length() < t.length() )
			return -1;
		else if( s.length() > t.length() )
			return 1; 
		else
			return s.compareTo( t ); 
	}
}