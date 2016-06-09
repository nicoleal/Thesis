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

public class UserInputGraph
{
	private static BufferedReader bufferedReader;		// A buffered file reader						
	protected static File f;							// The input file
	private static FileReader fileReader;				// A file reader
	protected static int degree;						// The user input max degree of a node
	protected static String line;						// A full line of text read from input file
	protected static int numNodes;						// The user input N of the graph			
	
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
	 * @param numNodes: manyItems
	 * @return the input graph
	 */
	protected static Graph makeInput(String fileName) throws Exception
	{
		fileName = "TestFiles\\" + fileName + ".txt";
		fileReader = new FileReader(fileName);
		bufferedReader = new BufferedReader(fileReader);
		
		line = bufferedReader.readLine();
		degree = Integer.parseInt(line.substring(0, line.indexOf(' ')));
		numNodes = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
		Graph g = new Graph(numNodes, degree);
		
		int sponsor;
		int newNode;
		while ((line = bufferedReader.readLine()) != null)
		{
			sponsor = Integer.parseInt(line.substring(0, line.indexOf(':')));

			if (sponsor > numNodes)
			{
				Exception e = new Exception("Too many nodes in input graph.");
				System.out.println(e);
			}
			
			if (sponsor == 0)
			{
				g.graph[0] = new Node(degree, 0);
			}
			
			line = line.substring(line.indexOf(':') + 2);
			
			while (line != null)
			{
				int i = line.indexOf(',');
				
				if (i != -1)
				{
					newNode = Integer.parseInt(line.substring(0, i));

					if ((newNode > numNodes) || (newNode < sponsor))
					{
						Exception e = new Exception("Incorrect input format.");
						System.out.println(e);
					}

					g.graph[i] = Graph.newNode(g.graph[sponsor].getNode(), degree);
					g.graph[newNode].setName(newNode);
					line = line.substring(line.indexOf(',') + 2);
				}
				else
				{
					g.graph[Integer.parseInt(line)] = Graph.newNode(g.graph[sponsor].getNode(), degree);
					g.graph[Integer.parseInt(line)].setName(Integer.parseInt(line));
					line = null;
				}
			}
		}
		
		//PrintGraph.printList(t, numNodes);
		bufferedReader.close();
		fileReader.close();
		
		return g;
	}
}