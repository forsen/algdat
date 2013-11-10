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

	public void test_instansvariabler()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre();
		tre.leggInn( 4 );
		tre.leggInn( 5 ); 
		tre.leggInn( 6 );
		tre.leggInn( 7 );
		tre.leggInn( 12 ); 
		tre.leggInn( 1 ); 
		tre.leggInn( 5 );

		int expected = tre.antall(); 
		int actual = tre.antallIngenBarn() + tre.antallEttBarn() + tre.antallToBarn(); 

		assertEquals( expected, actual );
	}

	public void test_høyde()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre(); 
		tre.leggInn( 2 );
		tre.leggInn( 8 );
		tre.leggInn( 3 );
		tre.leggInn( 5 ); 
		tre.leggInn( 12 ); 
		tre.leggInn( 43 );
		tre.leggInn( 88 ); 

		int expected = 5; 
		int actual = tre.høyde();

		assertEquals( expected, actual );
	}

	public void test_nest_min()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre(); 
		tre.leggInn( 5 );
		tre.leggInn( 2 );
		tre.leggInn( 8 ); 
		tre.leggInn( 3 );

		Integer expected = 3;
		Integer actual = tre.nestMin();
		assertEquals( expected, actual );
	}

	public void test_maks()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre(); 
		tre.leggInn( 8 );
		tre.leggInn( 7 );
		tre.leggInn( 12 );
		tre.leggInn( 45 ); 
		tre.leggInn( 32 );

		Integer expected = 45; 
		Integer actual = tre.maks();
		assertEquals( expected, actual );
	}

	public void test_nest_maks()
	{
		SBinTre2<Integer> tre = SBinTre2.lagTre(); 
		tre.leggInn( 8 );
		tre.leggInn( 7 );
		tre.leggInn( 12 );
		tre.leggInn( 45 ); 
		tre.leggInn( 32 );

		Integer expected = 32; 
		Integer actual = tre.nestMaks();
		assertEquals( expected, actual );		
	}
}