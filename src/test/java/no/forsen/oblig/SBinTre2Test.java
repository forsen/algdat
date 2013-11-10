package no.forsen.oblig;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SBinTre2Test extends TestCase
{


	public SBinTre2Test( String testName )
	{
		super( testName ); 
	}

	public static Test suite()
	{
		return new TestSuite( SBinTre2Test.class );
	}

	public void testApp()
	{
		assertTrue( true );
	}

	public void test_antall()
	{
		SBinTre2<String> tre = SBinTre2.lagTre(); 
		tre.leggInn("Test1");
		tre.leggInn("Test2");
		int expected = 2; 
		int actual = tre.antall(); 
		assertEquals( expected, actual ); 
	}

	public void test_antall_verdier()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre(); 
		tre.leggInn( 4 );
		tre.leggInn( 5 );
		tre.leggInn( 0 );
		tre.leggInn( 2 );
		tre.leggInn( 0 );
		tre.leggInn( 0 );

		int expected = 3; 
		int actual = tre.antall( 0 );
		assertEquals( expected, actual );
	}

	public void test_antall_verdier2()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre(); 
		tre.leggInn( 4 );
		tre.leggInn( 5 );
		tre.leggInn( 0 );
		tre.leggInn( 2 );
		tre.leggInn( 0 );

		int expected = 0; 
		int actual = tre.antall( 9 );
		assertEquals( expected, actual );		
	}
}