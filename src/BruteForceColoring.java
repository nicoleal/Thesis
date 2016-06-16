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

public class BruteForceColoring 
{
	public static int[] theirNeighbors;						// A holder for the neighbors' neighbors
	public static int[] moreNeighbors;						// a holder for more neighbors
	
	/**
	 * bruteForce - a brute force attempt at coloring outwards. Starts from a "center"
	 * 		node, assigns it RED (1), all its neighbors a unique (2+) color, and all
	 * 		its neighbors' neighbors RED (1). Will eventually recurse back so that 
	 * 		brute force is run on all uncolored (White (0)) "grandchildren" of the 
	 * 		original node, id est, the contents of the theirNeighbors array.
	 * @param g
	 * @param center
	 * @return
	 */
	public static Graph bruteForce(Graph g, int center)
	{
		theirNeighbors = new int[Graph.getGraph().length];
		moreNeighbors = new int[Graph.getGraph().length];
		Graph.getGraph()[center].setColor(Color.RED);		// RED (1), V1
		
		int j = 2;
		for (int i = 0; i < Graph.getGraph()[center].getMetNeighbors(); i++, j++)
		{
			 Graph.getGraph()[Graph.getGraph()[center].neighbors[i]].setColor(j);
			
			for (int k = 1, l = 0; k < Graph.getGraph()[Graph.getGraph()[center].neighbors[i]].getMetNeighbors(); k++, l++)
			{
				theirNeighbors[l] = Graph.getGraph()[Graph.getGraph()[center].neighbors[i]].neighbors[k];
				Graph.getGraph()[theirNeighbors[l]].setColor(Color.RED);
			}
		}
		
		
		bruteForceLowerLevels(j);
		return g;
	}
	
	
	public static int bruteForceLowerLevels(int j)
	{
		for (int i = 0, q = 0; i < theirNeighbors.length; i++)
		{
			Node m = Graph.getGraph()[theirNeighbors[i]];
			
			for (int k = 0; k < m.getMetNeighbors(); k++)
			{
				int y = Graph.getGraph()[m.getName()].neighbors[k];
				if (!Helper.isColored(y))
				{
					Graph.getGraph()[y].setColor(j);
					j++;
				}
				
				Node n = Graph.getGraph()[y];
				
				if (n.getMetNeighbors() > 1)
				{
					for (int l = 1; l < Graph.getGraph()[n.getName()].getMetNeighbors(); l++)
					{
						int x = Graph.getGraph()[n.getName()].neighbors[l];
						if (!Helper.isColored(x))
						{
							Graph.getGraph()[x].setColor(Color.RED);
						}
						
						if (Graph.getGraph()[x].getMetNeighbors() > 1);
						{
							for (int z = 1; z < Graph.getGraph()[x].getMetNeighbors(); z++)
							{
								moreNeighbors[q] = Graph.getGraph()[x].neighbors[z];
								q++;
							}
						}
					}
				}
			}
		}
		return j;
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard   Methods                              *
	 *                                                                            *
	 ******************************************************************************/
		
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
	 * setTheirNeighbors - standard setter for TheirNeighbors
	 * 
	 *  @param array: the value to set theirNeighbors to
	 */
	public static void setTheirNeighbors(int[] array)
	{
		theirNeighbors = array;
	}
}
