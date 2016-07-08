<<<<<<< HEAD
/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		ApproximationOne (The Disjoint Set Method)
 * 			Determining the BCN of chi >= 4 is NP-Hard. Here is 
 * 			attempt one at approximating the value, et hoc genus omne.
 * 
 * 		If I'm not mistaken, some colorings can be determined via
 * 			disjoint sets. So I'm thinking, is there a polynomial
 * 			way of creating two disjoint sets which, between them,
 * 			contain all the vertices in a graph? Color all the nodes
 * 			in one set V1, then repeat on the second set until all
 * 			nodes are colored. I'm not sure it'll work, but I think
 * 			it's worth giving a shot. 
 * 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 8 July 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class ApproximationOne extends Approximations
{
	private static final int DEFAULT_LENGTH = 10;	
	
	private DisjointSets sets;								// An array denoting setsArray[i]'s direct parent
	private int[] neighborhoodArray;						// An array holding the degree of all nodes in the graph
	private int parentSetOne;								// The parent of the first set (set1)
	private int parentSetTwo;								// The parent of the second set (set2)
	
	/**
	 * NO-ARG CONSTRUCTOR for ApproximationOne. Constructs an array of 
	 * 		DEFAULT_LENGTH, then sets all values to -1, to indicate 
	 * 		all nodes are the parents of their own sets.
	 */
	public ApproximationOne()
	{
		sets = new DisjointSets(DEFAULT_LENGTH);
		neighborhoodArray = new int[DEFAULT_LENGTH];
	}
	
	/**
	 * ONE-ARG CONSTRUCTOR for Approximation One. Constructs an array of
	 * 		g.numNodes of input graph, then sets all values to -1, to
	 * 		to indicate all nodes are the parents of their own sets.
	 * 
	 * @param numNodes: the number of nodes to be divided into sets
	 */
	public ApproximationOne(Graph g)
	{
		sets = new DisjointSets(g.getNumNodes());
		neighborhoodArray = new int[getSetsArray().length];
	}

	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * findDegree - fills the neighborhoodArray with the metNeighbors values for
	 * 		each node in the input graph.
	 */
	protected void findDegree(Graph g)
	{
		for (int i = 0; i < g.getNumNodes(); i++)
		{
			getNeighborhoodArray()[i] = g.getGraph()[i].getMetNeighbors();
		}
	}
	
	/**
	 * findHighestDegree - finds the highest degree [start, neighborhoodArray.length)
	 * 		based off the input value. Returns -1 if start is larger than the length
	 * 		of the array / numNodes of the graph OR less than 0 / negative.
	 * 
	 * @param start: the node to begin the search at
	 * @return the location of the highest degree value.
	 */
	protected int findHighestDegree(int start)
	{
		if ((start < getNeighborhoodArray().length) && (start >= 0))
		{
			int highest = getNeighborhoodArray()[start];
			int highestNode = start;
		
			for (int i = (start + 1); i < getNeighborhoodArray().length; i++)
			{
				if (getNeighborhoodArray()[i] > highest)
				{
					highest = getNeighborhoodArray()[i];
					highestNode = i;
				}
			}
			return highestNode;
		}
		return -1;
	}
	
	protected void radiateFromHighest(Graph g)
	{
		
		
		
		
		
		
	}
	
	public void colorByDisjointSets(Graph g)
	{
		int start = 0;
		int tempChi = g.getNumNodes();
		setParentOne(findHighestDegree(start));


	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * getSets - standard getter for sets
	 * 
	 * @return the disjoint set object
	 */
	public DisjointSets getSets()
	{
		return sets;
	}
	
	/**
	 * getNeighborhoodArray - standard getter for neighborhoodArray.
	 * 
	 * @return the neighborhoodArray
	 */
	public int[] getNeighborhoodArray()
	{
		return neighborhoodArray;
	}
	
	/**
	 * getSetsArray - standard getter for sets.setsArray
	 * 
	 * @return the disjoint set object
	 */
	public int[] getSetsArray()
	{
		return getSets().getSetsArray();
	}
	
	/**
	 * getParentOne - standard getter for parentSetOne
	 * 
	 * @return - parentSetOne
	 */
	public int getParentOne()
	{
		return parentSetOne;
	}
	
	/**
	 * getParentTwo - standard getter for parentSetTwo
	 * 
	 * @return - parentSetOne
	 */
	public int getParentTwo()
	{
		return parentSetTwo;
	}
	
	/**
	 * setParentOne - standard setter for parentSetOne
	 * 
	 * @param parent: parent for Set1
	 */
	public void setParentOne(int parent)
	{
		parentSetOne = parent;
	}
	
	/**
	 * setParentTwo - standard setter for parentSetTwo
	 * 
	 * @param parent: parent for Set2
	 */
	public void setParentTwo(int parent)
	{
		parentSetTwo = parent;
	}
}
=======
/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		ApproximationOne (The Disjoint Set Method)
 * 			Determining the BCN of chi >= 4 is NP-Hard. Here is 
 * 			attempt one at approximating the value, et hoc genus omne.
 * 
 * 		If I'm not mistaken, some colorings can be determined via
 * 			disjoint sets. So I'm thinking, is there a polynomial
 * 			way of creating two disjoint sets which, between them,
 * 			contain all the vertices in a graph. Color all the nodes
 * 			in one set V1, then repeat on the second set until all
 * 			nodes are colored. I'm not sure it'll work, but I think
 * 			it's worth giving a shot. 
 * 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 24 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class ApproximationOne extends Colorings
{
	private DisjointSets sets;							// An array denoting setsArray[i]'s direct parent
	
	
	public void disjointSetMethod(Graph g)
	{
		sets = new DisjointSets(g.getNumNodes());
		setup(g.getNumNodes());
		sets.print();
		
	}

	/**
	 * setup -  takes the members of the graph and arbitrarily
	 * 		assigns them to either SET 0 or SET 1.
	 * 
	 * @param length: the number of nodes in this graph/subset of graph
	 */
	public void setup(int length)
	{
		for (int i = 2; i < length; i++)
		{
			if (isEven(i))
			{
				sets.union(0, i);
			}
			else
			{
				sets.union(1, i);
			}
		}
	}
	
}
>>>>>>> origin/master
