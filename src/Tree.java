/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Tree Class
 * 			An implementation of the most general Tree building class possible,
 * 			trying to maintain both code flexibility and consistency, allowing for
 * 			multiple types of trees to be built, but only one kind of tree to be
 * 			built at a time, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 15 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

@SuppressWarnings("serial")
public class Tree extends Node
{
	private int counter = 000;
	private int treeDegree;
	private int numNodes;
	private Node node;
	private Node root;
	private Node[] tree;
	
	/******************************************************************************
	 *                                                                            *
	 *                          LET'S MAKE A TREE                                 *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * buildCat1 - builds a CATERPILLAR TREE of TYPE 1. Which is to say a 
	 * 		tree where any vertex v is no more than 1 edge away from the
	 * 		spine AND all vertices have no more than degree-3. The degree-3
	 * 		requirement is built into the method and cannot be changed withou
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a binary tree with one leaf node
	 * 		and one non-leaf-node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new CATERPILLAR T1 TREE with a spine of (numNodes/2) and
	 * 		(numNodes/2) branches of length 1 each.
	 * @throws Exception
	 */
	protected Tree buildCat1(Tree t, int numNodes) throws Exception
	{
		int d = 3;
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		for (int i = 1; i < numNodes; i++)
		{
			if (isOdd(i))
			{
				t.tree[i] = birth(t.tree[i - 1].getNode(), d);
				t.tree[i].bachelor();
				t.tree[i].setDepth(1);
			}
			else
			{
				t.tree[i] = birth(t.tree[i - 2].getNode(), d);
				t.tree[i].setDepth(0);
			}
		}
		
		return t;
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * getCounter - standard getter for counter.
	 * 
	 * @param t: the tree to pull the counter from
	 * @return the current value of counter
	 */
	public int getCounter(Tree t)
	{
		return t.counter;
	}

	protected Node getLeaf(Tree t, int i)
	{
		return t.tree[i].getNode();
	}
	
	/**
	 * getNumNodes - standard getter for numNodes.
	 * 
	 * @param t: the tree to pull numNodes from
	 * @return numNodes
	 */
 	public int getNumNodes(Tree t)
	{
		return t.numNodes;
	}
	
	/**
	 * getRoot - standard getter for root.
	 * 
	 * @param t: the Tree to get the root from
	 * @return the root node
	 */
	public Node getRoot(Tree t)
	{
		return getLeaf(t, 0);
	}
	
	/**
	 * getTree - standard getter for tree.
	 * 
	 * @param t: the Tree to grab the array from
	 * @return the array that holds the tree
	 */
	public Node[] getTree(Tree t)
	{
		return t.tree;
	}
	
	/**
	 * getTreeDegree - standard getter for degree.
	 * 
	 * @param t: the tree to get degree from.
	 * @return the degree of the tree
	 */
	public int getTreeDegree(Tree t)
	{
		return t.treeDegree;
	}
	
	/**
	 * resetCounter - resets the counter to 0.
	 * 
	 * @param the tree whose counter is to be reset
	 */
	protected void resetCounter(Tree t)
	{
		setCounter(t, 0);
	}
	
	/**
	 * setCounter - standard setter for counter.
	 * 
	 * @param t: the tree to set the value on
	 * @param i: the value to set the counter to
	 */
	protected void setCounter(Tree t, int i)
	{
		t.counter = i;
	}
	
	/**
	 * setNumNodes - standard setter for numNodes.
	 * 
	 * @param t: the tree to set numNodes in
	 * @param i: the number of nodes that should be in the tree
	 */
	protected void setNumNodes(Tree t, int i)
	{
		t.numNodes = i;
	}

	/**
	 * setTreeDegree - standard setter for degree.
	 * 
	 * @param t: the tree to set degree in
	 * @param i: the number which to set degree to
	 */
	protected void setTreeDegree(Tree t, int i)
	{
		t.treeDegree = i;
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * isOdd - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/eveness is to be calculated
	 * @return TRUE if odd, FALSE otherwise
	 */
	private Boolean isOdd(int i)
	{
		return ((i & 1) != 0);
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * birth - creates a new node and attaches it to its parent.
	 * 
	 * @param n: the parent node
	 * @param degree: the degree the node should have
	 * @return the new node
	 * @throws Exception
	 */
	private Node birth(Node n, int degree) throws Exception
	{
		node = new Node(n, degree, counter);
		n.addChild(node);
		return node;
	}
	
	/**
	 * makeRoot - takes a freshly defined tree and sets its degree, numNodes, 
	 * 		and counter; creates its tree array and places its root in tree[0].
	 * 
	 * @param
	 * @param numNodes
	 * @param degree
	 */
	protected void makeRoot(Tree t, int numNodes, int degree)
	{
		t.setNumNodes(t, numNodes);
		t.setTreeDegree(t, degree);
		t.tree = new Node[numNodes];
		t.root = new Node(degree, t.counter);
		t.tree[0] = t.root;
		t.counter++;
	}
	
	/**
	 * toString - 
	 * 
	 * @return the String
	 */
	public String toString()
	{
		String s = "";
		//TODO
		return s;
	}
}
