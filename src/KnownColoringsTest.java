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
		int i = g.getNumNodes();
		assertEquals(8, i);
		i = g.getLeaf(6).getColor();
		assertEquals(1, i);
		i = g.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(3).getColor();
		assertEquals(3, i);
		i = g.getLeaf(4).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine2() throws Exception
	{
		g = knownSpine(new Spine(30));
		int i = g.getNumNodes();
		assertEquals(30, i);
		i = g.getLeaf(6).getColor();
		assertEquals(1, i);
		i = g.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(3).getColor();
		assertEquals(3, i);
		i = g.getLeaf(4).getColor();
		assertEquals(1, i);
		i = g.getLeaf(29).getColor();
		assertEquals(4, i);
		i = g.getLeaf(27).getColor();
		assertEquals(3, i);
		i = g.getLeaf(28).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors(g);
	}
	
	@Test
	public void testSpine3() throws Exception
	{
		g = new Spine(31);
		knownSpine(g);
		int i = g.getNumNodes();
		assertEquals(31, i);
		i = g.getLeaf(6).getColor();
		assertEquals(1, i);
		i = g.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(3).getColor();
		assertEquals(3, i);
		i = g.getLeaf(4).getColor();
		assertEquals(1, i);
		i = g.getLeaf(29).getColor();
		assertEquals(2, i);
		i = g.getLeaf(27).getColor();
		assertEquals(3, i);
		i = g.getLeaf(28).getColor();
		assertEquals(1, i);
		i = g.getLeaf(30).getColor();
		assertEquals(4, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testSpine4() throws Exception
	{
		g = knownSpine(new Spine(29));
		int i = g.getNumNodes();
		assertEquals(29, i);
		i = g.getLeaf(6).getColor();
		assertEquals(1, i);
		i = g.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(3).getColor();
		assertEquals(3, i);
		i = g.getLeaf(4).getColor();
		assertEquals(1, i);
		i = g.getLeaf(28).getColor();
		assertEquals(4, i);
		i = g.getLeaf(27).getColor();
		assertEquals(3, i);
		i = g.getLeaf(26).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors(t);
	}
	
	@Test
	public void testStar1() throws Exception
	{
		g = new Star(10);
		knownStar(g);
		int i = g.getLeaf(6).getColor();
		assertEquals(1, i);
		i = g.getLeaf(0).getColor();
		assertEquals(2, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(9, i);
		i = g.getLeaf(3).getColor();
		assertEquals(1, i);
		//PrintGraph.printListWithColors_Star(g);
	}
/**
	@Test
	public void test4Diam1() throws Exception
	{
		g = new UserInputGraph("T5_Graph");
		knownFourDiamTree(g, 0);
		//PrintGraph.printListWithColors_ZeroFirst(g);
		int i = g.getLeaf(6).getColor();
		assertEquals(4, i);
		i = g.getLeaf(11).getColor();
		assertEquals(1, i);
		i = g.getLeaf(5).getColor();
		assertEquals(2, i);
		i = g.getLeaf(0).getColor();
		assertEquals(6, i);
		i = g.getLeaf(7).getColor();
		assertEquals(5, i);
		i = g.getLeaf(16).getColor();
		assertEquals(1, i);
		i = g.getLeaf(3).getColor();
		assertEquals(3, i);
		i = g.getLeaf(4).getColor();
		assertEquals(1, i);
		i = g.getLeaf(2).getColor();
		assertEquals(2, i);
	}*/
	
}
