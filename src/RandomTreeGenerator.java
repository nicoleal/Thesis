/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		RandomTreeGenerator
 * 			Extends Graph Class to build a RANDOM TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import java.util.Random;

public class RandomTreeGenerator extends Graph
{
	public static Random r1 = new Random();				// An instance of Random, for degree
	public static Random r2 = new Random();				// An instance of Random, for making neighbors
	
	/**
	 * makeRandom - constructs a random, non-cyclic tree
	 * 
	 * @param numNodes: the N of the tree
	 * @throws Exception
	 */
	public RandomTreeGenerator(int numNodes) throws Exception
	{
		super(numNodes);
		int degree = r1.nextInt(Graph.DEFAULT_DEGREE);
		graph[0] = new TreeNode(degree, 0);

		int parent;
		for (int i = 1; i < numNodes; i++)
		{
			setCounter(i);
			parent =  r2.nextInt(i);
			while (!((TreeNode) graph[parent]).canAddChildren());
			{
				parent =  r2.nextInt(i);
			}
			graph[i] = newNode(graph[parent].getNode(), degree);
		}
	}
}