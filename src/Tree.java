/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Tree Class
 * 			An implementation of the most general tree building class possible,
 * 			trying to maintain both code flexibility and consistency, allowing for
 * 			multiple types of trees to be built, but only one kind of tree to be
 * 			built at a time, et hoc genus omne.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 9 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Tree extends Graph
{


	/******************************************************************************
	 *                                                                            *
	 *							     CONSTRUCTORS                                 *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * NO-ARG CONSTRUCTOR for tree, which sets the counter to 0, the graphDegree and
	 * 		numNodes to their default values, and greats a Node array of length numNodes.
	 */
	public Tree()
	{
		super();
	}
	
	/**
	 * ONE-ARG CONSTRUCTOR for tree, which sets the counter to 0, the graphDegree 
	 * 		to its default values, numNodes to INPUT, and greats a Node array of 
	 * 		length numNodes.
	 * 
	 * @param numNodes: the length / total number of nodes in graph
	 */
	public Tree(int numNodes)
	{
		super(numNodes);
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for tree, which sets the counter to 0, the graphDegree and
	 * 		numNodes to their INPUT values, and greats a Node array of length numNodes.
	 * 
	 * @param numNodes: the length / total number of nodes in graph
	 * @param graphDegree: the maxDegree of any node in the graph
	 */
	public Tree(int numNodes, int graphDegree)
	{
		super(numNodes, graphDegree);
	}	
	
	/******************************************************************************
	 *                                                                            *
	 *							   DEFAULT GRAPHS                                 *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * buildBinary - builds a BINARY TREE. Which is to say a balanced and 
	 * 		complete tree with a root of zero and a numbering pattern similar 
	 * 		to binary heaps AND all vertices have no more than degree-3. The
	 * 		degree-3 requirement is built into the method and cannot be changed 
	 * 		without delving into the code. 
	 * 
	 * @param numNodes: the desired N of the tree
	 * @return the new BINARY TREE
	 * @throws Exception
	 */
	protected Graph buildBinary(int numNodes) throws Exception
	{
		int degree = 3;
		Graph g = new Tree(numNodes, degree);
		Graph.getGraph()[0] = new TreeNode(degree, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			Graph.getGraph()[i] = newNode(Graph.getGraph()[((i - 1) / 2)], degree);
			g.setCounter(getCounter() + 1);
		}
		
		return g;
	}
	
	/**
	 * buildRandTree - builds a RANDOMLY GENERATED Tree. Which is to say a 
	 * 		graph that builds according to the makeRandom() method in
	 * 		the class RandomGraphGenerator, dedicated to this problem.
	 * 		 
	 * @param numNodes: the desired N of the tree
	 * @return the new RANDOMLY GENERATED GRAPH.
	 * @throws Exception
	 */
	protected Graph buildRandTree(int numNodes) throws Exception
	{
		return RandomGraphGenerator.makeRandom(numNodes);
	}	
}
