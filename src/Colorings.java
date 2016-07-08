/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Colorings Class
 * 			A collection of helper classes a la the Math Class, et 
 * 			hoc genus omne, for the graph constructor classes
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 10 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Colorings extends Graph
{
	/******************************************************************************
	 *                                                                            *
	 *                            boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * areNeighbors - determines if two gives nodes are neighbors by checking their
	 * 		neighbors arrays (both of them). INT-NAME VERSION.
	 * 
	 * @param node1: the name of the first node to be compared
	 * @param node2: the name of the second node to be compared.
	 * return TRUE if neighbors, false otherwise
	 */
	public boolean areNeighbors(int node1, int node2)
	{
		if (node1 == node2)
		{
			return false;
		}
		else
		{
			for (int i = 0; i < graph[node1].getMetNeighbors(); i++)
			{
				if (graph[node1].neighbors[i] == node2)
				{
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * isColored - determines if the node has been colored / has
	 * 		a color other than WHITE (1). INT-NAME VERSION
	 * 
	 * @param i: the name of the node
	 * @return TRUE if colored, FALSE otherwise
	 */
	public boolean isColored(Graph g, int i)
	{
		return (g.graph[i].getColor() != Color.WHITE.getRadius());
	}
	
	/**
	 * isColored - determines if the node has been colored / has
	 * 		a color other than WHITE (1). NODE VERSION
	 * 
	 * @param i: the name of the node
	 * @return TRUE if colored, FALSE otherwise
	 */
	public boolean isColored(Node node)
	{
		return (node.getColor() != Color.WHITE.getRadius());
	}
	
	/**

	 * isEven - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/evenness is to be calculated
	 * @return TRUE if even, FALSE otherwise
	 */
	public static boolean isEven(int i)
	{
		return ((i & 1) == 0);
	}
	
	
	/**
	 * isLeaf - returns whether the node in question is a leaf or not.
	 * 		id est, has only one neighbor.
	 * 
	 * @param i: the name of the node in question
	 * @return TRUE if leaf, FALSE otherwise
	 */
	public boolean isLeaf(int i)
	{
		return (graph[i].getMetNeighbors() == 1);
	}
	
	/**
	 * isOdd - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/evenness is to be calculated
	 * @return TRUE if odd, FALSE otherwise
	 */
	public static boolean isOdd(int i)
	{
		return !isEven(i);
	}
	
	/**
	 * isSpine - determines whether or not the input graph is a SPINE GRAPH,
	 * 		id est, a graph with 2 leaves and (N - 2) nodes of degree-2.
	 * 
	 * @param g: the input graph
	 * @return TRUE if spine, FALSE otherwise
	 */
	public boolean isSpine(Graph g)
	{
		int i = 0;
		int leaves = 0;
		int nonleaves = 0;
		
		while ((leaves < 3) && (nonleaves < (g.getNumNodes() - 2)))
		{
			if (isLeaf(i))
			{
				leaves++;
			}
			else
			{
				nonleaves++;
			}
			i++;
		}
		
		if ((leaves == 2) && (nonleaves == (g.getNumNodes() - 2)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * isStar - determines whether or not the input graph is a STAR GRAPH,
	 * 		id est, a graph with (N - 1) leaves and 1 node of (N - 1) degree.
	 * 
	 * @param g: the input graph
	 * @return TRUE if star, FALSE otherwise
	 */
	public boolean isStar(Graph g)
	{
		int i = 0;
		int leaves = 0;
		int nonleaves = 0;
		
		while ((leaves < g.getNumNodes() - 1) && (nonleaves < 2))
		{
			if (isLeaf(i))
			{
				leaves++;
			}
			else
			{
				nonleaves++;
			}
			i++;
		}
		
		if (nonleaves == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * copy - copies the contents from one array to another
	 * 
	 * @param oldArray - the copy destination
	 * @param newArray - the array to be copied
	 * @return the copied array
	 */
	//public static 
	
	/**
	 * getDiameter - determines the diameter of the tree by finding the maximum
	 * 		depth of Node farthest from the root.
	 * 
	 * @param t: the tree
	 * @return the maximum depth of the tree
	 */
	public int getDiameter(Tree t)
	{
		int maxDepth = 0; 
		
		for (int i = 0; i < t.getNumNodes(); i++)
		{	
			if (((TreeNode) getGraph()[i]).getDepth() > maxDepth)
			{
				maxDepth = ((TreeNode) getGraph()[i]).getDepth();
			}
		}
		return maxDepth;
	}
}