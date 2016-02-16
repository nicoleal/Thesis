/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Color Enum TEST CLASS
 * 			Some basic JUnit tests for the Color Enum.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 14 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class ColorTest 
{

	@Test
	public void testColor() 
	{
		String s = Color.getColor(Color.WHITE);
		assertEquals("WHITE", s);
		s = Color.getColor(Color.GREEN);
		assertEquals("GREEN", s);
		s = Color.getColor(Color.MINT);
		assertEquals("MINT", s);
		s = Color.getColor(Color.YELLOW);
		assertEquals("YELLOW", s);
	}
	
	@Test
	public void testHex() 
	{
		int i = Color.getHex(Color.WHITE);
		assertEquals(16777215, i);
		i = Color.getHex(Color.GREEN);
		assertEquals(3843669, i);
		i = Color.getHex(Color.MINT);
		assertEquals(9691064, i);
		i = Color.getHex(Color.YELLOW);
		assertEquals(16771840, i);
	}
	
	@Test
	public void testGetRadius1() 
	{
		int i = Color.getRadius(Color.WHITE);
		assertEquals(0, i);
		i = Color.getRadius(Color.GREEN);
		assertEquals(3, i);
		i = Color.getRadius(Color.MINT);
		assertEquals(20, i);
		i = Color.getRadius(Color.YELLOW);
		assertEquals(4, i);
	}
	
	@Test
	public void testGetRadius2() 
	{
		int i = Color.GOLD.getRadius();
		assertEquals(8, i);
		i = Color.JADE.getRadius();
		assertEquals(12, i);
		i = Color.BLUE.getRadius();
		assertEquals(2, i);
		i = Color.NAVY.getRadius();
		assertEquals(19, i);
	}
	
	@Test
	public void testToString() 
	{
		String s = Color.WHITE.toString();
		assertEquals("0", s);
		
	}
}
