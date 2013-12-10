package no.forsen.hjelpeklasser;
//å
public final class Heltall implements Comparable<Heltall>
{
	private final int verdi; 

	public Heltall( int verdi )
	{
		this.verdi = verdi;
	}

	public int intVerdi()
	{
		return verdi;
	}

	public int compareTo( Heltall h )
	{
		if( verdi < h.verdi )
			return -1;

		else if( verdi == h.verdi )
			return 0;
		else
			return 1; 
	}

	public boolean equals( Heltall h )
	{
		return this == h; 
	}

	public boolean equals( Object o )
	{
		if( this == o )
			return true;
		if( !(o instanceof Heltall)) 
			return false;

		return verdi == ((Heltall)o).verdi;
	}

	public String toString()
	{
		return "" + verdi; 
	}
}