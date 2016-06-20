/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		BruteForceColoring Class
 * 			The broadcast chromatic number of any graphs can be found
 * 			in non-polynomial time using a Brute Force method of computation.
 * 			This class contains those methods et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 10 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class BruteForceColoring extends Colorings
{
	public int chi;										// The BCN
	public int[] theirNeighbors;						// A holder for the neighbors' neighbors
	
	
	/**
	 * bruteForce - a brute force attempt at coloring outwards. Starts from a "center"
	 * 		node, assigns it RED (1), all its neighbors a unique (2+) color, and all
	 * 		its neighbors' neighbors RED (1). Will eventually recurse back so that 
	 * 		brute force is run on all uncolored (White (0)) "grandchildren" of the 
	 * 		original node, id est, the contents of the theirNeighbors array.
	 * 
	 * @param g: the input graph
	 * @param center: the start point
	 * @return the colored graph
	 */
	public Graph bruteForce(Graph g, int center)
	{
		theirNeighbors = new int[getNumNodes()];
		g.graph[center].setColor(Color.RED);		// RED (1), V1
		
		int j = 2;
		for (int i = 0; i < g.graph[center].getMetNeighbors(); i++)
		{
			Node n = g.graph[g.graph[center].neighbors[i]];
			n.setColor(j);
			setChi(j);
			j++;
			
			for (int k = 1, l = 0; k < n.getMetNeighbors(); k++, l++)
			{
				theirNeighbors[l] = n.neighbors[k];
				if (!isColored(g.graph[theirNeighbors[l]]))
				{
					g.graph[theirNeighbors[l]].setColor(Color.RED);
				}
			}
		}

		for (int i = 0; i < theirNeighbors.length; i++)
		{
			Node m = g.graph[theirNeighbors[i]];
			
			for (int k = 0; k < m.getMetNeighbors(); k++)
			{
				int y = g.graph[m.getName()].neighbors[k];
				if (!isColored(g, y))
				{
					g.graph[y].setColor(j);
					setChi(j);
					j++;
				}
				
				Node n = g.graph[y];
				
				if (n.getMetNeighbors() > 1)
				{
					for (int l = 0; l < g.graph[n.getName()].getMetNeighbors(); l++)
					{
						int x = g.graph[n.getName()].neighbors[l];
						if (!isColored(g, x))
						{
							g.graph[x].setColor(Color.RED);
						}
					}
				}
			}
		}
		//System.out.println("\nThe Broadcast Chromatic Number is " + getChi() + ".\n");
		return g;
	}
	
	/**
	 * forceGraph - runs bruteForce() on each node of the graph, to find the lowest possible BCN /
	 * 		 best possible coloring. 
	 * 
	 * @param g: the input graph
	 * @return the best coloring
	 */
	public Graph forceGraph(Graph g)
	{
		int bestChi = g.getNumNodes();
		int tempChi;
		int bestColoring = 0;
		
		for (int i = 0; i < g.getNumNodes(); i++)
		{
			tempChi = bruteForce(g, i).getChi();
			
			if (tempChi < bestChi)
			{
				bestChi = tempChi;
				bestColoring = i;
			}
		}
		g = bruteForce(g, bestColoring);
		setChi(g.getChi());
		System.out.println("\nThe Broadcast Chromatic Number is " + getChi() + ".\n");
		
		return g;
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
	
	/**
	 * getTheirNeighbors - standard getter for theirNeighbors
	 * 
	 * @return theirNeighbors
	 */
	public int[] getTheirNeighbors()
	{
		return theirNeighbors;
	}
	
	/**
	 * setChi - sets the value of chi (X), the broadcast chromatic number
	 * 
	 * @param chi: the value to be set to the broadcast chromatic number
	 */
	protected void setChi(int chi1)
	{
		if (chi1 > getChi())
		{
			chi = chi1;
		}
	}
	
	/**
	 * setTheirNeighbors - standard setter for TheirNeighbors
	 * 
	 *  @param array: the value to set theirNeighbors to
	 */
	public void setTheirNeighbors(int[] array)
	{
		theirNeighbors = array;
	}
}
