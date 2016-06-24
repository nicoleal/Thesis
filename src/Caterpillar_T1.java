/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Caterpillar_T1 Class
 * 			Extends Graph Class to build a T1 CATERPILLAR TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Caterpillar_T1 extends Graph
{
	private static final int T1_DEGREE = 3;
	
	/**
	 * buildCat1 - builds a CATERPILLAR GRAPH of TYPE 1. Which is to say a 
	 * 		graph where any vertex v is no more than 1 edge away from the
	 * 		spine AND all vertices have no more than degree-3. The degree-3
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a binary tree with one leaf node
	 * 		and one non-leaf-node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param numNodes: the desired N of the graph
	 * @throws Exception
	 */
	public Caterpillar_T1 (int numNodes) throws Exception
	{
		super(numNodes);
		setNumNodes(numNodes);
		setGraphDegree(T1_DEGREE);
		graph[0] = new Node(T1_DEGREE, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			setCounter(getCounter() + 1);
			if (Colorings.isOdd(i))
			{
				graph[i] = newNode(graph[i - 1].getNode(), T1_DEGREE);
				makeLeaf(i);
			}
			else
			{
				graph[i] = newNode(graph[i - 2].getNode(), T1_DEGREE);
			}
		}
	}	
}