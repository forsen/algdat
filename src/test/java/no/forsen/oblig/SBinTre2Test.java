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

	public void test_if_blah_blah()
	{
		int expected = 4; 
		int actual = SBinTre2.returnInt();
		assertEquals( expected, actual ); 
	}
}