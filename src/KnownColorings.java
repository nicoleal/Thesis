/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		KnownColoring Class
 * 			The broadcast chromatic number of certain specific graphs
 * 			- spines, lobsters, caterpillars, et cetra - are known.
 * 			This class contains the methods used to compute them, et 
 * 			hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 10 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class KnownColorings extends Colorings
{
	private int chi;									// The BCN, pronounced "kai"
	
	/******************************************************************************
	 *                                                                            *
	 *							   DEFAULT GRAPHS                                 *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * knownFourDiamTree - Colors the graph according to the known Broadcast Chromatic
	 * 		coloring of a diameter-4 Tree. Formula taken from <i>"BROADCAST CHROMATIC</i>
	 * 		<i>NUMBERS OF GRAPHS"</i> by Goddard et al., page 10-12. 
	 * 
	 * {@link http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.140.2341&rep=rep1&type=pdf}
	 * @param g: the graph to color
	 * @param v: the central vertex of the graph
	 * @return the colored graph
	 */
	public void knownFourDiamTree(Graph g, int v)
	{
		int degree;									// A general, all purpose int
		int n1 = 0;									// Nodes with a metNeighbors of 1 / leaves
		int n2 = 0;									// Nodes with a metNeighbors of 2
		int n3 = 0;									// Nodes with a metNeighbors of 3
		int L = 0;									// Nodes with a metNeighbors of 4+ / large nodes
		int s = 0;									// Nodes with a metNeighbors of <4 / small nodes
		int[] small = new int[g.getNumNodes()];		// An array to hold all small nodes
		int[] large = new int[g.getNumNodes()];		// An array to hold all large nodes
		
		/*
		 * Sorts and counts the types of nodes - n1, n2, n3, and L
		 * 		- and places them into their respective arrays - 
		 * 		large (for degree-4 or more) or small (up to degree-3).
		 */
		for (int i = 0, j = 0, k = 0; i < g.getNumNodes(); i++)
		{
			if (areNeighbors(v, i) && (v != i))
			{
				degree = graph[i].getMetNeighbors();
			
				if (degree > 3)
				{
					L++;
					large[j] = i;
					j++;
				}
				else
				{
					if (degree == 1)
					{
						n1++;
					}
					else if (degree == 2)
					{
						n2++;
					}
					else // (degree == 3)
					{
						n3++;
					}
					small[k] = i;
					k++;
				}
			}
		}
		s = n1 + n2 + n3;
		
		/*
		 * Center first coloring, ideal for (n1 = n2 = 0) and either
		 * 		(L = 0 and 2 <= n3 <= 3) or (L > 0 and n3 < 3).
		 * 		
		 */
		if ((n1 == 0) && (n2 == 0))
		{
			if (((L == 0) && ((n3 == 3) || (n3 == 2))) || 
					(L > 0) && (n3 < 3))
			{
				graph[large[0]].setColor(Color.RED);			// RED (1), V1
				int j = Color.BLUE.getRadius();
				for (int i = 0; i < s; i++)
				{
					if (isLeaf(small[i]))
					{
						graph[small[i]].setColor(Color.RED);		// RED (1), V1
					}
					else
					{
						graph[small[i]].setColor(j);		// (2+), unique colors
						j++;
					}
				}

				for (int i = 1; i < L; i++, j++)
				{
					graph[large[i]].setColor(j);			// (2+), unique colors
				}
				
				setChi(j);
				g.setChi(getChi());
				System.out.println("\nThe Broadcast Chromatic Number is " + getChi() + ".\n");
			}
		}
		
		/*
		 * Green center coloring, suitable only for (n3 = 1 
		 * 		and l = 0). Only type of diam-4 with BCN-3.
		 */
		if ((L == 0) && (n3 == 1))
		{
			graph[v].setColor(Color.GREEN);
		
			for (int i = 0; i < g.getNumNodes(); i++)
			{
				degree = graph[i].getMetNeighbors();		// GREEN (3), V3
				
				if (((degree == 3) && (i != v)) || ((degree == 2) && 
						(areNeighbors(((TreeNode) graph[i]).getParent(), v))))
								{
					graph[i].setColor(Color.BLUE);		// BLUE (2), V2
				}
				else if (i != v)
				{
					graph[i].setColor(Color.RED);		// RED (1), V1
				}
			}
			
			setChi(Color.GREEN.getRadius());
			g.setChi(getChi());
			System.out.println("\nThe Broadcast Chromatic Number is " + getChi() + ".\n");
		}
		
		/*
		 * Leaf first coloring, ideal for all other situations.
		 * T5_Graph example.
		 */
		for (int i = 0; i < L; i++)
		{
			for (int j = 1; j <graph[large[i]].getMetNeighbors(); j++)
			{
				if (graph[graph[large[i]].getNeighbor(j)].getName() != v);
				graph[graph[large[i]].getNeighbor(j)].setColor(Color.RED);		// RED (1), V1
			}

		}
			
		int j = Color.BLUE.getRadius();							// BLUE (2), V2
		
		for (int k = 0; k < s; k++)
		{
			if (!isColored(small[k]))	
			{
				graph[small[k]].setColor(Color.RED);
				graph[graph[small[k]].getNeighbor(1)].setColor(Color.BLUE);
				if (graph[small[k]].getMetNeighbors() == 3)
				{
					graph[graph[small[k]].getNeighbor(2)].setColor(Color.GREEN);
				}
			}
			else
			{
				k++;
			}
		}
		
		for (int i = 0; i < graph.length; i++)
		{
			if (!isColored(graph[i]) && (i != v))
			{
				if (j == Color.GREEN.getRadius())
				{
					j++;
				}
				graph[i].setColor(j); 		// (2+), unique colors
				j++;
			}
		}
		graph[v].setColor(j); 
		setChi(j);
		g.setChi(getChi());
		System.out.println("\nThe Broadcast Chromatic Number is " + getChi() + ".\n");
	} 
	
	/**
	 * knownSmallTree - Colors the graph according to the known Broadcast Chromatic
	 * 		coloring of a Small (diameter-3) Tree, whereby the root and leaves are 
	 * 		colored 1 and the middle layer 2. Formula taken from <i>"BROADCAST CHROMATIC</i>
	 * 		<i>NUMBERS OF GRAPHS"</i> by Goddard et al., page 10. 
	 * 
	 * {@link http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.140.2341&rep=rep1&type=pdf}
	 * @param g: the graph to color
	 * @return the colored graph
	 */
	public static Graph knownSmallTree(Graph g)
	{
		//TODO
		
		return g;
	}
	
	/**
	 * knownSpine - Colors the graph according to the known Broadcast Chromatic
	 * 		coloring of a Spine (1, 2, 1, 3, 1....) if (N == 4), else (...,4).
	 * 		Formula taken from <i>"BROADCAST CHROMATIC NUMBERS OF GRAPHS"</i> by
	 * 		Goddard et al., page 4-5.
	 * 
	 * {@link http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.140.2341&rep=rep1&type=pdf}
	 * @param g: the graph to color
	 * @return the colored graph
	 */
	public Graph knownSpine(Graph g)
	{		
		int remainder = g.getNumNodes() % 4;
		int setsOfFour = g.getNumNodes() - remainder;
		
		for (int i = 0; i < setsOfFour; i++)
		{
			if (isEven(i))						// (1, ?, 1, ? 1, ?, 1, ? ....)
			{
				graph[i].setColor(Color.RED);		// RED (1), V1
			}
			else if ((i % 4) == 1)						// (1, 2, 1, ? 1, 2, 1, ? ....)
			{
				graph[i].setColor(Color.BLUE);		// BLUE (2), V2
			}
			else										// (1, 2, 1, 3, 1, 2, 1, 3 ....)
			{
				graph[i].setColor(Color.GREEN);		// GREEN (3), V3
			}
		}
		setChi(Color.GREEN.getRadius());
		
		if (remainder != 0)
		{
			if (remainder == 1)							// (1, 2, 1, 3 1, 2, 1, ... 3, 4)
			{
				graph[setsOfFour].setColor(Color.YELLOW);	// YELLOW (4), V4
			}
			else if (remainder == 2)					// (1, 2, 1, 3, 1, 2, 1, ... 3, 1, 4)
			{
				graph[setsOfFour].setColor(Color.RED);		// RED (1), V1
				graph[setsOfFour + 1].setColor(Color.YELLOW);	// YELLOW (4), V4
			}
			else										// (1, 2, 1, 3, 1, 2, 1, ... 3, 1, 2, 4)
			{
				graph[setsOfFour].setColor(Color.RED);		// RED (1), V1
				graph[setsOfFour + 1].setColor(Color.BLUE);		// BLUE (2), V2
				graph[setsOfFour + 2].setColor(Color.YELLOW);	// YELLOW (4), V4
			}
			setChi(Color.YELLOW.getRadius());
		}
		
		g.setChi(getChi());
		System.out.println("\nThe Broadcast Chromatic Number is " + getChi() + ".\n");
		return g;
	}
	
	/**
	 * knownStar - Colors the graph according to the known Broadcast Chromatic
	 * 		coloring of a Star (1 for leaves, else 2). Formula taken from 
	 * 		<i>"BROADCAST CHROMATIC NUMBERS OF GRAPHS"</i> by Goddard et al.,
	 * 		page 6. 
	 * 
	 * {@link http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.140.2341&rep=rep1&type=pdf}
	 * @param g: the graph to color
	 * @return the colored graph
	 */
	public Graph knownStar(Graph g)
	{
		for (int i = 0; i < g.getNumNodes(); i++)
		{
			if (isLeaf(i))
			{
				graph[i].setColor(Color.RED);		// RED (1), V1
			}
			else
			{
				graph[i].setColor(Color.BLUE);		// BLUE (2), V2
			}
		}
		
		setChi(Color.BLUE.getRadius());
		g.setChi(getChi());
		System.out.println("\nThe Broadcast Chromatic Number is: " + getChi() + ".\n");
		
		return g;
	}
	
	/**
	 * knownTree - Colors the graph according to the known Broadcast Chromatic
	 * 		coloring of a Tree (diameter-2 -> Star; diameter-3 -> knownSmallTree;
	 * 		diameter-4+ -> according to the formula taken from <i>"BROADCAST CHROMATIC</i>
	 * 		<i>NUMBERS OF GRAPHS"</i> by Goddard et al., page 10-12. 
	 * 
	 * {@link http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.140.2341&rep=rep1&type=pdf}
	 * @param g: the graph to color
	 * @return the colored graph
	 */
	public void knownTree(Graph g)
	{
		if (getDiameter((Tree) g) == 2)
		{
			knownStar(g);
		}
		else if (getDiameter((Tree) g) == 3)
		{
			knownSmallTree(g);
		}
		else
		{
			knownFourDiamTree(g, 0);
		}
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard   Methods                              *
	 *                                                                            *
	 ******************************************************************************/

	/**
	 * getChi - returns the value of chi (X), the broadcast chromatic number
	 * 
	 * @return chi: the broadcast chromatic number
	 */
	public int getChi()
	{
		return chi;
	}
}
