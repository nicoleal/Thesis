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
