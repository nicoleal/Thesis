/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		UserInputGraph Class
 * 			Some basic tests for the UserInputGraph Class. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 14 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserInputTest extends Graph
{
	Graph g;

	@Test
	public void testInput1() throws Exception
	{
		PrintGraph.printList(new UserInputGraph("InputTest1"));
	}
	
	@Test(expected = Exception.class)
	public void testInput2() throws Exception
	{
		ExpectedException thrown = ExpectedException.none();
		g = new UserInputGraph("InputTest2");
		thrown.expect(Exception.class);
		thrown.expectMessage("Incorrect input format.");
	}
	
	@Test(expected = Exception.class)
	public void testInput3() throws Exception
	{
		ExpectedException thrown = ExpectedException.none();
		g = new UserInputGraph("InputTest3");
		thrown.expect(Exception.class);
		thrown.expectMessage("Too many nodes in input graph.");
	}
	
	@Test(expected = Exception.class)
	public void testInput4() throws Exception
	{
		ExpectedException thrown = ExpectedException.none();
		g = new UserInputGraph("InputTest4");
		thrown.expect(Exception.class);
		thrown.expectMessage("Incorrect input format.");
	}

	@Test
	public void testInput5() throws Exception
	{
		PrintGraph.printToFile(new UserInputGraph("InputTest1"), "OutputTest3");
	}
	
	@Test
	public void testInput6() throws Exception
	{
		PrintGraph.printListWithColors(new UserInputGraph("InputTest1"));
	}
	
	@Test
	public void testInput7() throws Exception
	{
		PrintGraph.printToFileWithColors(new UserInputGraph("InputTest1"), "OutputTest4");
	}
}
