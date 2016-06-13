/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Helper Class
 * 			A collection of helper classes a la the Math Class, et 
 * 			hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 10 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Helper 
{
	/******************************************************************************
	 *                                                                            *
	 *                            Boolean  Methods                                *
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
	public static Boolean areNeighbors(int node1, int node2)
	{
		boolean one = false;
		boolean two = false;
		
		for (int i = 0; i < Graph.graph[node1].getMetNeighbors(); i++)
		{
			if (Graph.graph[node1].neighbors[i] == node2);
			{
				one = true;
			}
		}
		
		for (int i = 0; i < Graph.graph[node2].getMetNeighbors(); i++)
		{
			if (Graph.graph[node2].neighbors[i] == node1);
			{
				two = true;
			}
		}
		
		return (one && two);
	}
	
	/**
	 * areNeighbors - determines if two gives nodes are neighbors by checking their
	 * 		neighbors arrays (both of them). NODE VERSION.
	 * 
	 * @param node1: the first node to be compared
	 * @param node2: the second node to be compared.
	 * return TRUE if neighbors, false otherwise
	 */
	public static Boolean areNeighbors(Node node1, Node node2)
	{
		boolean one = false;
		boolean two = false;
		
		for (int i = 0; i < node1.getMetNeighbors(); i++)
		{
			if (node1.neighbors[i] == node2.getName());
			{
				one = true;
			}
		}
		
		for (int i = 0; i < node2.getMetNeighbors(); i++)
		{
			if (node2.neighbors[i] == node1.getName());
			{
				two = true;
			}
		}
		
		return (one && two);
	}
	
	/**
	 * isColored - determines if the node has been colored / has
	 * 		a color other than WHITE (1). INT-NAME VERSION
	 * 
	 * @param i: the name of the node
	 * @return TRUE if colored, FALSE otherwise
	 */
	public static Boolean isColored(int i)
	{
		return (Graph.getLeaf(i).getColor() != Color.WHITE.getRadius());
	}
	
	/**
	 * isColored - determines if the node has been colored / has
	 * 		a color other than WHITE (1). NODE VERSION
	 * 
	 * @param i: the name of the node
	 * @return TRUE if colored, FALSE otherwise
	 */
	public static Boolean isColored(Node node)
	{
		return (node.getColor() != Color.WHITE.getRadius());
	}
	
	/**

	 * isEven - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/evenness is to be calculated
	 * @return TRUE if even, FALSE otherwise
	 */
	public static Boolean isEven(int i)
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
	public static Boolean isLeaf(int i)
	{
		return (Graph.getLeaf(i).getMetNeighbors() == 1);
	}
	
	/**
	 * isOdd - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/evenness is to be calculated
	 * @return TRUE if odd, FALSE otherwise
	 */
	public static Boolean isOdd(int i)
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
	 * getDiameter - determines the diameter of the tree by finding the maximum
	 * 		depth of Node farthest from the root.
	 * 
	 * @param t: the tree
	 * @return the maximum depth of the tree
	 */
	public static int getDiameter(Tree t)
	{
		int maxDepth = 0; 
		
		for (int i = 0; i < t.getNumNodes(); i++)
		{	
			if (((TreeNode) Tree.getGraph()[i]).getDepth() > maxDepth)
			{
				maxDepth = ((TreeNode) Tree.getGraph()[i]).getDepth();
			}
		}
		
		return maxDepth;
	}
	
	/**
	 * isCenter - returns the Node at the center of the graph / with the highest number
	 * 		of metNeighbors. If there are duplicates, the Node with the smallest (lowest)
	 * 		name is selected. 
	 * 
	 * @param g: the graph
	 * @return the central Node
	 */
	public static Node isCenter(Graph g)
	{
		int center = 0;
		int maxMetNeighbors = 1;
		
		for (int i = 0; i < g.getNumNodes(); i++)
		{
			if (Graph.getGraph()[i].getMetNeighbors() > maxMetNeighbors)
			{
				maxMetNeighbors = Graph.getGraph()[i].getMetNeighbors();
				center = i;
			}
		}
				
		return Graph.getGraph()[center];
	}
	
}
