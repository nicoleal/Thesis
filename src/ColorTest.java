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

import org.junit.Test;

public class ColorTest {

	@Test
	public void testPrintColor() 
	{
		System.out.println("Test PrintColor");
		System.out.println();
		System.out.println(Color.getColor(Color.WHITE));
		System.out.println(Color.getColor(Color.GREEN));
		System.out.println(Color.getColor(Color.MINT));
		System.out.println(Color.getColor(Color.YELLOW));
		System.out.println("----------\n");
	}
	
	@Test
	public void testPrintHex() 
	{
		System.out.println("Test PrintHex");
		System.out.println();
		System.out.println(Color.getHex(Color.WHITE));
		System.out.println(Color.getHex(Color.GREEN));
		System.out.println(Color.getHex(Color.MINT));
		System.out.println(Color.getHex(Color.YELLOW));
		System.out.println("----------\n");
	}
	
	@Test
	public void testGetRadius1() 
	{
		System.out.println("Test GetRadius1");
		System.out.println();
		System.out.println(Color.getRadius(Color.WHITE));
		System.out.println(Color.getRadius(Color.GREEN));
		System.out.println(Color.getRadius(Color.MINT));
		System.out.println(Color.getRadius(Color.YELLOW));
		System.out.println("----------\n");
	}
	
	@Test
	public void testGetRadius2() 
	{
		System.out.println("Test GetRadius2");
		System.out.println();
		System.out.println(Color.GOLD.getRadius());
		System.out.println(Color.JADE.getRadius());
		System.out.println(Color.BLUE.getRadius());
		System.out.println(Color.NAVY.getRadius());
		System.out.println("----------\n");
	}
	
	@Test
	public void testToString() 
	{
		//TODO
	}
}
