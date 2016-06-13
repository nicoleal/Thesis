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

public class GraphTest 
{
	Node root;
	Tree tree;
	
	@Test
	public void testCat1Tree1() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildCat1(3);
		int i = t.getNumNodes();
		assertEquals(3, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getDegree();
		assertEquals(3, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testCat1Tree2() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildCat1(20);
		int i = t.getNumNodes();
		assertEquals(20, i);
		i = Graph.getLeaf(10).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(11).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(12).getDegree();
		assertEquals(3, i);
		i = Graph.getLeaf(12).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(18).getMetNeighbors();
		assertEquals(2, i);
	}

	@Test
	public void testCat1Tree3() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildCat1(80);
		int i = t.getNumNodes();
		assertEquals(80, i);
		i = Graph.getLeaf(60).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(51).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(32).getDegree();
		assertEquals(3, i);
		i = Graph.getLeaf(78).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(32).getMetNeighbors();
		assertEquals(3, i);
	}
	
	@Test
	public void testCat2Tree1() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildCat2(7);
		int i = t.getNumNodes();
		assertEquals(7, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(3);
		assertEquals(false, b);
		i = Graph.getLeaf(3).getDegree();
		assertEquals(4, i);
		i = Graph.getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testCat2Tree2() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildCat2(17);
		int i = t.getNumNodes();
		assertEquals(17, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(1).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(3);
		assertEquals(false, b);
		i = Graph.getLeaf(16).getMetNeighbors();
		assertEquals(1, i);
	}
	
	@Test
	public void testLob1Tree1() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildLob1(7);
		int i = t.getNumNodes();
		assertEquals(7, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(3).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(4);
		assertEquals(false, b);
		i = Graph.getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(5).getDegree();
		assertEquals(3, i);
		
	}
	
	@Test
	public void testLob1Tree2() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildLob1(40);
		int i = t.getNumNodes();
		assertEquals(40, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(39).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(32);
		assertEquals(false, b);;
		i = Graph.getLeaf(38).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(20).getDegree();
		assertEquals(3, i);
	}

	@Test
	public void testLob2Tree1() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildLob2(10);
		int i = t.getNumNodes();
		assertEquals(10, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(5).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(7);
		assertEquals(false, b);
		i = Graph.getLeaf(7).getDegree();
		assertEquals(4, i);
	}

	@Test
	public void testLob2Graph2() throws Exception
	{
		Graph t = new Graph();
		t = Graph.buildLob2(49);
		int i = t.getNumNodes();
		assertEquals(49, i);
		i = Tree.getRoot().getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(48).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(28);
		assertEquals(false, b);
		i = Graph.getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(7).getDegree();
		assertEquals(4, i);
	}
	/**
	@Test
	public void testRand1() throws Exception
	{
		Tree t = new Tree();
		t.buildRand(10);
	}
	
	
	@Test
	public void testRand2() throws Exception
	{
		Tree t = new Tree();
		t.buildRand(50);
	}
	*/
	@Test
	public void testInput1() throws Exception
	{
		Tree t = new Tree();
		t.buildInput("InputTest1");
	}
	
	@Test
	public void testBinary1() throws Exception
	{
		Tree t = new Tree();
		t.buildBinary(10);
		int i = Graph.getGraph().length;
		assertEquals(10, i);
		i = Tree.getRoot().getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(6).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(3);
		assertEquals(false, b);
	}

	@Test
	public void testBinary2() throws Exception
	{
		Tree t = new Tree();
		t.buildBinary(50);
		int i = Graph.getGraph().length;
		assertEquals(50, i);
		i = Graph.getLeaf(0).getMetNeighbors();
		assertEquals(2, i);
		i = Graph.getLeaf(49).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(22).getMetNeighbors();
		assertEquals(3, i);
		i = Graph.getLeaf(30).getMetNeighbors();
		assertEquals(1, i);
		Boolean b = Helper.isLeaf(15);
		assertEquals(false, b);
		b = Helper.isLeaf(31);
		assertEquals(true, b);
	}
	
	@Test
	public void testSpine1() throws Exception
	{
		Tree t = new Tree();
		t.buildSpine(10);
		int i = t.getNumNodes();
		assertEquals(10, i);
		i = Tree.getRoot().getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(9).getMetNeighbors();
		assertEquals(1, i);
		i = Graph.getLeaf(2).getMetNeighbors();
		assertEquals(2, i);
		Boolean b = Helper.isLeaf(3);
		assertEquals(false, b);
		b = Helper.isLeaf(9);
		assertEquals(true, b);
	}
}
