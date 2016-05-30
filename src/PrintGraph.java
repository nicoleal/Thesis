/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		PrintGraph Class
 * 			A subclass for printing graphs in both pictorial and numerical
 * 			ways, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class PrintGraph 
{
	/******************************************************************************
	 *                                                                            *
	 *                         Numerical   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * printList - prints a specified tree as a series of parents
	 * 		and their children in the following manner:
	 * 
	 * 		X: XX XX XX
	 * 
	 * @param t - the tree
	 * @param numNodes - manyItems
	 */
	protected static void printList(Tree t, int numNodes)
	{
		for (int i = 0; i < numNodes; i++)
		{
			if (t.tree[i].hasKids())
			{
				System.out.print(t.tree[i].getName() + ": ");
				for (int j = 0; j < t.tree[i].getKids(); j++)
				{
				
					System.out.print(t.tree[i].children[j].getName() + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                         Graphical   Methods                                *
	 *                                                                            *
	 ******************************************************************************/	
	
	/**
	 * cat1TreePrinter - provides a "graphical" tree on the console for T1 
	 * 		Caterpillar trees only. 
	 * 
	 * @param t: the tree to print
	 * @param n: the number of vertices 
	 */
	public static void cat1TreePrinter(Tree t, int n)
	{
		for (int i = 0; i < n; i = i + 2)
		{
			int v = t.getLeaf(t, i).getName();
			if (v < 10)
			{
				System.out.print("--V0" + v + "--   ");
			}
			else
			{
				System.out.print("--V" + v + "--   ");
			}
		}
		System.out.print("\n");
		for (int i = 0; i < n - 2; i = i + 2)
		{
			System.out.print("|     |---");
		}
		System.out.print("|     |");
		System.out.print("\n");
		for (int i = 0; i < n; i = i + 2)
		{
			int c = t.getLeaf(t, i).getColor();
			if (c < 10)
			{
				System.out.print("|  " + c + "  |   ");
			}
			else
			{
				System.out.print("|  " + c + " |   ");
			}
		}
		System.out.print("\n");
		for (int i = 0; i < n/2; i++)
		{
			System.out.print("-------   ");
		}
		System.out.print("\n");
		
		
		for (int i = 0; i < n/2; i++)
		{
			System.out.print("   |      ");
		}
		System.out.print("\n");
		for (int i = 0; i < n/2; i++)
		{
			System.out.print("   |      ");
		}
		System.out.print("\n");
		
		
		for (int i = 1; i < n; i = i + 2)
		{
			int v = t.getLeaf(t, i).getName();
			if (v < 10)
			{
				System.out.print("--V0" + v + "--   ");
			}
			else
			{
				System.out.print("--V" + v + "--   ");
			}
		}
		System.out.print("\n");
		for (int i = 1; i < n - 2; i = i + 2)
		{
			System.out.print("|     |   ");
		}
		System.out.print("|     |");
		System.out.print("\n");
		for (int i = 1; i < n; i = i + 2)
		{
			int c = t.getLeaf(t, i).getColor();
			if (c < 10)
			{
				System.out.print("|  " + c + "  |   ");
			}
			else
			{
				System.out.print("|  " + c + " |   ");
			}
		}
		System.out.print("\n");
		for (int i = 0; i < n/2; i++)
		{
			System.out.print("-------   ");
		}
	}
}
