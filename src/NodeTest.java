/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Node Class TEST CLASS
 * 			Some basic tests for the Node Class
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 14 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NodeTest 
{
	public Node node1 = new Node(1);
	public Node node2 = new Node(node1, 2);
	public Node node3 = new Node(3, 3);
	public Node node4 = new Node(node3, 3, 4);
	public Node node5 = new Node(5, 1);
	public Node node6 = new Node(6);
	public Node node7 = new Node(7);
	public Node node8 = new Node(1, 8);
	
	@Test
	public void testNode1() 
	{
		int i = node1.getDegree();
		assertEquals(20, i);
		i = node1.getColor();
		assertEquals(0, i);
		i = node1.getAllKids();
		assertEquals(20, i);
		i = node1.getDepth();
		assertEquals(0, i);
		i = node1.getMaxKids();
		assertEquals(20, i);
		i = node1.getKids();
		assertEquals(0, i);
		i = node1.getName();
		assertEquals(1, i);
		Boolean b = node1.hasKids();
		assertEquals(false, b);
		b = node1.canHaveKids();
		assertEquals(true, b);
		b = node1.hasParent();
		assertEquals(false, b);
	}
	
	@Test
	public void testNode2()
	{
		int i = node2.getDegree();
		assertEquals(20, i);
		i = node2.getColor();
		assertEquals(0, i);
		i = node2.getAllKids();
		assertEquals(19, i);
		i = node2.getDepth();
		assertEquals(1, i);
		i = node2.getMaxKids();
		assertEquals(19, i);
		i = node2.getKids();
		assertEquals(0, i);
		i = node2.getName();
		assertEquals(2, i);
		Boolean b = node2.canHaveKids();
		assertEquals(true, b); 
		b = node2.hasKids();
		assertEquals(false, b);
		b = node2.hasParent();
		assertEquals(true, b);
	}
	
	@Test
	public void testNodes1and2() throws Exception
	{
		node1.addChild(node2);
		int i = node1.getDegree();
		assertEquals(20, i);
		i = node1.getColor();
		assertEquals(0, i);
		i = node1.getAllKids();
		assertEquals(20, i);
		i = node1.getDepth();
		assertEquals(0, i);
		i = node1.getMaxKids();
		assertEquals(20, i);
		i = node1.getKids();
		assertEquals(1, i);
		i = node1.getName();
		assertEquals(1, i);
		Boolean b = node1.hasKids();
		assertEquals(true, b);
		b = node1.hasParent();
		assertEquals(false, b);
		b = node1.canHaveKids();
		assertEquals(true, b);
	}

	@Test
	public void testNode3()
	{
		int i = node3.getDegree();
		assertEquals(3, i);
		i = node3.getColor();
		assertEquals(0, i);
		i = node3.getAllKids();
		assertEquals(3, i);
		i = node3.getDepth();
		assertEquals(0, i);
		i = node3.getMaxKids();
		assertEquals(3, i);
		i = node3.getName();
		assertEquals(3, i);
		i = node3.getKids();
		assertEquals(0, i);
		Boolean b = node3.hasKids();
		assertEquals(false, b);
		b = node3.canHaveKids();
		assertEquals(true, b);
		b = node3.hasParent();
		assertEquals(false, b);	
	}
	
	@Test
	public void testNode4()
	{
		int i = node4.getDegree();
		assertEquals(3, i);
		i = node4.getColor();
		assertEquals(0, i);
		i = node4.getAllKids();
		assertEquals(2, i);
		i = node4.getDepth();
		assertEquals(1, i);
		i = node4.getMaxKids();
		assertEquals(2, i);
		i = node4.getName();
		assertEquals(4, i);
		i = node4.getKids();
		assertEquals(0, i);
		Boolean b = node4.hasParent();
		assertEquals(true, b);
		b = node4.hasKids();
		assertEquals(false, b);
		b = node4.canHaveKids();
		assertEquals(true, b);
	}
	
	@Test
	public void testAllNodes() throws Exception
	{
		node1.addChild(node2);
		node3.addChild(node4);
		Boolean b = node1.hasParent();
		assertEquals(false, b);
		b = node2.hasParent();
		assertEquals(true, b);
		b = node3.hasParent();
		assertEquals(false, b);
		b = node4.hasParent();
		assertEquals(true, b);
		node7.addChild(node3);
		node3.setParent(node7);
		node4.setDepth(node4.getDepth() + 1);
		int i = node4.getDepth();
		assertEquals(2, i);
		i = node3.getDepth();
		assertEquals(1, i);
		b = node1.hasParent();
		assertEquals(false, b);
		b = node3.hasParent();
		assertEquals(true, b);
		node7.prune(node7);
		node3.orphan(node3);
	}
	
	@Test(expected = Exception.class)
	public void exception1() throws Exception
	{
		ExpectedException thrown = ExpectedException.none();
		node4.setParent(node1);
		thrown.expect(Exception.class);
		thrown.expectMessage("This node already has a parent.");
	}
	
	@Test(expected = Exception.class)
	public void exception2() throws Exception
	{
		ExpectedException thrown = ExpectedException.none();
		node8.addChild(node6);
		node8.addChild(node7);
		thrown.expect(Exception.class);
		thrown.expectMessage("This node is already at its max degree.");
		node8.prune(node8);
	}

	@Test
	public void exception3()
	{
		node7.setName(111);
		int i = node7.getName();
		assertEquals(111, i);
		node7.setName(7);
	}
	
	@Test
	public void exception4() throws CloneNotSupportedException
	{
		Node[] c = new Node[2];
		c[0] = node6;
		c[1] = node5;
		node1.prune(node1);
		node1.addChildren(c);
		int i = node1.getKids();
		assertEquals(2, i);
	}
	
	@Test
	public void exception5() throws Exception
	{
		node1.addChild(node2);
		Boolean b = node1.hasKids();
		assertEquals(b, true);
		node1.kill(node2);
		b = node1.hasKids();
		assertEquals(b, false);
		node1.setDegree(10, false);
		int i = node1.getDegree();
		assertEquals(10, i);
		node1.setColor(5);
		i = node1.getColor();
		assertEquals(5, i);
		node1.unColor();
		i = node1.getColor();
		assertEquals(0, i);
		node1 = node1.reset();
		i = node1.getDegree();
		assertEquals(20, i);
	}
}
