/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Graph Class
 * 			An implementation of the most general graph building class possible,
 * 			trying to maintain both code flexibility and consistency, allowing for
 * 			multiple types of trees to be built, but only one kind of tree to be
 * 			built at a time, et hoc genus omne.
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 31 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Graph
{
	public static final int DEFAULT_COUNTER = 000;
	public static final int DEFAULT_DEGREE = 20;
	public static final int DEFAULT_NODES = 10;
	
	private static int counter;				// Names the new nodes incrementally [0 - numNodes)
	private static int graphDegree;			// The maximum degree any node in this graph can have, if any
	private int numNodes;					// The total number of nodes in graph
	private static Node node;				// An all-purpose node, to limit memory drain
	public static Node[] graph;					// The graph, as a collection of ordered nodes in an array
	
	
	/******************************************************************************
	 *                                                                            *
	 *							     CONSTRUCTORS                                 *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * NO-ARG CONSTRUCTOR for graph, which sets the counter to 0, the graphDegree and
	 * 		numNodes to their default values, and greats a Node array of length numNodes.
	 */
	public Graph()
	{
		counter = DEFAULT_COUNTER;
		graphDegree = DEFAULT_DEGREE;
		numNodes = DEFAULT_NODES;
		graph = new Node[numNodes];
	}
	
	/**
	 * ONE-ARG CONSTRUCTOR for graph, which sets the counter to 0, the graphDegree 
	 * 		to its default values, numNodes to INPUT, and greats a Node array of 
	 * 		length numNodes.
	 * 
	 * @param numNodes: the length / total number of nodes in graph
	 */
	public Graph(int numNodes)
	{
		counter = DEFAULT_COUNTER;
		graphDegree = DEFAULT_DEGREE;
		this.numNodes = numNodes;
		graph = new Node[numNodes];
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for graph, which sets the counter to 0, the graphDegree and
	 * 		numNodes to their INPUT values, and greats a Node array of length numNodes.
	 * 
	 * @param numNodes: the length / total number of nodes in graph
	 * @param graphDegree: the maxDegree of any node in the graph
	 */
	public Graph(int numNodes, int graphDegree)
	{
		counter = DEFAULT_COUNTER;
		Graph.graphDegree = graphDegree;
		this.numNodes = numNodes;
		graph = new Node[numNodes];
	}
	
	/******************************************************************************
	 *                                                                            *
	 *							   DEFAULT GRAPHS                                 *
	 *                                                                            *
	 ******************************************************************************/
	
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
	 * @return the new CATERPILLAR T1 GRAPH with a spine of (numNodes/2) and
	 * 		(numNodes/2) branches of length 1 each.
	 * @throws Exception
	 */
	protected Graph buildCat1(int numNodes) throws Exception
	{
		int degree = 3;
		Graph g = new Graph(numNodes, degree);
		Graph.getGraph()[0] = new Node(degree, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			if (Helper.isOdd(i))
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - 1].getNode(), degree);
				makeLeaf(i);
			}
			else
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - 2].getNode(), degree);
			}
			g.setCounter(getCounter() + 1);
		}	
		return g;
	}
	
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
	 * @return the new CATERPILLAR T2 GRAPH with a spine of (numNodes/3) and
	 * 		(2*numNodes/3) branches of length 1 each.
	 * @throws Exception
	 */
	protected Graph buildCat2(int numNodes) throws Exception
	{
		int degree = 4;
		Graph g = new Graph(numNodes, degree);
		Graph.getGraph()[0] = new Node(degree, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			int j = i % 3;
			
			if (j == 0)
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - 3].getNode(), degree);
			}
			else 
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - j].getNode(), degree);
				makeLeaf(i);
			}
			g.setCounter(getCounter() + 1);
		}
		
		return g;
	}
	
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
	 * @return the new LOBSTER T1 GRAPH with a spine of (numNodes/4) and
	 * 		(numNodes/4) branches of length 2 each.
	 * @throws Exception
	 */
	protected Graph buildLob1(int numNodes) throws Exception
	{
		int degree = 3;
		Graph g = new Graph(numNodes, degree);
		Graph.getGraph()[0] = new Node(degree, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			int j = i % 4;
			
			if (j == 0)
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - 4].getNode(), degree);
			}
			else if (j == 1)
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - j].getNode(), degree);
			}
			else
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[(i - j + 1)].getNode(), degree);
				makeLeaf(i);
			}
			g.setCounter(getCounter() + 1);
		}
		
		return g;
	}
	
	/**
	 * buildLob2 - builds a LOBSTER GRAPH of TYPE 2. Which is to say a 
	 * 		tree where any vertex v is no more than 2 edges away from the
	 * 		spine AND all vertices have no more than degree-4. The degree-4
	 * 		requirement is built into the method and cannot be changed without
	 * 		delving into the code. 
	 * 		
	 * 		As this is __identical__ to a binary tree with 2 branching nodes
	 * 		and 1 spine node, this tree is constructed as such, with
	 * 		the proper modifications made to the depth as needed. 
	 * 
	 * @param numNodes: the desired N of the graph
	 * @return the new LOBSTER T2 GRAPH with a spine of (numNodes/7)
	 * 		and (2*numNodes/7) branches of length 2.
	 * @throws Exception
	 */
	protected Graph buildLob2(int numNodes) throws Exception
	{
		int degree = 4;
		Graph g = new Graph(numNodes, degree);
		Graph.getGraph()[0] = new Node(degree, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			int j = i % 7;
			
			if (j == 0)
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - 7].getNode(), degree);
			}
			else if ((j == 1) || (j == 4))
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[i - j].getNode(), degree);
			}
			else if (j > 4)
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[(i - j + 4)].getNode(), degree);
				makeLeaf(i);
			}
			else
			{
				Graph.getGraph()[i] = newNode(Graph.getGraph()[(i - j + 1)].getNode(), degree);
				makeLeaf(i);
			}
			g.setCounter(getCounter() + 1);
		}
		
		return g;
	}	
	
	/**
	 * buildInput - builds a graph based off of user input. Which is to 
	 * 		say graph that builds according to the makeInput() method in
	 * 		the class UserInputGraph, dedicated to this problem.
	 * 		 
	 * @return the new USER INPUT GRAPH
	 * @throws Exception
	 */
	protected Graph buildInput(String fileName) throws Exception
	{
		return UserInputGraph.makeInput(fileName);
	}
	
	/**
	 * buildRand - builds a RANDOMLY GENERATED GRAPH. Which is to say a 
	 * 		graph that builds according to the makeRandom() method in
	 * 		the class RandomGraphGenerator, dedicated to this problem.
	 * 		 
	 * @param numNodes: the desired N of the graph
	 * @return the new RANDOMLY GENERATED GRAPH.
	 * @throws Exception
	 */
	protected Graph buildRand(int numNodes) throws Exception
	{
		return RandomGraphGenerator.makeRandom(numNodes);
	}
	
	/**SpineBinary - builds a SPINE GRAPH. Which is to say line of nodes 
	 * 		with a root of zero and at most one child.
	 * 
	 * @param numNodes: the desired N of the graph
	 * @return the new SPINE GRAPH with length N
	 * @throws Exception
	 */
	protected Graph buildSpine(int numNodes) throws Exception
	{
		int degree = 2;
		Graph g = new Graph(numNodes, degree);
		Graph.getGraph()[0] = new Node(degree, 0);
		
		for (int i = 1; i < numNodes; i++)
		{
			Graph.getGraph()[i] = newNode(Graph.getGraph()[(i - 1)], degree);
			g.setCounter(getCounter() + 1);
		}
		
		return g;
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * getCounter - standard getter for counter.
	 * 
	 * @return the current value of counter
	 */
	public static int getCounter()
	{
		return counter;
	}

	/**
	 * getLeaf - standard getter for a node / leaf.
	 * 
	 * @return the node at graph[i]
	 */
	protected static Node getLeaf(int i)
	{
		return graph[i].getNode();
	}
	
	/**
	 * getGraph - standard getter for graph.
	 * 
	 * @return the array that holds the graph
	 */
	public static Node[] getGraph()
	{
		return graph;
	}
	
	/**
	 * getGraphDegree - standard getter for degree.
	 * 
	 * @return the max degree of the graph, if any
	 */
	public static int getGraphDegree()
	{
		return graphDegree;
	}
	
	/**
	 * getNeighbor - standard getter for graph[name].
	 * 
	 * @return the Node named i
	 */
	public Node getNeighbor(int name)
	{
		return graph[name];
	}
	
	/**
	 * getNumNodes - standard getter for numNodes.
	 * 
	 * @return numNodes
	 */
 	public int getNumNodes()
	{
		return numNodes;
	}
	
	/**
	 * setCounter - standard setter for counter.
	 * 
	 * @param i: the value to set the counter to
	 */
	protected void setCounter(int i)
	{
		counter = i;
	}
	
	/**
	 * setGraph - standard setter for graph.
	 * 
	 * @param array: the array to set graph to
	 */
	public static void setGraph(Node[] array)
	{
		graph = array;
	}
	
	/**
	 * setGraphDegree - standard setter for degree.
	 * 
	 * @param i: the number which to set degree to, if not default
	 */
	protected static void setGraphDegree(int i)
	{
		graphDegree = i;
	}
	
	/**
	 * setNumNodes - standard setter for numNodes.
	 * 
	 * @param i: the number of nodes that should be in the tree
	 */
	protected void setNumNodes(int i)
	{
		numNodes = i;
	}

	/**
	 * resetCounter - resets the counter to 0.
	 * 
	 * @param the tree whose counter is to be reset
	 */
	protected void resetCounter()
	{
		setCounter(0);
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * newNode - creates a new node and attaches it to a pre-existing node.
	 * 
	 * @param sponsor: an existing node which to attach the new node
	 * @param degree: the degree the node should have
	 * @return the new node
	 * @throws Exception
	 */
	protected static Node newNode(Node sponsor, int degree) throws Exception
	{
		node = new Node(sponsor, getGraphDegree(), getCounter());
		sponsor.addNeighbor(node);
		
		return node;
	}
	
	/**
	 * makeLeaf - makes a leaf / a node that will only have one neighbor
	 * 
	 * @param i: the name of the node
	 * @throws CloneNotSupportedException 
	 */
	protected void makeLeaf(int i) throws CloneNotSupportedException
	{
		graph[i].leaf();
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
