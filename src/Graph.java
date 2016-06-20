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
	public static final int DEFAULT_CHI = 0;
	public static final int DEFAULT_COUNTER = 000;
	public static final int DEFAULT_DEGREE = 20;
	public static final int DEFAULT_NODES = 10;
	
	private int chi;					// The BCN, pronounced "kai"
	private int counter;				// Names the new nodes incrementally [0 - numNodes)
	private int graphDegree;			// The maximum degree any node in this graph can have, if any
	private int numNodes;				// The total number of nodes in graph
	private Node node;				  	// An all-purpose node, to limit memory drain
	public Node[] graph;				// The graph, as a collection of ordered nodes in an array
	
	/**
	 * NO-ARG CONSTRUCTOR for graph, which sets the counter to 0, the graphDegree and
	 * 		numNodes to their default values, and greats a Node array of length numNodes.
	 */
	public Graph()
	{
		chi = DEFAULT_CHI;
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
		chi = DEFAULT_CHI;
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
		chi = DEFAULT_CHI;
		counter = DEFAULT_COUNTER;
		this.graphDegree = graphDegree;
		this.numNodes = numNodes;
		graph = new Node[numNodes];
	}

	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * getChi - standard getter for chi
	 * 
	 * @return the current value of chi
	 */
	public int getChi()
	{
		return chi;
	}
	
	/**
	 * getCounter - standard getter for counter.
	 * 
	 * @return the current value of counter
	 */
	public int getCounter()
	{
		return counter;
	}

	/**
	 * getLeaf - standard getter for a node / leaf.
	 * 
	 * @return the node at graph[i]s
	 */
	public Node getLeaf(int i)
	{
		return graph[i].getNode();
	}
	
	/**
	 * getGraph - standard getter for graph.
	 * 
	 * @return the array that holds the graph
	 */
	public Node[] getGraph()
	{
		return graph;
	}
	
	/**
	 * getGraphDegree - standard getter for degree.
	 * 
	 * @return the max degree of the graph, if any
	 */
	public int getGraphDegree()
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
	 * getNode - returns the vertex with name i
	 * 
	 * @param i: the vertex's name
	 * @return the vertex
	 */
	public Node getNode(int i) 
	{
		return graph[i];
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
 	 * setChi - standard setter for chi.
 	 * 
 	 * @param chi1: the value to set chi to
 	 */
 	protected void setChi(int chi1)
 	{
 		chi = chi1;
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
	 * setGraph - standard setter for graph array
	 * 
	 * @param array: the new array
	 */
	protected void setGraph(Node[] array)
	{
		graph = array;
	}
	
	/**
	 * setGraphDegree - standard setter for degree.
	 * 
	 * @param i: the number which to set degree to, if not default
	 */
	protected void setGraphDegree(int i)
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
	 * addNode - adds a pre-existing node to its sponsor
	 * 
	 * @param sponsor: a pre-existing node in the graph
	 * @param newNode: a pre-existing node to be added to the graph
	 * @throws Exception 
	 */
	public void addNode(Node sponsor, Node newNode) throws Exception 
	{
		sponsor.addNeighbor(newNode);
		newNode.addNeighbor(sponsor);
	}
	
	/**
	 * newNode - creates a new node and attaches it to a pre-existing node.
	 * 
	 * @param sponsor: an existing node which to attach the new node
	 * @param degree: the degree the node should have
	 * @return the new node
	 * @throws Exception
	 */
	protected Node newNode(Node sponsor, int degree) throws Exception
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