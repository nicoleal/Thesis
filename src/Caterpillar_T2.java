/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Caterpillar_T2 Class
 * 			Extends Graph Class to build a T2 CATERPILLAR TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Caterpillar_T2 extends Graph
{
	private static final int T2_DEGREE = 4;
	
	/**
	 * buildCat2 - builds a CATERPILLAR GRAPH of TYPE 2. Which is to say a 
	 * 		graph where any vertex v is no more than 1 edge away from the
	 * 		spine AND all vertices have no more than degree-4. The degree-4
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a ternary tree with two leaf nodes
	 * 		and one non-leaf-node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param numNodes: the desired N of the graph
	 * @throws Exception
	 */
	public Caterpillar_T2(int numNodes) throws Exception
	{
		super(numNodes);
		setNumNodes(numNodes);
		setGraphDegree(T2_DEGREE);
		graph[0] = new Node(T2_DEGREE, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			int j = i % 3;
			
			if (j == 0)
			{
				graph[i] = newNode(graph[i - 3].getNode(), T2_DEGREE);
			}
			else 
			{
				graph[i] = newNode(graph[i - j].getNode(), T2_DEGREE);
				makeLeaf(i);
			}
			setCounter(getCounter() + 1);
		}
	}
}