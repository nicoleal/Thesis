/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Graph Class TEST CLASS
 * 			Some basic tests for the Graph Class and its sub-classes. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 31 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTest extends Graph
{
	Graph g;
	
	@Test
	public void testCat1Tree1() throws Exception
	{
		g = new Caterpillar_T1(3);
		setNumNodes(3);
		int i = getNumNodes();
		assertEquals(3, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(2).getDegree();
		assertEquals(3, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testCat1Tree2() throws Exception
	{
		g = new Caterpillar_T1(20);
		int i = getNumNodes();
		assertEquals(20, i);
		i = getLeaf(10).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(11).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(12).getDegree();
		assertEquals(3, i);
		i = getLeaf(12).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(18).getMetNeighbors();
		assertEquals(2, i);
	}

	@Test
	public void testCat1Tree3() throws Exception
	{
		g = new Caterpillar_T1(80);
		int i = getNumNodes();
		assertEquals(80, i);
		i = getLeaf(60).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(51).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(32).getDegree();
		assertEquals(3, i);
		i = getLeaf(78).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(32).getMetNeighbors();
		assertEquals(3, i);
	}
	
	@Test
	public void testCat2Tree1() throws Exception
	{
		g = new Caterpillar_T2(7);
		int i = getNumNodes();
		assertEquals(7, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(3).getDegree();
		assertEquals(4, i);
		i = getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testCat2Tree2() throws Exception
	{
		g = new Caterpillar_T2(17);
		int i = getNumNodes();
		assertEquals(17, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(16).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testLob1Tree1() throws Exception
	{
		g = new Lobster_T1(7);
		int i = getNumNodes();
		assertEquals(7, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(3).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(5).getDegree();
		assertEquals(3, i);
		
	}
	
	@Test
	public void testLob1Tree2() throws Exception
	{
		g = new Lobster_T1(40);
		int i = getNumNodes();
		assertEquals(40, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(39).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(38).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(20).getDegree();
		assertEquals(3, i);
	}

	@Test
	public void testLob2Tree1() throws Exception
	{
		g = new Lobster_T1(10);
		int i = getNumNodes();
		assertEquals(10, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(5).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(7).getDegree();
		assertEquals(4, i);
	}

	@Test
	public void testLob2Graph2() throws Exception
	{
		g = new Lobster_T2(49);
		int i = getNumNodes();
		assertEquals(49, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(48).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(7).getDegree();
		assertEquals(4, i);
	}
	/**
	@Test
	public void testRand1() throws Exception
	{
		Tree t = t.buildRand(10);
	}
	
	@Test
	public void testRand2() throws Exception
	{
		Tree t = t.buildRand(50);
	}*/
	
	
	@Test
	public void testBinary1() throws Exception
	{
		g = new BinaryTree(10);
		int i = graph.length;
		assertEquals(10, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
	}

	@Test
	public void testBinary2() throws Exception
	{
		g = new BinaryTree(50);
		int i = graph.length;
		assertEquals(50, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = getLeaf(49).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(22).getMetNeighbors();
		assertEquals(3, i);
		i = getLeaf(30).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testSpine1() throws Exception
	{
		g = new Spine(10);
		int i = getLeaf(0).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
	}
	
	@Test
	public void testStar1() throws Exception
	{
		g = new Star(10);
		int i = getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = getLeaf(0).getMetNeighbors();
		assertEquals(9, i);
		i = getLeaf(8).getMetNeighbors();
		assertEquals(1, i);
	}
}
