/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		BruteForceColoring Class
 * 			The broadcast chromatic number of any graphs can be found
 * 			in non-polynomial time using a Brute Force method of computation.
 * 			This class contains those methods et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 1 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class BruteForceColoring 
{
	private static int bestColoring[];
	private static int coloring[];
	private static int maxColors;
	private static int maxUsed;
	private static Tree tree;
	
	/**
	 * ONE-ARG CONSTRUCTOR for BruteForceColoring in which every possible coloring is
	 * 		checked - until that coloring exceeds the maxUsed value for the current
	 * 		best (smallest) coloring. 
	 * 
	 * @param numNodes: the number of nodes in the graph, also the upper bound for
	 * 			number of colors that can be used to color that graph.
	 */
	public BruteForceColoring(int numNodes)
	{
		coloring = new int[numNodes];
		maxColors = numNodes;
	}
	
	/**
	 * bruteForce - takes a graph and, giving one vertex a starting color of 1,
	 * 		colors the remainder of the graph accordingly. It will stop the
	 * 		process and return a value of -1 if the highest locally used color ever
	 * 		exceeds the current global highest used color, otherwise it will return
	 * 		the minimal broadcast chromatic number.
	 * 
	 * @param start: the vertex to be colored 1 from the start
	 * @return localMax: the highest color used in this coloring
	 */
	public static int bruteForce(int start)
	{
		setup();
		coloring[start] = 1;
		
		int color;
		int localMax = 1;
		int vertex = 0;
		
		while ((localMax <= getMaxUsed()) && (vertex < getMaxColors()))
		{
			color = whatColor(vertex);
			
			if (color <= getMaxUsed())
			{
				coloring[vertex] = color;
				vertex++;
				
				if (localMax < color)
				{
					localMax = color;
				}
			}
			else
			{
				return -1;
			}
		}
		
		return localMax;
	}
	
	/**
	 * bruteForceAll - a method that runs through every vertex, using that vertex as
	 * 		a color-1 starting point, and returns the lowest generated value. Will also
	 * 		copy the current best coloring into the bestColoring array.
	 * @return
	 */
	public static int bruteForceAll()
	{
		int current = getMaxUsed();
		int currentMax = getMaxColors();
		
		for (int i = 0; i < getMaxColors(); i++)
		{
			current = bruteForce(i);
			
			if (current < currentMax)
			{
				copy();
				currentMax = current;
			}
		}
		
		return currentMax;
	}
	
	/**
	 * colorMe - runs the brute force algorithm on the given graph and sets the colors
	 * 		according to the best possible coloring (id est, the minimum coloring).
	 * 
	 * @param t: the uncolored tree
	 * @return the colored tree
	 */
	public static Tree colorMe(Tree t)
	{
		setTree(t);
		setMaxColors(t.getNumNodes(t));
		setMaxUsed(1);
		coloring = new int[t.getNumNodes(t)];
		bestColoring = new int[t.getNumNodes(t)];
		
		bruteForceAll();
		
		for (int i = 0; i < getMaxColors(); i++)
		{
			tree.tree[i].setColor(bestColoring[i]);
		}
		
		return tree;
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * getBestColoring - standard getter for bestColoring.
	 * 
	 * @return bestColoring
	 */
	public int[] getBestColoring()
	{
		return bestColoring;
	}
	
	/**
	 * getColoring - standard getter for coloring.
	 * 
	 * @return coloring
	 */
	public int[] getColoring()
	{
		return coloring;
	}
	
	/**
//	 * getMaxColors - standard getter for maxColors.
	 * 
	 * @return maxColors
	 */
	public static int getMaxColors()
	{
		return maxColors;
	}
	
	/**
	 * getMaxUsed - standard getter for maxUsed.
	 * 
	 * @return maxUsed
	 */
	public static int getMaxUsed()
	{
		return maxUsed;
	}
	
	/**
	 * getTree - standard getter for tree.
	 * 
	 * @return tree
	 */
	public Tree getTree()
	{
		return tree;
	}
	
	/**
	 * setBestColoring - standard setter for bestColoring.
	 * 
	 * @param color: an array of Colors
	 */
	public void setBestColoring(int color[])
	{
		bestColoring = color;
	}
	
	/**
	 * setColoring - standard setter for coloring.
	 * 
	 * @param color: an array of Colors
	 */
	public void setColoring(int color[])
	{
		coloring = color;
	}
	
	/**
	 * setMaxColors - standard setter for maxColors.
	 * 
	 * @param color: an integer value
	 */
	public static void setMaxColors(int color)
	{
		maxColors = color;
	}
	
	/**
	 * setMaxUsed - standard setter for maxUsed.
	 * 
	 * @param color: an integer value
	 */
	public static void setMaxUsed(int color)
	{
		maxUsed = color;
	}
	
	/**
	 * seTree - standard setter for tree.
	 * 
	 * @param tree: a Tree
	 */
	public static void setTree(Tree t)
	{
		tree = t;
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * copy - copies the coloring array into the bestColoring array.
	 */
	private static void copy()
	{
		for (int i = 0; i < getMaxColors(); i++)
		{
			bestColoring[i] = coloring[i];
		}
		
	}
	
	/**
	 * setup - creates an array of uncolored "vertices".
	 */
	private static void setup()
	{
		for (int i = 0; i < getMaxColors(); i++)
		{
			coloring[i] = 0;
		}
		
	}
	
	/**
	 * uncolored - method that determines if the vertex has been assigned a color.
	 * 
	 * @param vertex: the number of the vertex
	 * @return true if uncolored, false otherwise
	 */
	private static Boolean uncolored(int vertex)
	{
		return (coloring[vertex] == 0);
	}
	
	/**
	 * whatColor - a 1-PARAM version of whatColor(), which checks to see if the vertex
	 * 		is uncolored. If not, it sends to whatColor(Tree, Node); otherwise it returns
	 * 		the color the vertex already is.
	 * 
	 * @param vertex: the number of the vertex
	 * @return the int color of the vertex
	 */
	private static int whatColor(int vertex)
	{
		if (uncolored(vertex))
		{
			return whatColor(tree, tree.tree[vertex].getNode(), 1);
		}
		else
		{
			return coloring[vertex];
		}
	}
	
	/**
	 * whatColor - a 2-PARAM for determining what color to assign a vertex.
	 * 
	 * @param t: the tree
	 * @param node: the node in question
	 * @return the int value of the vertex
	 */
	private static int whatColor(Tree t, Node node, int potentialColor)
<<<<<<< HEAD
	{	
		if (node.hasParent())
		{
			if (coloring[node.getParent().getName()] == potentialColor)
			{
				return 1 + whatColor(t, node.getParent().getParent(), potentialColor++);
=======
	{
		int c = 0;
		
		if (node.hasParent())
		{
			if (node.getParent().getColor() == potentialColor)
			{
				c = 1 + whatColor(t, node.getParent().getParent(), potentialColor++);
>>>>>>> origin/master
			}
		}
		
		if (node.hasKids())
		{
			for (int i = 0; i < node.getKids();)
			{
<<<<<<< HEAD
				if (coloring[node.children[i].getName()] == potentialColor)
				{
					return 1 + whatColor(t, t.tree[node.children[i].getName()].getNode(), potentialColor++);
=======
				if (node.children[i].getColor() == potentialColor)
				{
					//c = 1 + whatColor(t, t.tree[node.children[i].getName()].getNode(), potentialColor++);
>>>>>>> origin/master
				}
			}
		}

		System.out.println(coloring[0] + " " + coloring[1]);
<<<<<<< HEAD
		return 1;
=======
		return c;
>>>>>>> origin/master
	}
	
}
