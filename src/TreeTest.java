/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Tree Class TEST CLASS
 * 			Some basic tests for the Tree Class. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 15 February 2016
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

}
