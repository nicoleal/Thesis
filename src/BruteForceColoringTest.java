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

public class BruteForceColoringTest extends BruteForceColoring
{
	Graph g;
	
	@Test
	public void test4Diam1() throws Exception
	{
		g = new UserInputGraph("T5_Graph");
		bruteForce(g, 0);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = g.getLeaf(3).getColor();
		assertEquals(1, i);
		i = g.getLeaf(6).getColor();
		assertEquals(5, i);
		i = g.getLeaf(11).getColor();
		assertEquals(1, i);
		i = g.getLeaf(5).getColor();
		assertEquals(4, i);
		i = g.getLeaf(0).getColor();
		assertEquals(1, i);
		i = g.getLeaf(7).getColor();
		assertEquals(6, i);
		i = g.getLeaf(16).getColor();
		assertEquals(1, i);
		i = g.getLeaf(4).getColor();
		assertEquals(3, i);
		i = g.getLeaf(2).getColor();
		assertEquals(1, i);
	}
	
	@Test
	public void test4Diam2() throws Exception
	{
		g = new UserInputGraph("T5_Graph");
		bruteForce(g, 4);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = g.getLeaf(4).getColor();
		assertEquals(1, i);
		i = g.getLeaf(0).getColor();
		assertEquals(2, i);
		i = g.getLeaf(6).getColor();
		assertEquals(1, i);
		i = g.getLeaf(12).getColor();
		assertEquals(7, i);
		i = g.getLeaf(5).getColor();
		assertEquals(1, i);
		i = g.getLeaf(11).getColor();
		assertEquals(6, i);
		i = g.getLeaf(3).getColor();
		assertEquals(1, i);
		i = g.getLeaf(16).getColor();
		assertEquals(11, i);
		i = g.getLeaf(2).getColor();
		assertEquals(1, i);
	}
	
	@Test
	public void test4Diam3() throws Exception
	{
		g = new UserInputGraph("T5_Graph");
		bruteForce(g, 2);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = g.getLeaf(4).getColor();
		assertEquals(3, i);
		i = g.getLeaf(2).getColor();
		assertEquals(1, i);
		i = g.getLeaf(6).getColor();
		assertEquals(5, i);
		i = g.getLeaf(12).getColor();
		assertEquals(1, i);
		i = g.getLeaf(5).getColor();
		assertEquals(4, i);
		i = g.getLeaf(11).getColor();
		assertEquals(1, i);
		i = g.getLeaf(1).getColor();
		assertEquals(2, i);
		i = g.getLeaf(3).getColor();
		assertEquals(1, i);
		i = g.getLeaf(0).getColor();
		assertEquals(1, i);
	}
	
	@Test
	public void test4Diam4() throws Exception
	{
		g = new UserInputGraph("T5_Graph");
		bruteForce(g, 16);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = g.getLeaf(4).getColor();
		assertEquals(4, i);
		i = g.getLeaf(2).getColor();
		assertEquals(1, i);
		i = g.getLeaf(6).getColor();
		assertEquals(6, i);
		i = g.getLeaf(12).getColor();
		assertEquals(1, i);
		i = g.getLeaf(5).getColor();
		assertEquals(5, i);
		i = g.getLeaf(11).getColor();
		assertEquals(1, i);
		i = g.getLeaf(1).getColor();
		assertEquals(3, i);
		i = g.getLeaf(3).getColor();
		assertEquals(1, i);
		i = g.getLeaf(0).getColor();
		assertEquals(1, i);
	}
	
	@Test
	public void testForce() throws Exception
	{
		g = forceGraph(new UserInputGraph("T5_Graph"));
		PrintGraph.printListWithColors_ZeroFirst(g);
		int i = g.getLeaf(4).getColor();
		assertEquals(3, i);
		i = g.getLeaf(2).getColor();
		assertEquals(1, i);
		i = g.getLeaf(6).getColor();
		assertEquals(5, i);
		i = g.getLeaf(12).getColor();
		assertEquals(1, i);
		i = g.getLeaf(5).getColor();
		assertEquals(4, i);
		i = g.getLeaf(11).getColor();
		assertEquals(1, i);
		i = g.getLeaf(7).getColor();
		assertEquals(6, i);
		i = g.getLeaf(3).getColor();
		assertEquals(1, i);
		i = g.getLeaf(0).getColor();
		assertEquals(1, i);
	}
}