/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		BruteForceColoring Class TEST CLASS
 * 			Some basic tests for the BruteForceColoring Class.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 1 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class BruteForceColoringTest 
{
	Tree tree;
	
	@Test
	public void testSpine() throws Exception 
	{
		Tree t = new Tree();
		t.buildSpine(t, 2);
		int i = t.getNumNodes(t);
		assertEquals(2, i);
		t = BruteForceColoring.colorMe(t);
		i = t.tree[0].getColor();
		assertEquals(1, i);
		i = t.tree[1].getColor();
		assertEquals(2, i);
	}
}
