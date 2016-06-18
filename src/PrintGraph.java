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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintGraph extends Graph
{
	static PrintWriter writer;						// An instance of PrintWriter
	
	/******************************************************************************
	 *                                                                            *
	 *                         Numerical   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * printList - prints a specified graph as a series of nodes and their neighbors 
	 * 		in the following manner:
	 * 
	 * 		X: XX XX XX
	 * 		X: XX XX ....
	 * 
	 * @param g: the graph to be printed
	 */
	protected static void printList(Graph g)
	{
		System.out.print(g.getNode(0).getName() + ": ");
		for (int j = 0; j < g.getNode(0).getMetNeighbors(); j++)
		{
			System.out.print(g.getNode(0).neighbors[j] + " ");
		}
		System.out.println();
		
		for (int i = 1; i < g.getNumNodes(); i++)
		{
			if (g.getNode(i).getMetNeighbors() > 1)
			{
				System.out.print(g.getNode(i).getName() + ": ");
				
				for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
				{
					System.out.print(g.getNode(i).neighbors[j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	/**
	 * printListWithColors - prints a specified graph as a series of colored nodes and 
	 * 		their neighbors in the following manner:
	 * 
	 * 		0(Y)
	 * 		X: XX(Y) XX(Y) XX(Y)
	 * 		X: XX(Y) XX(Y) ....
	 * 
	 * @param g: the graph to be printed
	 */
	protected static void printListWithColors(Graph g)
	{
		System.out.println(g.getNode(0).getName() + "(" + g.getNode(0).getColor() + ")");
		for (int i = 0; i < g.getNumNodes(); i++)
		{		
			if (g.getNode(i).getMetNeighbors() > 1)
			{
				System.out.print(g.getNode(i).getName() + ": ");
				for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
				{
					System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
				}
			}
			else if ((g.getNode(i).getMetNeighbors() == 1) && (i != (g.getNumNodes() - 1)) 
					&& (i < g.getNode(i).neighbors[0]))
			{
				System.out.print(g.getNode(i).getName() + ": ");
				for (int j = 0; j < g.getNode(i).getMetNeighbors(); j++)
				{
					System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * printListWithColors_Stars - prints a specified graph as a series of colored nodes and 
	 * 		their neighbors in the following manner suitable for STAR GRAPHS:
	 * 
	 * 		0(Y)
	 * 		X: XX(Y) XX(Y) XX(Y)
	 * 		X: XX(Y) XX(Y) ....
	 * 
	 * @param g: the graph to be printed
	 */
	protected static void printListWithColors_Stars(Graph g)
	{
		System.out.println(g.getNode(0).getName() + "(" + g.getNode(0).getColor() + ")");
		for (int i = 0; i < g.getNumNodes(); i++)
		{		
			if (g.getNode(i).getMetNeighbors() > 1)
			{
				System.out.print(g.getNode(i).getName() + ": ");
				for (int j = 0; j < g.getNode(i).getMetNeighbors(); j++)
				{
					System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
				}
			}
			else if ((g.getNode(i).getMetNeighbors() == 1) && (i != (g.getNumNodes() - 1)) 
					&& (i < g.getNode(i).neighbors[0]))
			{
				System.out.print(g.getNode(i).getName() + ": ");
				for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
				{
					System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
				}
			}
				System.out.print(g.getNode(i).getName() + ": ");
				for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
				{
					System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
				}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * printListWithColors_ZeroFirst - prints a specified graph as a series of colored nodes and 
	 * 		their neighbors in the following manner suitable for NON-SPINE GRAPHS:
	 * 
	 * 		0(Y)
	 * 		X: XX(Y) XX(Y) XX(Y)
	 * 		X: XX(Y) XX(Y) ....
	 * 
	 * @param g: the graph to be printed
	 */
	protected static void printListWithColors_ZeroFirst(Graph g)
	{
		System.out.println(g.getNode(0).getName() + "(" + g.getNode(0).getColor() + ")");
		for (int i = 0; i < g.getNumNodes(); i++)
		{		
			if (g.getNode(i).getMetNeighbors() > 1)
			{
				System.out.print(g.getNode(i).getName() + ": ");
				if (g.getNode(i).neighbors[0] == 0)
				{
					for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
					{
						System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
					}
				}
				else
					for (int j = 0; j < g.getNode(i).getMetNeighbors(); j++)
					{
						System.out.print(g.getNode(i).neighbors[j] + "(" + g.getNode(g.getNode(i).neighbors[j]).getColor() + ") ");
					}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	/**
	 * printToFile - prints a specified graph as a series of nodes
	 * 		and their neighbors to a file in the following manner:
	 * 
	 * 		X: XX XX XX
	 * 		X: XX XX ... 
	 * 
	 * @param g: the graph
	 * @param fileName: the file name - sans extension - to be printed to
	 */
	protected static void printToFile(Graph g, String fileName) throws FileNotFoundException, UnsupportedEncodingException
	{
		fileName = "TestFiles\\" + fileName + ".txt";
		writer = new PrintWriter(fileName, "UTF-8");
		
		for (int i = 0; i < g.getNumNodes(); i++)
		{
			if (i == 0)
			{
				writer.print(g.getNode(i).getName() + ": ");
				for (int j = 0; j < g.getNode(i).getMetNeighbors(); j++)
				{
					writer.print(g.getNode(i).neighbors[j] + " ");
				}
				writer.println();
			}
			else if (g.getNode(i).getMetNeighbors() > 1)
			{
				writer.print(g.getNode(i).getName() + ": ");
				for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
				{
					writer.print(g.getNode(i).neighbors[j] + " ");
				}
				writer.println();
			}
		}
		writer.println();
		writer.close();
	}
	
	/**
	 * printToFileWithColors - prints a specified graph as a series of colored nodes and 
	 * 		their neighbors to a file in the following manner:
	 * 
	 * 		0(Y)
	 * 		X: XX(Y) XX(Y) XX(Y)
	 * 		X: XX(Y) XX(Y) ....
	 * 
	 * @param g: the graph to be printed
	 */
	protected static void printToFileWithColors(Graph g, String fileName) throws FileNotFoundException, UnsupportedEncodingException
	{
		fileName = "TestFiles\\" + fileName + ".txt";
		writer = new PrintWriter(fileName, "UTF-8");
		
		for (int i = 0; i < g.getNumNodes(); i++)
		{
			if (i == 0)
			{
				writer.println(g.getNode(i).getName() + "(" + g.getNode(i).getColor() + ")");
				writer.print(g.getNode(i).getName() + ": ");
				for (int j = 0; j < g.getNode(i).getMetNeighbors(); j++)
				{
					writer.print(g.getNode(i).neighbors[j] + "(" + g.getNode(i).getColor() + ") ");
				}
				writer.println();
			}
			else if (g.getNode(i).getMetNeighbors() > 1)
			{
				writer.print(g.getNode(i).getName() + ": ");
				
				for (int j = 1; j < g.getNode(i).getMetNeighbors(); j++)
				{
					writer.print(g.getNode(i).neighbors[j] + "(" + g.getNode(i).getColor() + ") ");
				}
				writer.println();
			}
		}
		writer.println();
		writer.close();
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
	 *
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
	}*/
}
