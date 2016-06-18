/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Star Class
 * 			Extends Graph Class to build a STAR TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Star extends Graph
{
	private static int DEGREE = 1;
	
	/**buildStar - builds a STAR GRAPH. Which is to say 1 central node 
	 * 		with (n - 1) leaves branching from it.
	 * 
	 * @param numNodes: the desired N of the graph
	 * @throws Exception
	 */
	public Star(int numNodes) throws Exception
	{
		super(numNodes);
		setNumNodes(numNodes);
		graph = new Node[numNodes];
		
		graph[0] = new Node((numNodes - DEGREE), 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			setCounter(getCounter() + 1);
			graph[i] = newNode(graph[0], DEGREE);
			makeLeaf(i);
		}
	}
}