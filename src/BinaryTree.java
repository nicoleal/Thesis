/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Binary Tree Class
 * 			Extends Graph Class to build a BINARY TREE.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 17 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class BinaryTree extends Tree
{
	private static final int DEGREE = 3;
	
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
	public BinaryTree(int numNodes) throws Exception
	{
		super(numNodes);
		setNumNodes(numNodes);
		setGraphDegree(DEGREE);
		graph[0] = new TreeNode(DEGREE, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			setCounter(getCounter() + 1);
			graph[i] = newTreeNode((TreeNode) graph[((i - 1) / 2)], DEGREE);
		}
	}
}