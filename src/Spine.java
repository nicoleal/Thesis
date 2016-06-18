/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Spine Class
 * 			Extends Graph Class to build a SPINE TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Spine extends Graph
{
	private static final int DEGREE = 2;
	
	/**SpineBinary - builds a SPINE GRAPH. Which is to say line of nodes 
	 * 		with a root of zero and at most one child.
	 * 
	 * @param numNodes: the desired N of the graph
	 * @return the new SPINE GRAPH with length N
	 * @throws Exception
	 */
	public Spine(int numNodes) throws Exception
	{
		super(numNodes, DEGREE);
		setNumNodes(numNodes);
		setGraphDegree(DEGREE);
		graph = new Node[numNodes];
		
		graph[0] = new Node(DEGREE, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			graph[i] = newNode(graph[(i - 1)], DEGREE);
			setCounter(getCounter() + 1);
		}
	}
}
