/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		DisjointSets
 * 			Basic code for disjoint sets, as required per approximation
 * 			Algorithm one (The Disjoint Set Method).		
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 24 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class DisjointSets
{
	private static final int PARENT_VALUE = -1;
	private static final int DEFAULT_LENGTH = 10;
	
	protected int[] setsArray;								// An array denoting setsArray[i]'s direct parent
	
	/**
	 * NO-ARG CONSTRUCTOR for DisjointSets. Constructs an array of 
	 * 		DEFAULT_LENGTH, then sets all values to -1, to indicate 
	 * 		all nodes are the parents of their own sets.
	 * 
	 * @param numNodes: the number of nodes to be divided into sets
	 */
	public DisjointSets()
	{
		setsArray = new int[DEFAULT_LENGTH];
		
		for (int i = 0; i < DEFAULT_LENGTH; i++)
		{
			setsArray[i] = PARENT_VALUE;
		}
	}
	
	/**
	 * ONE-ARG CONSTRUCTOR for DisjointSets. Constructs an array of input
	 * 		(initially g.numNodes of input graph, then subsets of uncolored
	 * 		nodes) length, then sets all values to -1, to indicate all nodes
	 * 		are the parents of their own sets.
	 * 
	 * @param numNodes: the number of nodes to be divided into sets
	 */
	public DisjointSets(int numNodes)
	{
		setsArray = new int[numNodes];
		
		for (int i = 0; i < numNodes; i++)
		{
			setsArray[i] = PARENT_VALUE;
		}
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * findParent - recursive method that finds the parent of a particular set
	 * 		and returns its name. Uses path compression to attach any node traversed
	 * 		on the way to finding the parent to the parent directly (ie, turning each
	 * 		parent into its own "star graph" if drawn graphically. 
	 * 
	 * 
	 *{@link https://en.wikipedia.org/wiki/Disjoint-set_data_structure}
	 * @param node: the node to find the set parent of
	 * @return the parent of node's set
	 */
	public int findParent(int node)
	{
		if (setsArray[node] == PARENT_VALUE)
		{
			return node;
		}
		else
		{
			int parent = findParent(setsArray[node]);
			setsArray[node] = parent;
			return parent;
		}
	}
	
	/**
	 * makeSet - sets the node at array[parent] to -1. Id est, it turns 
	 * 		the input node into the parent of its own set.
	 * 
	 * @param parent: the value to become a parent
	 */
	public void makeSet(int parent)
	{
		setsArray[parent] = PARENT_VALUE;
	}
	
	/**
	 * print - prints the setsArray to console
	 */
	public void print()
	{
		for (int i = 0; i < setsArray.length; i++)
		{
			if (i < 10)
			{
				System.out.print(" " + i + "  ");
			}
			else
			{
				System.out.print(" " + i + " ");
			}
		}
		System.out.println();
		for (int i = 0; i < setsArray.length; i++)
		{
			if (i > 9)
			{
				if ((setsArray[i] < 0))
				{
					System.out.print(" " + setsArray[i] + " ");
				}
				else
				{
					System.out.print("  " + setsArray[i] + " ");
				}
			}
			else if ((setsArray[i] > 0) && (setsArray[i] < 10))
			{
				System.out.print(" " + setsArray[i] + "  ");
			}
			else
			{
				System.out.print("" + setsArray[i] + "  ");
			}
		}
		System.out.println();
	}
	
	/**
	 * union - unions two sets together by taking making the parent of the second
	 * 		input (set2) the child of the first input (set1).
	 * 
	 * @param set1: a member of one set
	 * @param set2: a member of a different set
	 */
	public void union(int set1, int set2)
	{
		set1 = findParent(set1);
		set2 = findParent(set2);
		setsArray[set2] = set1;
	}
}