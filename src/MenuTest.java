/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Menu Class Test Class
 * 			Some basic tests for the Menu Class.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 16 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */



import static org.junit.Assert.*;
import org.junit.Test;

public class MenuTest 
{
	Menu m = new Menu();

	@Test
	public void testPrinters() throws Exception 
	{
		m.setup();
	}
	
	/*@Test
	public void testPrint1() throws Exception
	{
		Tree t = new Tree();
		t = t.buildCat1(t, 20);
		t.getLeaf(t, 4).setColor(17);
		t.getLeaf(t, 8).setColor(12);
		t.getLeaf(t, 14).setColor(8);
		t.getLeaf(t, 16).setColor(2);
		m.cat1TreePrinter(t, 20);
	}*/

}
