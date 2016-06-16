/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		KnownColorings Class TEST CLASS
 * 			Some basic tests for the KnownColorings Class. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 1 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class KnownColoringsTest 
{
	@Test
	public void testSpine1() throws Exception
	{
		Graph t = KnownColorings.knownSpine(Graph.buildSpine(8));
		int i = t.getNumNodes();
		assertEquals(8, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(4).getColor();
		assertEquals(1, i);
		boolean b = Helper.isLeaf(3);
		assertEquals(false, b);
		b = Helper.isLeaf(7);
		assertEquals(true, b);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine2() throws Exception
	{
		Graph t = KnownColorings.knownSpine(Graph.buildSpine(30));
		int i = t.getNumNodes();
		assertEquals(30, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(4).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(29).getColor();
		assertEquals(4, i);
		i = Graph.getLeaf(27).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(28).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine3() throws Exception
	{
		Graph t = KnownColorings.knownSpine(Graph.buildSpine(31));
		int i = t.getNumNodes();
		assertEquals(31, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(4).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(29).getColor();
		assertEquals(2, i);
		i = Graph.getLeaf(27).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(28).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(30).getColor();
		assertEquals(4, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine4() throws Exception
	{
		Graph t = KnownColorings.knownSpine(Graph.buildSpine(29));
		int i = t.getNumNodes();
		assertEquals(29, i);
		i = Graph.getLeaf(6).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(4).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(28).getColor();
		assertEquals(4, i);
		i = Graph.getLeaf(27).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(26).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testStar1() throws Exception
	{
		Graph g = KnownColorings.knownStar(Graph.buildStar(10));
		int i = Graph.getLeaf(6).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(0).getColor();
		assertEquals(2, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(9, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors_Star(g);
	}

	@Test
	public void test4Diam1() throws Exception
	{
		Graph g = KnownColorings.knownFourDiamTree(UserInputGraph.makeInput("T5_Graph"));
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = Graph.getLeaf(6).getColor();
		assertEquals(4, i);
		i = Graph.getLeaf(11).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(5).getColor();
		assertEquals(2, i);
		i = Graph.getLeaf(0).getColor();
		assertEquals(6, i);
		i = Graph.getLeaf(7).getColor();
		assertEquals(5, i);
		i = Graph.getLeaf(16).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(3).getColor();
		assertEquals(3, i);
		i = Graph.getLeaf(4).getColor();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getColor();
		assertEquals(2, i);
	}
	
}
