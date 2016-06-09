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

public class RandomGraphGenerator
{
	public static Random r1 = new Random();				// An instance of Random, for degree
	public static Random r2 = new Random();				// An instance of Random, for making neighbors
	
	/**
	 * makeRandom - constructs a random, non-cyclic graph
	 * 
	 * @param numNodes: the N of the graph
	 * @return the generated graph
	 * @throws Exception
	 */
	protected static Graph makeRandom(int numNodes) throws Exception
	{
		int degree = r1.nextInt(Graph.DEFAULT_DEGREE);
		Graph g = new Graph(numNodes, degree);
		g.graph[0] = new Node(degree, 0);

		int sponsor;
		for (int i = 1; i < numNodes; i++)
		{
			g.setCounter(i);
			sponsor =  r2.nextInt(i);
			while (!g.graph[sponsor].canAddNeighbors());
			{
				sponsor =  r2.nextInt(i);
			}
			g.graph[i] = Graph.newNode(g.graph[sponsor].getNode(), degree);
		}
		
		//PrintGraph.printList(t, numNodes);
		//PrintGraph.printToFile(t, numNodes, "OutputTest2");
		
		return g;
	}
	
	/**
	 * makeRandom - constructs a random, non-cyclic tree
	 * 
	 * @param numNodes: the N of the tree
	 * @return the generated graph
	 * @throws Exception
	 */
	protected static Tree makeRandomTree(int numNodes) throws Exception
	{
		int degree = r1.nextInt(Graph.DEFAULT_DEGREE);
		Tree t = new Tree(numNodes, degree);
		t.graph[0] = new TreeNode(degree, 0);

		int parent;
		for (int i = 1; i < numNodes; i++)
		{
			t.setCounter(i);
			parent =  r2.nextInt(i);
			while (!((TreeNode) t.graph[parent]).canAddChildren());
			{
				parent =  r2.nextInt(i);
			}
			t.graph[i] = Tree.newNode(t.graph[parent].getNode(), degree);
		}
		
		//PrintGraph.printList(t, numNodes);
		//PrintGraph.printToFile(t, numNodes, "OutputTest2");
		
		return t;
	}
}
