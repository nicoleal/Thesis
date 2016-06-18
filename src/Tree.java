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
	private TreeNode node;				  	// An all-purpose node, to limit memory drain
	
	/**
	 * NO-ARG CONSTRUCTOR for tree, which sets the counter to 0, the graphDegree and
	 * 		numNodes to their default values, and greats a Node array of length numNodes.
	 */
	public Tree()
	{
		super();
		graph = new TreeNode[DEFAULT_NODES];
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
		graph = new TreeNode[numNodes];
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
		graph = new TreeNode[numNodes];
	}	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * addNode - adds a pre-existing node to its sponsor. TREENODE VERSION.
	 * 
	 * @param sponsor: a pre-existing node in the graph
	 * @param newNode: a pre-existing node to be added to the graph
	 * @throws Exception 
	 */
	public void addTreeNode(TreeNode sponsor, TreeNode newNode) throws Exception 
	{
		sponsor.addNeighbor(newNode);
		newNode.addNeighbor(sponsor);
	}
	
	/**
	 * getLeaf - standard getter for a node / leaf. TREENODE VERSION.
	 * 
	 * @return the node at graph[i]
	 */
	protected TreeNode getLeaf(int i)
	{
		return (TreeNode) graph[i].getNode();
	}
	
	
	/**
	 * getRoot - standard getter for a root node / node-0.
	 * 
	 * @return the node at graph[0]
	 */
	public Node getRoot()
	{
		return graph[0].getNode();
	}
	
	/**
	 * newTreeNode - creates a new node and attaches it to a pre-existing node.
	 * 		TREENODE VERSION.
	 * 
	 * @param sponsor: an existing node which to attach the new node
	 * @param degree: the degree the node should have
	 * @return the new node
	 * @throws Exception
	 */
	protected TreeNode newTreeNode(TreeNode sponsor, int degree) throws Exception
	{
		node = new TreeNode(sponsor, getGraphDegree(), getCounter());
		sponsor.addNeighbor(node);
		
		return node;
	}
}