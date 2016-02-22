/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Coloring Class
 * 			A "Math Class"-like home for some of the algorithims I'd like
 * 			to study. I anticipate there will be quite a lot of them by the
 * 			end, so it may end up being Coloring Class 1 of X, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 16 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Coloring 
{
	
	/******************************************************************************
	 *                                                                            *
	 *                           T1 CATERPILLIAR METHODS                          *
	 *                                                                            *
	 ******************************************************************************/
	
	public static Tree womenAndChildrenFirst(Tree t, int n)
	{
		t.getLeaf(t, 0).setColor(2);
		//TODO
		
		return t;
	}
	
	public static Tree backbone(Tree t, int n)
	{
		Tree tree = t;
		for (int i = 0; i < n - 6; i += 8)
		{
			tree.getLeaf(tree, i).setColor(1);
			tree.getLeaf(tree, i + 2).setColor(2);
			tree.getLeaf(tree, i + 4).setColor(1);
			tree.getLeaf(tree, i + 6).setColor(3);	
		}
		int j = n % 8;
		if (!isEven(j))
		{
			j++;
			n++;
		}
		
		if (j < 3)
		{
			tree.getLeaf(tree, n - 2).setColor(4);
		}
		else if (j < 6)
		{
			tree.getLeaf(tree, n - 4).setColor(1);
			tree.getLeaf(tree, n - 2).setColor(4);
		}
		else if (j < 8)
		{
			tree.getLeaf(tree, n - 6).setColor(1);
			tree.getLeaf(tree, n - 4).setColor(2);
			tree.getLeaf(tree, n - 2).setColor(4);
		}
		n--;
		
		
		for (int i = 1; i < n - 6; i += 8)
		{
			tree.getLeaf(tree, i).setColor(4);
			tree.getLeaf(tree, i + 2).setColor(5);
			tree.getLeaf(tree, i + 4).setColor(4);
			tree.getLeaf(tree, i + 6).setColor(6);	
		
		}
		
		j = n % 8;
		if (!isEven(j))
		{
			n--;
		}
		int maxColor = 6;
		if (j < 3)
		{
			tree.getLeaf(tree, n - 1).setColor(1);
		}
		else if (j < 6)
		{
			tree.getLeaf(tree, n - 3).setColor(5);
			tree.getLeaf(tree, n - 1).setColor(1);
		}
		else if (j < 8)
		{
			tree.getLeaf(tree, n - 5).setColor(5);
			tree.getLeaf(tree, n - 3).setColor(1);
			tree.getLeaf(tree, n - 1).setColor(7);
			maxColor = 7;
		}
		System.out.println("\nXb(T) = " + maxColor);
		
		return tree;
	}
	
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * isEven - a bitwise and to see if a number is odd or even.
	 * 
	 * @param i: the value whose oddness/eveness is to be calculated
	 * @return TRUE if even, FALSE otherwise
	 */
	private static Boolean isEven(int i)
	{
		return ((i & 1) == 0);
	}
}
