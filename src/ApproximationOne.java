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
