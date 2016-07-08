<<<<<<< HEAD
/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		ApproximationOne Class TEST CLASS
 * 			Some basic tests for the ApproximationOne Class,
 * 			a.k.a. THE DISJOINT SETS METHOD.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 1 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ApproximationOneTest extends ApproximationOne
{
	ApproximationOne a;
	Graph g;
	
	@Test
	public void testDefault() throws Exception 
	{
		a = new ApproximationOne();
		int i = a.getSetsArray().length;
		assertEquals(10, i);
		i =  a.getSetsArray()[9];
		assertEquals(-1, i);
		i++;
		i =  a.getSetsArray()[3];
		assertEquals(-1, i);
		i++;
		i =  a.getSetsArray()[0];
		assertEquals(-1, i);
	}

	@Test
	public void testInput() throws Exception
	{
		g = new Caterpillar_T1(20);
		a = new ApproximationOne(g);
		int i = a.getSetsArray().length;
		assertEquals(20, i);
		i =  a.getSetsArray()[19];
		assertEquals(-1, i);
		i++;
		i =  a.getSetsArray()[3];
		assertEquals(-1, i);
		i++;
		i =  a.getSetsArray()[11];
		assertEquals(-1, i);
	}
	
	@Test
	public void testDegree() throws Exception
	{
		g = new Spine(10);
		a = new ApproximationOne(g);
		a.findDegree(g);
		int i = a.getSetsArray().length;
		assertEquals(10, i);
		i =  a.getNeighborhoodArray()[0];
		assertEquals(1, i);
		i =  a.getNeighborhoodArray()[1];
		assertEquals(2, i);
		i =  a.getNeighborhoodArray()[9];
		assertEquals(1, i);
		i =  a.getNeighborhoodArray()[8];
		assertEquals(2, i);
	}
	
	@Test
	public void testHighest() throws Exception
	{
		g = new Caterpillar_T2(20);
		a = new ApproximationOne(g);
		a.findDegree(g);
		int i = a.getSetsArray().length;
		assertEquals(20, i);
		i =  a.getNeighborhoodArray()[0];
		assertEquals(3, i);
		i =  a.getNeighborhoodArray()[1];
		assertEquals(1, i);
		i =  a.getNeighborhoodArray()[3];
		assertEquals(4, i);
		i =  a.getNeighborhoodArray()[2];
		assertEquals(1, i);
		i =  a.getNeighborhoodArray()[9];
		assertEquals(4, i);
		i = a.findHighestDegree(0);
		assertEquals(3, i);
		i = a.getNeighborhoodArray()[a.findHighestDegree(0)];
		assertEquals(4, i);
		i = a.findHighestDegree(4);
		assertEquals(6, i);
		i = a.getNeighborhoodArray()[a.findHighestDegree(4)];
		assertEquals(4, i);
		i = a.findHighestDegree(-1);
		assertEquals(-1, i);
		i = a.findHighestDegree(16);
		assertEquals(18, i);
		i = a.findHighestDegree(20);
		assertEquals(-1, i);
	}
	
}
=======
/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		ApproximationOne Class TEST CLASS
 * 			Some basic tests for the ApproximationOne Class,
 * 			a.k.a. THE DISJOINT SETS METHOD.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 1 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class ApproximationOneTest extends ApproximationOne
{
	Graph g;

	@Test
	public void test() throws Exception 
	{
		g = new Caterpillar_T1(20);
		disjointSetMethod(g);
	}

}
>>>>>>> origin/master
