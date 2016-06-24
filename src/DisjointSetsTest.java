/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		DisjointSets Class TEST CLASS
 * 			Some basic tests for the DisjointSets Class.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 24 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class DisjointSetsTest extends DisjointSets
{
	DisjointSets d;
	
	@Test
	public void testConstructor1() 
	{
		d = new DisjointSets(20);
		int i = d.setsArray[0];
		assertEquals(-1, i);
		i++;
		i = d.setsArray[19];
		assertEquals(-1, i);
		i++;
		i = d.setsArray[7];
		assertEquals(-1, i);
		i++;
		i = d.setsArray[13];
		assertEquals(-1, i);
	}

	@Test
	public void testConstructor2() 
	{
		d = new DisjointSets();
		int i = d.setsArray[0];
		assertEquals(-1, i);
		i++;
		i = d.setsArray[9];
		assertEquals(-1, i);
		i++;
		i = d.setsArray[7];
		assertEquals(-1, i);
		i++;
		i = d.setsArray[3];
		assertEquals(-1, i);
	}
	
	@Test
	public void testAll() 
	{
		d = new DisjointSets(12);
		d.union(5, 9);
		//d.print();
		int i = d.setsArray[5];
		assertEquals(-1, i);
		i = d.setsArray[9];
		assertEquals(5, i);
		i++;
		d.union(9, 0);
		i = d.setsArray[0];
		assertEquals(5, i);
		i++;
		d.union(0, 3);
		i = d.setsArray[3];
		assertEquals(5, i);
		d.union(6, 5);
		i = d.setsArray[9];
		assertEquals(5, i);
		d.findParent(9);
		i = d.setsArray[9];
		assertEquals(6, i);
		i++;
		d.findParent(3);
		i = d.setsArray[3];
		assertEquals(6, i);
		i = d.setsArray[0];
		assertEquals(5, i);
		d.findParent(0);
		i = d.setsArray[0];
		assertEquals(6, i);
		d.union(9, 10);
		d.union(8, 11);
		d.print();
		d.makeSet(0);
		i = d.setsArray[0];
		assertEquals(-1, i);
	}
}
