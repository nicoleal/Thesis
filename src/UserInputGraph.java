/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		UserInputGraph Class
 * 			A subclass for taking graphs as input into the program that
 * 			fall under the strictures described  in the TREE CLASS, 
 * 			et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import java.io.File;
import java.util.Scanner;

@SuppressWarnings("serial")
public class UserInputGraph extends Tree
{
	public static Exception e;
	protected static File f;
	protected static int degree;
	protected static int numNodes;
	protected static Scanner scanner;
	
	/**
	 * makeInput - reads from an input file a series of parents and
	 * 		and their children written in the following manner:
	 * 
	 * 		degree	numNodes
	 * 		X: XX XX XX
	 * 		X: XX XX ....
	 * 
	 * 		and builds the tree
	 * 
	 * @param t - the tree
	 * @param numNodes - manyItems
	 */
	protected static Tree makeInput(Tree t) throws Exception
	{
		//f = new File("InputTest1.txt");
		scanner = new Scanner("TestFiles\\InputTest1.txt");	
		degree = scanner.nextInt();
		numNodes = scanner.nextInt();
		
		setTreeDegree(t, degree);
			
		while (scanner.hasNextLine())
		{
			int mother = scanner.nextInt();
			
			if (mother > numNodes)
			{
				e = new Exception("Too many nodes in input graph.");
			}
			
			if (mother == 0)
			{
				t.makeRoot(t, numNodes, degree);
			}
			
			int kid;
			while (scanner.next() != "\n")
			{
				kid = scanner.nextInt();
				
				if (kid > numNodes)
				{
					e = new Exception("Too many nodes in input graph.");
				}
				else if (kid < mother)
				{
					e = new Exception("Incorrect input format.");
				}
				
				t.tree[kid] = birth(t, t.tree[mother].getNode(), degree);
			}
		}
		PrintGraph.printList(t, numNodes);
		scanner.close();
		return t;
	}
	
	
}