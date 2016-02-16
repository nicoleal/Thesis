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
		int maxSeen = 2;
		
		for (int i = 1; i < n; i++)
		{
			int workingColor;
			
			if(isEven(i))
			{
				workingColor = 2;
				int j = i - workingColor;
				if (j > 0)
				{
					if (t.getLeaf(t, j).getColor() == workingColor)
					{
						workingColor++;
					}
					else
					{
						while (j != i + workingColor)
						{
							
						}
					}
				}
				
			}
			else
			{
				t.getLeaf(t, i).setColor(1);
			}
		}
		return t;
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
