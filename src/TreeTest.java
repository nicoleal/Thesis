/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Tree Class TEST CLASS
 * 			Some basic tests for the Tree Class and its sub-graphs. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 31 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TreeTest 
{
	Node root;
	Tree tree;

	@Test
	public void testRoot() 
	{
		Tree t = new Tree();
		t.makeRoot(t, 3, 3);
		int i = t.getNumNodes(t);
		assertEquals(3, i);
		i = t.getRoot(t).getKids();
		assertEquals(0, i);
		i = t.getTreeDegree(t);
		assertEquals(3, i);
		i = t.getRoot(t).getName();
		assertEquals(0, i);
		i = t.getTree(t).length;
		assertEquals(3, i);
	}
	
	@Test
	public void testCat1Tree1() throws Exception
	{
		Tree t = new Tree();
		t.buildCat1(t, 3);
		int i = t.getNumNodes(t);
		assertEquals(3, i);
		i = t.getRoot(t).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 1).getAllKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 1).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 1).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 2).getMaxKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 2).getDegree();
		assertEquals(3, i);
		i = t.getLeaf(t, 2).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 2).getKids();
		assertEquals(0, i);
	}
	
	@Test
	public void testCat1Tree2() throws Exception
	{
		Tree t = new Tree();
		t.buildCat1(t, 20);
		int i = t.getNumNodes(t);
		assertEquals(20, i);
		i = t.getLeaf(t, 10).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 11).getAllKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 11).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 11).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 12).getMaxKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 12).getDegree();
		assertEquals(3, i);
		i = t.getLeaf(t, 12).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 12).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 18).getKids();
		assertEquals(1, i);
	}

	@Test
	public void testCat1Tree3() throws Exception
	{
		Tree t = new Tree();
		t.buildCat1(t, 80);
		int i = t.getNumNodes(t);
		assertEquals(80, i);
		i = t.getLeaf(t, 60).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 51).getAllKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 51).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 51).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 32).getMaxKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 32).getDegree();
		assertEquals(3, i);
		i = t.getLeaf(t, 32).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 32).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 78).getKids();
		assertEquals(1, i);
		i = t.getLeaf(t, 78).getDepth();
		assertEquals(0, i);
		i = t.getLeaf(t, 79).getDepth();
		assertEquals(1, i);
	}
	
	@Test
	public void testCat2Tree1() throws Exception
	{
		Tree t = new Tree();
		t.buildCat2(t, 7);
		int i = t.getNumNodes(t);
		assertEquals(7, i);
		i = t.getRoot(t).getKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 1).getAllKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 1).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 1).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 3);
		assertEquals(false, b);
		i = t.getLeaf(t, 3).getDegree();
		assertEquals(4, i);
		i = t.getLeaf(t, 3).getAllKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 6).getKids();
		assertEquals(0, i);
	}
	
	@Test
	public void testCat2Tree2() throws Exception
	{
		Tree t = new Tree();
		t.buildCat2(t, 17);
		int i = t.getNumNodes(t);
		assertEquals(17, i);
		i = t.getRoot(t).getKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 1).getAllKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 1).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 1).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 3);
		assertEquals(false, b);
		i = t.getLeaf(t, 3).getDegree();
		assertEquals(4, i);
		i = t.getLeaf(t, 3).getAllKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 16).getKids();
		assertEquals(0, i);
	}
	
	@Test
	public void testLob1Tree1() throws Exception
	{
		Tree t = new Tree();
		t.buildLob1(t, 7);
		int i = t.getNumNodes(t);
		assertEquals(7, i);
		i = t.getRoot(t).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 1).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 2).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 3).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 4);
		assertEquals(false, b);
		i = t.getLeaf(t, 4).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 6).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 5).getDegree();
		assertEquals(3, i);
		
	}
	
	@Test
	public void testLob1Tree2() throws Exception
	{
		Tree t = new Tree();
		t.buildLob1(t, 40);
		int i = t.getNumNodes(t);
		assertEquals(40, i);
		i = t.getRoot(t).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 21).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 22).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 39).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 32);
		assertEquals(false, b);
		i = t.getLeaf(t, 24).getAllKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 38).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 20).getDegree();
		assertEquals(3, i);
	}

	@Test
	public void testLob2Tree1() throws Exception
	{
		Tree t = new Tree();
		t.buildLob2(t, 10);
		int i = t.getNumNodes(t);
		assertEquals(10, i);
		i = t.getRoot(t).getKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 1).getAllKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 3).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 5).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 7);
		assertEquals(false, b);
		i = t.getLeaf(t, 7).getAllKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 9).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 7).getDegree();
		assertEquals(4, i);
	}

	@Test
	public void testLob2Tree2() throws Exception
	{
		Tree t = new Tree();
		t.buildLob2(t, 49);
		int i = t.getNumNodes(t);
		assertEquals(49, i);
		i = t.getRoot(t).getKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 22).getAllKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 23).getMaxKids();
		assertEquals(-1, i);
		i = t.getLeaf(t, 48).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 28);
		assertEquals(false, b);
		i = t.getLeaf(t, 21).getAllKids();
		assertEquals(3, i);
		i = t.getLeaf(t, 9).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 7).getDegree();
		assertEquals(4, i);
	}

	@Test
	public void testRand1() throws Exception
	{
		Tree t = new Tree();
		t.buildRand(t, 10);
	}
	
	
	@Test
	public void testRand2() throws Exception
	{
		Tree t = new Tree();
		t.buildRand(t, 50);
	}
	
	@Test
	public void testInput1() throws Exception
	{
		Tree t = new Tree();
		t.buildInput(t, "InputTest1");
	}
	
	@Test
	public void testBinary1() throws Exception
	{
		Tree t = new Tree();
		t.buildBinary(t, 10);
		int i = t.getNumNodes(t);
		assertEquals(10, i);
		i = t.getRoot(t).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 9).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 2).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 6).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 3);
		assertEquals(false, b);
	}

	@Test
	public void testBinary2() throws Exception
	{
		Tree t = new Tree();
		t.buildBinary(t, 50);
		int i = t.getNumNodes(t);
		assertEquals(50, i);
		i = t.getRoot(t).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 49).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 22).getKids();
		assertEquals(2, i);
		i = t.getLeaf(t, 30).getKids();
		assertEquals(0, i);
		Boolean b = t.isLeaf(t, 15);
		assertEquals(false, b);
		b = t.isLeaf(t, 31);
		assertEquals(true, b);
	}
	
	@Test
	public void testSpine1() throws Exception
	{
		Tree t = new Tree();
		t.buildSpine(t, 10);
		int i = t.getNumNodes(t);
		assertEquals(10, i);
		i = t.getRoot(t).getKids();
		assertEquals(1, i);
		i = t.getLeaf(t, 9).getKids();
		assertEquals(0, i);
		i = t.getLeaf(t, 2).getKids();
		assertEquals(1, i);
		Boolean b = t.isLeaf(t, 3);
		assertEquals(false, b);
		b = t.isLeaf(t, 9);
		assertEquals(true, b);
	}
}
