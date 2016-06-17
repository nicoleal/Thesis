/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Lobster_T1 Class
 * 			Extends Graph Class to build a T1 LOBSTER TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Lobster_T1 extends Graph
{
	private static final int T1_DEGREE = 3;
	
	/**
	 * buildLob1 - builds a LOBSTER GRAPH of TYPE 1. Which is to say a 
	 * 		graph where any vertex v is no more than 2 edges away from the
	 * 		spine AND all vertices have no more than degree-3. The degree-3
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a binary tree with 1 branching nodes
	 * 		and 1 spine node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param numNodes: the desired N of the graph
	 * @throws Exception
	 */
	public Lobster_T1(int numNodes) throws Exception
	{
		super(numNodes);
		graph[0] = new Node(T1_DEGREE, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			int j = i % 4;
			
			if (j == 0)
			{
				graph[i] = newNode(graph[i - 4].getNode(), T1_DEGREE);
			}
			else if (j == 1)
			{
				graph[i] = newNode(graph[i - j].getNode(), T1_DEGREE);
			}
			else
			{
				graph[i] = newNode(graph[(i - j + 1)].getNode(), T1_DEGREE);
				makeLeaf(i);
			}
			setCounter(getCounter() + 1);
		}
	}
}