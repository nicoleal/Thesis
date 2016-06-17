/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Node Class TEST CLASS
 * 			Some basic tests for the Node Class.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 15 February 2016
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
	public void testNode1() throws Exception 
	{
		int i = node1.getMetNeighbors();
		assertEquals(0, i);
		i = node1.getColor();
		assertEquals(0, i);
		node1.addNeighbor(node3);
		i = node1.getDegree();
		assertEquals(20, i);
		i = node1.getMetNeighbors();
		assertEquals(1, i);
		i = node1.neighbors.length;
		assertEquals(20, i);
		i = node1.getName();
		assertEquals(1, i);
		node1.emptyNeighborhood(node1);
		boolean b = node1.hasNeighbors();
		assertEquals(false, b);
		b = node1.canAddNeighbors();
		assertEquals(true, b);
	}
	
	@Test
	public void testNode2()
	{
		int i = node2.getDegree();
		assertEquals(20, i);
		i = node2.getColor();
		assertEquals(0, i);
		i = node2.getMetNeighbors();
		assertEquals(0, i);
		i = node2.getDegree();
		assertEquals(20, i);
		i = node2.getName();
		assertEquals(2, i);
		boolean b = node2.canAddNeighbors();
		assertEquals(true, b); 
		b = node2.hasNeighbors();
		assertEquals(false, b);
	}
	
	@Test
	public void testNodes1and2() throws Exception
	{
		node1.addNeighbor(node2);
		int i = node1.getDegree();
		assertEquals(20, i);
		i = node1.getColor();
		assertEquals(0, i);
		i = node1.getDegree();
		assertEquals(20, i);
		i = node1.getMetNeighbors();
		assertEquals(1, i);
		i = node1.getName();
		assertEquals(1, i);
		boolean b = node1.hasNeighbors();
		assertEquals(true, b);
		b = !node1.canAddNeighbors();
		assertEquals(false, b);
	}

	@Test
	public void testNode3()
	{
		int i = node3.getDegree();
		assertEquals(3, i);
		i = node3.getColor();
		assertEquals(0, i);
		i = node3.getDegree();
		assertEquals(3, i);
		i = node3.getName();
		assertEquals(3, i);
		i = node3.getMetNeighbors();
		assertEquals(0, i);
		boolean b = node3.hasNeighbors();
		assertEquals(false, b);
		b = node3.canAddNeighbors();
		assertEquals(true, b);
	}
	
	@Test
	public void testNode4()
	{
		int i = node4.getDegree();
		assertEquals(3, i);
		i = node4.getColor();
		assertEquals(0, i);
		i = node4.getDegree();
		assertEquals(3, i);
		i = node4.getName();
		assertEquals(4, i);
		i = node4.getMetNeighbors();
		assertEquals(0, i);
		boolean b = node4.hasNeighbors();
		assertEquals(false, b);
		b = node4.canAddNeighbors();
		assertEquals(true, b);
	}
	
	@Test(expected = Exception.class)
	public void exception2() throws Exception
	{
		ExpectedException thrown = ExpectedException.none();
		node8.addNeighbor(node6);
		node8.addNeighbor(node7);
		thrown.expect(Exception.class);
		thrown.expectMessage("This node is already at its max degree.");
		node8.emptyNeighborhood(node8);
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
		int[] c = new int[2];
		c[0] = node6.getName();
		c[1] = node5.getName();
		node1.emptyNeighborhood(node1);
		node1.addNeighbors(c);
		int i = node1.getMetNeighbors();
		assertEquals(2, i);
	}
	
	@Test
	public void exception5() throws Exception
	{
		node1.addNeighbor(node2);
		boolean b = node1.hasNeighbors();
		assertEquals(b, true);
		node1.kill(node2);
		b = node1.hasNeighbors();
		assertEquals(b, false);
		node1.setDegree(10);
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
	
	@Test
	public void testCopy() throws CloneNotSupportedException
	{
		Node node11 = new Node(11);
		int[] array1 = new int[3];
		array1[0] = 11;
		array1[1] = 12;
		array1[2] = 13;
		
		int[] array2 = node11.copyNeighbors(array1, 3, 3);
		assertEquals(11, array2[0]);
	}
	
	@Test
	public void testAddKids() throws Exception
	{
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
				
		node1.emptyNeighborhood(node1);
		node1.addNeighbor(node11);
		node1.addNeighbor(node12);
		node1.addNeighbor(node13);
		int i = node1.getMetNeighbors();
		assertEquals(3, i);
		i = node1.getDegree();
		assertEquals(20, i);
		
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		int[] array1 = new int[3];
		array1[0] = node14.getName();
		array1[1] = node15.getName();
		array1[2] = node16.getName();
		
		node1.addNeighbors(array1);
		i = node1.getMetNeighbors();
		assertEquals(6, i);
		i = node1.getDegree();
		assertEquals(20, i);
		node1.kill(node16);
		i = node1.getMetNeighbors();
		assertEquals(5, i);
		node1.emptyNeighborhood(node1);
	}
	
	@Test
	public void testCivilWar() throws CloneNotSupportedException
	{
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		int[] array1 = new int[6];
		array1[0] = node11.getName();
		array1[1] = node12.getName();
		array1[2] = node13.getName();
		array1[3] = node14.getName();
		array1[4] = node15.getName();
		array1[5] = node16.getName();
		node1.emptyNeighborhood(node1);
		node1.addNeighbors(array1);
		int i = node1.getMetNeighbors();
		assertEquals(6, i);
		
		int[] array2 = node1.newNeighborhood(4);
		i = node1.getMetNeighbors();
		assertEquals(4, i);
		i = array2.length;
		assertEquals(20, i);
		i = array2[2];
		assertEquals(0, i);
		
		node1.emptyNeighborhood(node1);
	}
	
	@Test
	public void testSingle() throws CloneNotSupportedException
	{
		Node node11 = new Node(11);
		int i = node11.getDegree();
		assertEquals(20, i);
		node11.leaf();
		i = node11.getMetNeighbors();
		assertEquals(1, i);
		i = node11.getMetNeighbors() + 1;
		assertEquals(2, i);
		i = node11.getDegree();
		assertEquals(1, i);
	}
		
	@Test
	public void testString()
	{
		Node node11 = new Node(11);
		node11.setColor(5);
		//String s = node11.toString();
		//System.out.println(s);
		Node node12 = new Node(12);
		node12.setColor(17);
		//s = node12.toString();
		//System.out.println(s);
	}
}