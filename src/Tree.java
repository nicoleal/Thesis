/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Tree Class
 * 			An implementation of the most general Tree building class possible,
 * 			trying to maintain both code flexibility and consistency, allowing for
 * 			multiple types of trees to be built, but only one kind of tree to be
 * 			built at a time, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 15 February 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

@SuppressWarnings("serial")
public class Tree extends Node
{
	private int tallyCounter = 0;
	private Node root;
}
