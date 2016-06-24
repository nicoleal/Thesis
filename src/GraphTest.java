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
		i = g.graph[0].getName();
		assertEquals(0, i);
		i = g.getLeaf(2).getDegree();
		assertEquals(3, i);
		i = g.getLeaf(2).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
	}
	
	@Test
	public void testCat1Tree2() throws Exception
	{
		g = new Caterpillar_T1(20);
		int i = g.getNumNodes();
		assertEquals(20, i);
		i = g.getLeaf(10).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(11).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(12).getDegree();
		assertEquals(3, i);
		i = g.getLeaf(12).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(18).getMetNeighbors();
		assertEquals(2, i);
	}

	@Test
	public void testCat1Tree3() throws Exception
	{
		g = new Caterpillar_T1(80);
		int i = g.getNumNodes();
		assertEquals(80, i);
		i = g.getLeaf(60).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(51).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(32).getDegree();
		assertEquals(3, i);
		i = g.getLeaf(78).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(32).getMetNeighbors();
		assertEquals(3, i);
	}
	
	@Test
	public void testCat2Tree1() throws Exception
	{
		g = new Caterpillar_T2(7);
		int i = g.getNumNodes();
		assertEquals(7, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(3).getDegree();
		assertEquals(4, i);
		i = g.getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testCat2Tree2() throws Exception
	{
		g = new Caterpillar_T2(17);
		int i = g.getNumNodes();
		assertEquals(17, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(16).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testLob1Tree1() throws Exception
	{
		g = new Lobster_T1(7);
		int i = g.getNumNodes();
		assertEquals(7, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(3).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(5).getDegree();
		assertEquals(3, i);
		
	}
	
	@Test
	public void testLob1Tree2() throws Exception
	{
		g = new Lobster_T1(40);
		int i = g.getNumNodes();
		assertEquals(40, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = g.getLeaf(39).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(38).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(20).getDegree();
		assertEquals(3, i);
	}

	@Test
	public void testLob2Tree1() throws Exception
	{
		g = new Lobster_T2(10);
		int i = g.getNumNodes();
		PrintGraph.printList(g);
		assertEquals(10, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(5).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(7).getDegree();
		assertEquals(4, i);
	}

	@Test
	public void testLob2Graph2() throws Exception
	{
		g = new Lobster_T2(49);
		int i = g.getNumNodes();
		assertEquals(49, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = g.getLeaf(48).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(7).getDegree();
		assertEquals(4, i);
	}
	/*
	@Test
	public void testRand1() throws Exception
	{
		g = new RandomGraphGenerator(30);
		PrintGraph.printList(g);
	}
	
	@Test
	public void testRand2() throws Exception
	{
		g = new RandomTreeGenerator(30);
		PrintGraph.printList(g);
	}*/
	
	
	@Test
	public void testBinary1() throws Exception
	{
		g = new BinaryTree(10);
		int i = g.graph.length;
		assertEquals(10, i);
		i = g.graph[0].getMetNeighbors();
		assertEquals(2, i);
		i = g.graph[9].getMetNeighbors();
		assertEquals(1, i);
		i = g.graph[2].getMetNeighbors();
		assertEquals(3, i);
		i = g.graph[6].getMetNeighbors();
		assertEquals(1, i);
	}

	@Test
	public void testBinary2() throws Exception
	{
		g = new BinaryTree(50);
		int i = g.graph.length;
		assertEquals(50, i);
		i = g.graph[0].getMetNeighbors();
		assertEquals(2, i);
		i = g.graph[49].getMetNeighbors();
		assertEquals(1, i);
		i = g.graph[22].getMetNeighbors();
		assertEquals(3, i);
		i = g.graph[30].getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testSpine1() throws Exception
	{
		g = new Spine(10);
		int i = g.getLeaf(0).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
	}
	
	@Test
	public void testStar1() throws Exception
	{
		g = new Star(10);
		int i = g.getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = g.getLeaf(0).getMetNeighbors();
		assertEquals(9, i);
		i = g.getLeaf(8).getMetNeighbors();
		assertEquals(1, i);
	}
}
