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
	public void test4Diam1() throws Exception
	{
		Graph g = BruteForceColoring.bruteForce((UserInputGraph.makeInput("T5_Graph")), 0);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = Graph.getLeaf(3).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(5, i);
		i = Graph.getLeaf(11).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(5).getColor();
		assertEquals(4, i);
		i = Graph.getLeaf(0).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(7).getColor();
		assertEquals(6, i);
		i = Graph.getLeaf(16).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(4).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(2).getColor();
		assertEquals(1, i);
	}
	
	@Test
	public void test4Diam2() throws Exception
	{
		Graph g = BruteForceColoring.bruteForce((UserInputGraph.makeInput("T5_Graph")), 4);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = Graph.getLeaf(4).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(0).getColor();
		assertEquals(2, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(12).getColor();
		assertEquals(7, i);
		i = Graph.getLeaf(5).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(11).getColor();
		assertEquals(6, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(16).getColor();
		assertEquals(11, i);
		i = Graph.getLeaf(2).getColor();
		assertEquals(1, i);
	}
	
	@Test
	public void test4Diam3() throws Exception
	{
		Graph g = BruteForceColoring.bruteForce((UserInputGraph.makeInput("T5_Graph")), 2);
		PrintGraph.printListWithColors_ZeroFirst(g);
		int i = Graph.getLeaf(4).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(2).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(5, i);
		i = Graph.getLeaf(12).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(5).getColor();
		assertEquals(4, i);
		i = Graph.getLeaf(11).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(1).getColor();
		assertEquals(2, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(1, i);
		//i = Graph.getLeaf(0).getColor();
		assertEquals(1, i);
		
	}
}
