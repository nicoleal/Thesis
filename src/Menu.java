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
	private Scanner s;												// An instance of scanner
	private int first;												// The graph choice variable
	private int second;												// The numNodes choice variable
	private int third;												// The continue choice variable
	
	/**
	 * NO-ARG CONSTRUCTOR for menu, which initiates the scanner.
	 */
	public Menu()
	{
		s = new Scanner(System.in);
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                         LET'S MAKE A Graph                                 *
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
		if (first == 9)
		{
			System.exit(0);
		}
		
		vertexMenu();
		second = s.nextInt();
		whatGraph(first, second);

		continueMenu();
		third = s.nextInt();
		if (third == 2)
		{
			System.exit(0);
		}
		else
		{
			setup();
		}
	}
	
	/**
	 * whatGraph - builds the graph based on user response.
	 * 
	 * @param graph: the numerical identifier for which type of graph
	 * @param numNodes: the number of verticies the graph should have.
	 * @throws Exception
	 */
	public void whatGraph(int graph, int numNodes) throws Exception
	{
		Graph g;
		switch(graph)
		{
			case 1:
			{
				g = new Caterpillar_T1(numNodes);
				PrintGraph.printList_leadZero(g);
				break;
			}
			case 2:
			{
				g = new Caterpillar_T2(numNodes);
				PrintGraph.printList_leadZero(g);
				break;
			}
			case 3:
			{
				g = new Lobster_T1(numNodes);
				PrintGraph.printList_leadZero(g);
				break;
			}
			case 4:
			{
				g = new Lobster_T2(numNodes);
				PrintGraph.printList_leadZero(g);
				break;
			}
			case 5:
			{
				g = new RandomGraphGenerator(numNodes);
				PrintGraph.printList(g);
				break;
			}
			case 6:
			{
				g = new Spine(numNodes);
				PrintGraph.printList_leadZero(g);
				break;
			}
			case 7:
			{
				g = new Star(numNodes);
				PrintGraph.printList(g);
				break;
			}
			case 8:
			{
				userInputMenu();
				String fileName = s.next();
				g = new UserInputGraph(fileName);
				PrintGraph.printList(g);
				break;
			}
			default:
			{
				g = null;
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
	 * continueMenu - asks if the user would like to create another graph
	 */
	public void continueMenu()
	{
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println("*                                                                              *");
		System.out.println("*     Whould you like to make another graph?                                   *");
		System.out.println("*                                                                              *");
		System.out.println("*     1) Yes, I'd like to continue                                             *");
		System.out.println("*     2) No, I'd like to exit                                                  *");
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
		System.out.println("*     What Type of Graph Would You Like to Examine?                            *");
		System.out.println("*                                                                              *");
		System.out.println("*     1) Caterpillar - Type 1 (|v| <= 3)                                       *");
		System.out.println("*     2) Caterpillar - Type 2 (|v| <= 4)                                       *");
		System.out.println("*     3) Lobster - Type 1 (|v| <= 3)                                           *");
		System.out.println("*     4) Lobster - Type 2 (|v| <= 4)                                           *");
		System.out.println("*     5) Random Non-Cyclic Graph                                               *");
		System.out.println("*     6) Spine (Line Graph)                                                    *");
		System.out.println("*     7) Star                                                                  *");
		System.out.println("*     8) User Input Graph                                                      *");
		System.out.println("*     9) Exit                                                                  *");
		System.out.println("*                                                                              *");
		System.out.println("********************************************************************************");
		System.out.println();
		System.out.println();
	}
	
	/**
	 * userInputMenu - asks which file, as a string input, the user would like to
	 * 		build a graph from.
	 */
	public void userInputMenu()
	{
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println("*                                                                              *");
		System.out.println("*     Which File Would You Like to Use?                                        *");
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
		System.out.println("*     How Many Vertices Would You Like the Graph to Have?                      *");
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
	
	
	
}
