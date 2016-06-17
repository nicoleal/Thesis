/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		RandomGraphGenerator Class
 * 			A subclass for random graphs working within the confines
 * 			described elsewhere in the TREE CLASS, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import java.util.Random;

public class RandomGraphGenerator extends Graph
{
	public static Random r1 = new Random();				// An instance of Random, for degree
	public static Random r2 = new Random();				// An instance of Random, for making neighbors
	
	/**
	 * makeRandom - constructs a random, non-cyclic graph
	 * 
	 * @param numNodes: the N of the graph
	 * @throws Exception
	 */
	public RandomGraphGenerator(int numNodes) throws Exception
	{
		super(numNodes);
		int degree = r1.nextInt(Graph.DEFAULT_DEGREE);
		setGraphDegree(degree);
		
		graph[0] = new Node(degree, 0);

		int sponsor;
		for (int i = 1; i < numNodes; i++)
		{
			setCounter(i);
			sponsor =  r2.nextInt(i);
			while (!graph[sponsor].canAddNeighbors());
			{
				sponsor =  r2.nextInt(i);
			}
			graph[i] = newNode(graph[sponsor].getNode(), degree);
		}
	}
}