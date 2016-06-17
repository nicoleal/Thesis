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

public class KnownColoringsTest extends KnownColorings
{
	Graph g;
	
	@Test
	public void testSpine1() throws Exception
	{
		g = knownSpine(new Spine(8));
		int i = getNumNodes();
		assertEquals(8, i);
		i = getLeaf(6).getColor();
		assertEquals(1, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(3).getColor();
		assertEquals(3, i);
		i = getLeaf(4).getColor();
		assertEquals(1, i);
		boolean b = isLeaf(3);
		assertEquals(false, b);
		b = isLeaf(7);
		assertEquals(true, b);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine2() throws Exception
	{
		g = knownSpine(new Spine(30));
		int i = getNumNodes();
		assertEquals(30, i);
		i = getLeaf(6).getColor();
		assertEquals(1, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(3).getColor();
		assertEquals(3, i);
		i = getLeaf(4).getColor();
		assertEquals(1, i);
		i = getLeaf(29).getColor();
		assertEquals(4, i);
		i = getLeaf(27).getColor();
		assertEquals(3, i);
		i = getLeaf(28).getColor();
		assertEquals(1, i);
		PrintGraph.printListWithColors(g);
	}
	
	@Test
	public void testSpine3() throws Exception
	{
		g = knownSpine(new Spine(31));
		int i = getNumNodes();
		assertEquals(31, i);
		i = getLeaf(6).getColor();
		assertEquals(1, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(3).getColor();
		assertEquals(3, i);
		i = getLeaf(4).getColor();
		assertEquals(1, i);
		i = getLeaf(29).getColor();
		assertEquals(2, i);
		i = getLeaf(27).getColor();
		assertEquals(3, i);
		i = getLeaf(28).getColor();
		assertEquals(1, i);
		i = getLeaf(30).getColor();
		assertEquals(4, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine4() throws Exception
	{
		g = knownSpine(new Spine(29));
		int i = getNumNodes();
		assertEquals(29, i);
		i = getLeaf(6).getColor();
		assertEquals(1, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(3).getColor();
		assertEquals(3, i);
		i = getLeaf(4).getColor();
		assertEquals(1, i);
		i = getLeaf(28).getColor();
		assertEquals(4, i);
		i = getLeaf(27).getColor();
		assertEquals(3, i);
		i = getLeaf(26).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testStar1() throws Exception
	{
		g = knownStar(new Star(10));
		int i = getLeaf(6).getColor();
		assertEquals(1, i);
		i = getLeaf(0).getColor();
		assertEquals(2, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(9, i);
		i = getLeaf(3).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors_Star(g);
	}

	@Test
	public void test4Diam1() throws Exception
	{
		g = new UserInputGraph("T5_Graph");
		knownFourDiamTree(g, 0);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = getLeaf(6).getColor();
		assertEquals(4, i);
		i = getLeaf(11).getColor();
		assertEquals(1, i);
		i = getLeaf(5).getColor();
		assertEquals(2, i);
		i = getLeaf(0).getColor();
		assertEquals(6, i);
		i = getLeaf(7).getColor();
		assertEquals(5, i);
		i = getLeaf(16).getColor();
		assertEquals(1, i);
		i = getLeaf(3).getColor();
		assertEquals(3, i);
		i = getLeaf(4).getColor();
		assertEquals(1, i);
		i = getLeaf(2).getColor();
		assertEquals(2, i);
	}
	
}
