/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		RandomGraphGenerator Class
 * 			A subclass for random graphs working within the confines
 * 			described elsewhere in the TREE CLASS, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import java.util.Random;

@SuppressWarnings("serial")
public class RandomGraphGenerator extends Tree
{
	public static Random r1 = new Random();
	public static Random r2 = new Random();
	
	/**
	 * makeRandom - constructs a random, non-cyclic tree
	 * 
	 * @param t - the tree
	 * @param numNodes - manyItems
	 * @return the generated tree
	 * @throws Exception
	 */
	protected static Tree makeRandom(Tree t, int numNodes) throws Exception
	{
		int d = r1.nextInt(20);
		setTreeDegree(t, d);
		t.makeRoot(t, numNodes, d);
		
		int mother;
		for (int i = 1; i < numNodes; i++)
		{
			t.setCounter(t, i);
			mother =  r2.nextInt(i);
			while (!t.tree[mother].canHaveKids());
			{
				mother =  r2.nextInt(i);
			}
			t.tree[i] = birth(t, t.tree[mother].getNode(), d);
		}
		
		//PrintGraph.printList(t, numNodes);
		//PrintGraph.printToFile(t, numNodes, "OutputTest2");
		
		return t;
	}
	
	
}
