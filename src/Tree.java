/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Tree Class
 * 			An implementation of the most general Tree building class possible,
 * 			trying to maintain both code flexibility and consistency, allowing for
 * 			multiple types of trees to be built, but only one kind of tree to be
 * 			built at a time, et hoc genus omne.
 * 
 * @author Nicole Loew
<<<<<<< HEAD
 * @version CS5999 Graduate Thesis Spring 2017; 31 May 2016
=======
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
>>>>>>> origin/master
 * {@link https://github.com/nicoleal/Thesis}
 */

@SuppressWarnings("serial")
public class Tree extends Node
{
	private int counter = 000;
	private int treeDegree;
	private int numNodes;
	private static Node node;
	private Node root;
	public Node[] tree;
	
	/******************************************************************************
	 *                                                                            *
	 *                          LET'S MAKE A TREE                                 *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * buildBinary - builds a BINARY TREE. Which is to say a balanced and 
	 * 		complete tree with a root of zero and a numbering pattern similar 
	 * 		to binary heaps AND all vertices have no more than degree-3. The
	 * 		degree-3 requirement is built into the method and cannot be changed 
	 * 		without delving into the code. 
	 * 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new BINARY TREE with 
	 * @throws Exception
	 */
	protected Tree buildBinary(Tree t, int numNodes) throws Exception
	{
		int d = 3;
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		for (int i = 1; i < numNodes; i++)
		{
			t.tree[i] = birth(t, t.tree[((i - 1) / 2)], d);
			t.counter++;
		}
		
		return t;
	}
	
	/**
	 * buildCat1 - builds a CATERPILLAR TREE of TYPE 1. Which is to say a 
	 * 		tree where any vertex v is no more than 1 edge away from the
	 * 		spine AND all vertices have no more than degree-3. The degree-3
	 * 		requirement is built into the method and cannot be changed without
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
				t.tree[i] = birth(t, t.tree[i - 1].getNode(), d);
				makeLeaf(t, i, 1);
			}
			else
			{
				t.tree[i] = birth(t, t.tree[i - 2].getNode(), d);
				t.tree[i].setDepth(0);
			}
			t.counter++;
		}
		
		return t;
	}
	
	/**
	 * buildCat2 - builds a CATERPILLAR TREE of TYPE 2. Which is to say a 
	 * 		tree where any vertex v is no more than 1 edge away from the
	 * 		spine AND all vertices have no more than degree-4. The degree-4
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a ternary tree with two leaf nodes
	 * 		and one non-leaf-node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new CATERPILLAR T2 TREE with a spine of (numNodes/3) and
	 * 		(2*numNodes/3) branches of length 1 each.
	 * @throws Exception
	 */
	protected Tree buildCat2(Tree t, int numNodes) throws Exception
	{
		int d = 4;
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		for (int i = 1; i < numNodes; i++)
		{
			if (is3eq0(i))
			{
				t.tree[i] = birth(t, t.tree[i - 3].getNode(), d);
				t.tree[i].setDepth(0);
			}
			else if (is3eq1(i))
			{
				t.tree[i] = birth(t, t.tree[i - 1].getNode(), d);
				makeLeaf(t, i, 1);
			}
			else
			{
				t.tree[i] = birth(t, t.tree[i - 2].getNode(), d);
				makeLeaf(t, i, 1);
			}
			t.counter++;
		}
		
		return t;
	}
	
	/**
	 * buildLob1 - builds a LOBSTER TREE of TYPE 1. Which is to say a 
	 * 		tree where any vertex v is no more than 2 edges away from the
	 * 		spine AND all vertices have no more than degree-3. The degree-3
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a binary tree with 1 branching nodes
	 * 		and 1 spine node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new LOBSTER T1 TREE with a spine of (numNodes/4) and
	 * 		(numNodes/4) branches of length 2 each.
	 * @throws Exception
	 */
	protected Tree buildLob1(Tree t, int numNodes) throws Exception
	{
		int d = 3;
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		for (int i = 1; i < numNodes; i++)
		{
			if (is4eq0(i))
			{
				t.tree[i] = birth(t, t.tree[i - 4].getNode(), d);
				t.tree[i].setDepth(0);
			}
			else if (is4eq1(i))
			{
				t.tree[i] = birth(t, t.tree[i - 1].getNode(), d);
				t.tree[i].setDepth(1);
			}
			else
			{
				t.tree[i] = birth(t, t.tree[(((i / 4) * 4) + 1)].getNode(), d);
				makeLeaf(t, i, 2);
			}
			t.counter++;
		}
		
		return t;
	}
	
	/**
	 * buildLob2 - builds a LOBSTER TREE of TYPE 1. Which is to say a 
	 * 		tree where any vertex v is no more than 2 edges away from the
	 * 		spine AND all vertices have no more than degree-4. The degree-4
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a binary tree with 2 branching nodes
	 * 		and 1 spine node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new LOBSTER T2 TREE with a spine of (numNodes/7)
	 * 		and (2*numNodes/7) branches of length 2.
	 * @throws Exception
	 */
	protected Tree buildLob2(Tree t, int numNodes) throws Exception
	{
		int d = 4;
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		for (int i = 1; i < numNodes; i++)
		{
			if (is7eq0(i))
			{
				t.tree[i] = birth(t, t.tree[i - 7].getNode(), d);
				t.tree[i].setDepth(0);
			}
			else if (is7eq1(i))
			{
				t.tree[i] = birth(t, t.tree[i - 1].getNode(), d);
				t.tree[i].setDepth(1);
			}
			else if (is7eq4(i))
			{
				t.tree[i] = birth(t, t.tree[i - 4].getNode(), d);
				t.tree[i].setDepth(1);
			}
			else if ((i % 7) > 4)
			{
				t.tree[i] = birth(t, t.tree[(((i / 7) * 7) + 4)].getNode(), d);
				makeLeaf(t, i, 2);
			}
			else
			{
				t.tree[i] = birth(t, t.tree[(((i / 7) * 7) + 1)].getNode(), d);
				makeLeaf(t, i, 2);
			}
			t.counter++;
		}
		
		return t;
	}	
	
	/**
	 * buildInput - builds a tree based off of user input. Which is to 
	 * 		say graph that builds according to the makeInput() method in
	 * 		the class UserInputGraph, dedicated to this problem.
	 * 		 
	 * @param t: the input tree, usually empty
	 * @return the new USER INPUT GRAPH
	 * @throws Exception
	 */
	protected Tree buildInput(Tree t) throws Exception
	{
		return UserInputGraph.makeInput(t);
	}
	
	/**
	 * buildRand - builds a RANDOMLY GENERATED TREE. Which is to say a 
	 * 		graph that builds according to the makeRandom() method in
	 * 		the class RandomGraphGenerator, dedicated to this problem.
	 * 		 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new LOBSTER T2 TREE with a spine of (numNodes/7) and
	 * 		(2*numNodes/7) branches of length 2 each.
	 * @throws Exception
	 */
	protected Tree buildRand(Tree t, int numNodes) throws Exception
	{
		return RandomGraphGenerator.makeRandom(t, numNodes);
	}
	
	/**SpineBinary - builds a SPINE TREE. Which is to say line of nodes 
	 * 		with a root of zero and at most one child.
	 * 
	 * @param t: the input tree, usually empty
	 * @param numNodes: the desired N of the tree
	 * @return the new SPINE TREE with length N
	 * @throws Exception
	 */
	protected Tree buildSpine(Tree t, int numNodes) throws Exception
	{
		int d = 2;
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		for (int i = 1; i < numNodes; i++)
		{
			t.tree[i] = birth(t, t.tree[(i - 1)], d);
			t.counter++;
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
	protected static void setTreeDegree(Tree t, int i)
	{
		t.treeDegree = i;
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * is3eq0 - a mod to see of a number is evenly divisible by three
	 * 
	 * @param i: the value whose remainder is to be calculated
	 * @return TRUE if evenly divisible, FALSE otherwise
	 */
	public static Boolean is3eq0(int i)
	{
		return ((i % 3) == 0);
	}
	
	/**
	 * is3eq1 - a mod to see if a number is divisible by 3 with 1 remainder
	 * 
	 * @param i: the value whose divisibility is to be calculated
	 * @return TRUE if remainder 1, FALSE otherwise
	 */
	public static Boolean is3eq1(int i)
	{
		return ((i % 3) == 1);
	}
	
		
	/**
	 * is4eq0 - a mod to see of a number is evenly divisible by 4
	 * 
	 * @param i: the value whose remainder is to be calculated
	 * @return TRUE if evenly divisible, FALSE otherwise
	 */
	public static Boolean is4eq0(int i)
	{
		return ((i % 4) == 0);
	}
	
	/**
	 * is4eq1 - a mod to see if a number is divisible by 4 with 1 remainder
	 * 
	 * @param i: the value whose divisibility is to be calculated
	 * @return TRUE if remainder 1, FALSE otherwise
	 */
	public static Boolean is4eq1(int i)
	{
		return ((i % 4) == 1);
	}
		
	/**
	 * is7eq0 - a mod to see of a number is evenly divisible by 7
	 * 
	 * @param i: the value whose remainder is to be calculated
	 * @return TRUE if evenly divisible, FALSE otherwise
	 */
	public static Boolean is7eq0(int i)
	{
		return ((i % 7) == 0);
	}
	
	/**
	 * is7eq1 - a mod to see if a number is divisible by 7 with 1 remainder
	 * 
	 * @param i: the value whose divisibility is to be calculated
	 * @return TRUE if remainder 1, FALSE otherwise
	 */
	public static Boolean is7eq1(int i)
	{
		return ((i % 7) == 1);
	}
	
	/**
	 * is7eq4 - a mod to see if a number is divisible by 7 with 4 remainder
	 * 
	 * @param i: the value whose divisibility is to be calculated
	 * @return TRUE if remainder 4, FALSE otherwise
	 */
	public static Boolean is7eq4(int i)
	{
		return ((i % 7) == 4);
	}
	
	/**
	 * isLeaf - returns whether the node in question is a leaf or not.
	 * 		id est, has no kids.
	 * 
	 * @param t: the tree
	 * @param i: the number of the node in question
	 * @return TRUE if leaf, FALSE otherwise
	 */
	public Boolean isLeaf(Tree t, int i)
	{
		return (t.getLeaf(t, i).getKids() == 0);
	}
	
	/**
	 * isOdd - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/eveness is to be calculated
	 * @return TRUE if odd, FALSE otherwise
	 */
	public static Boolean isOdd(int i)
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
	protected static Node birth(Tree t, Node n, int degree) throws Exception
	{
		node = new Node(n, degree, t.counter);
		n.addChild(node);
		return node;
	}
	
	/**
	 * makeLeaf - calls bachelor() and setDepth() on new leaf.
	 * 
	 * @param t the tree
	 * @param i the counter value
	 * @param j the depth
	 */
	protected void makeLeaf(Tree t, int i, int j) throws CloneNotSupportedException
	{
		t.tree[i].bachelor();
		t.tree[i].setDepth(j);
	}
	
	/**
	 * makeRoot - takes a freshly defined tree and sets its degree, numNodes, 
	 * 		and counter; creates its tree array and places its root in tree[0].
	 * 
	 * @param t the tree
	 * @param numNodes
	 * @param degree
	 */
	protected void makeRoot(Tree t, int numNodes, int degree)
	{
		t.setNumNodes(t, numNodes);
		Tree.setTreeDegree(t, degree);
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
