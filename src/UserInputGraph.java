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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

@SuppressWarnings("serial")
public class UserInputGraph extends Tree
{
	public static Exception e;
	protected static File f;
	protected static int degree;
	protected static int numNodes;
	protected static Scanner scanner;
	protected static String line;
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;
	
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
	protected static Tree makeInput(Tree t, String fileName) throws Exception
	{
		fileName = "TestFiles\\" + fileName + ".txt";
		fileReader = new FileReader(fileName);
		bufferedReader = new BufferedReader(fileReader);
		
		line = bufferedReader.readLine();
		degree = Integer.parseInt(line.substring(0, line.indexOf(' ')));
		numNodes = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
		
		int mother;
		int kid;
		while ((line = bufferedReader.readLine()) != null)
		{
			mother = Integer.parseInt(line.substring(0, line.indexOf(':')));

			if (mother > numNodes)
			{
				e = new Exception("Too many nodes in input graph.");
			}
			
			if (mother == 0)
			{
				t.makeRoot(t, numNodes, degree);
			}
			
			line = line.substring(line.indexOf(':') + 2);
			
			while (line != null)
			{
				int i = line.indexOf(',');
				
				if (i != -1)
				{
					kid = Integer.parseInt(line.substring(0, i));

					if ((kid > numNodes) || (kid < mother))
					{
						e = new Exception("Incorrect input format.");
					}

					t.tree[kid] = birth(t, t.tree[mother].getNode(), degree);
					t.tree[kid].setName(kid);
					line = line.substring(line.indexOf(',') + 2);
				}
				else
				{
					t.tree[Integer.parseInt(line)] = birth(t, t.tree[mother].getNode(), degree);
					t.tree[Integer.parseInt(line)].setName(Integer.parseInt(line));
					line = null;
				}
			}
		}
		
		//PrintGraph.printList(t, numNodes);
		bufferedReader.close();
		return t;
	}
	
	
}