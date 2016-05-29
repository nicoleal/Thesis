/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Menu Class
 * 			A console-style menu for deciding which graph / algorithm to run.
 * 			May eventually be replaced by a GUI, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 16 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import java.util.Scanner;
public class Menu 
{
	private Scanner s;
	private int first;
	private int second;
	private int third;
	
	/**
	 * NO-ARG CONSTRUCTOR for menu, which initiates the scanner.
	 */
	public Menu()
	{
		s = new Scanner(System.in);
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                          LET'S MAKE A TREE                                 *
	 *                                                                            *
	 ******************************************************************************/
	

	/**
	 * setup - the method that runs at the beginning of every tree section. Prints the
	 * 		top menu to console, take the tree choice into first, prints out the vertex
	 * 		menu, takes the choice into second, and passe to whatTree().
	 * 
	 * @throws Exception
	 */
	public void setup() throws Exception
	{
		topMenu();
		first = s.nextInt();
		if (first == 2)
		{
			System.exit(0);
		}
		vertexMenu();
		second = s.nextInt();
		whatTree(first, second);
	}
	
	/**
	 * whatTree - the start of many a decision tree as to what type of tree the 
	 * 		program should make and how many nodes the tree should have. Passes
	 * 		Along to the proper algorithm menu for the type of tree.
	 * 
	 * @param i: what kind of tree
	 * @param n: how many nodes
	 * @throws Exception
	 */
	public void whatTree(int i, int n) throws Exception
	{
		Tree t = new Tree();
		switch(i)
		{
			case 1:
			{
				cat1TreePrinter(cat1MenuPrinter(t.buildCat1(t, n), n), n);
				break;
			}
			case 2: // ADD MORE CASES HERE
			default:
			{
				System.exit(0);
			}
		}

	}


	/******************************************************************************
	 *                                                                            *
	 *                                   Menus                                    *
	 *                                                                            *
	 ******************************************************************************/


	/**
	 * cat1Menu - prints menu for T1 Caterpillar coloring algorithms. 1 - V1 Children.
	 * 		2 - best line spine. 
	 */
	public void cat1Menu()
	{
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println("*                                                                              *");
		System.out.println("*     What Algorithim Would You Like to Examine?                               *");
		System.out.println("*                                                                              *");
		System.out.println("*     1) V1 Children                                                           *");
		System.out.println("*     2) V1-V2-V1-V3 Spine                                                     *");
		System.out.println("*     3) Exit                                                                  *");
		System.out.println("*                                                                              *");
		System.out.println("********************************************************************************");
		System.out.println();
		System.out.println();
	}
	
	/**
	 * topMenu - prints out the first menu, which asks what type of tree to build
	 * 			1 - T1 Caterpillar.
	 */
	public void topMenu()
	{
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println("*                                                                              *");
		System.out.println("*     What Type of Tree Would You Like to Examine?                             *");
		System.out.println("*                                                                              *");
		System.out.println("*     1) Caterpillar - Type 1 (|v| <= 3)                                       *");
		System.out.println("*     2) Exit                                                                  *");
		System.out.println("*                                                                              *");
		System.out.println("********************************************************************************");
		System.out.println();
		System.out.println();
	}

	/**
	 * vertexMenu - prints out the vertex menu, which asks how many vertices there
	 * 		should be in the tree decided on in the top menu.
	 */
	public void vertexMenu()
	{
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println("*                                                                              *");
		System.out.println("*     How Many Vertices Would You Like the Tree to Have?                       *");
		System.out.println("*                                                                              *");
		System.out.println("********************************************************************************");
		System.out.println();
		System.out.println();
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Which Algorithm?                                *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * cat1MenuPrinter - after a T1 Caterpillar is chosen, prints the algorithms menu, sets
	 * 		third to input, and runs the algorithm. 
	 *  
	 * @param t: the tree in question
	 * @param n: the number of vertices
	 * @return the colored tree
	 */
	public Tree cat1MenuPrinter(Tree t, int n)
	{
		cat1Menu();
		third = s.nextInt();
		System.out.println(third);
		
		switch(third)
		{
			case 1:
			{
				return Coloring.womenAndChildrenFirst(t, n);
			}
			case 2: 
			{	
				return Coloring.backbone(t, n);
			}
			case 3:	// ADD MORE CASES HERE
			default:
			{
				System.exit(0);
			}
		}
		return t;
	}
	
	
	/**
	 * cat1TreePrinter - provides a "graphical" tree on the console for T1 
	 * 		Caterpillar trees only. 
	 * 
	 * @param t: the tree to print
	 * @param n: the number of vertices 
	 */
	public void cat1TreePrinter(Tree t, int n)
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
