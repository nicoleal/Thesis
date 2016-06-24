/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		TreeNode Class
 * 			An implementation of the most general TreeNode class possible,
 * 			ensuring flexibility in the code for restrictions in vertex degree, 
 * 			number of branches/children, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 9 June 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class TreeNode extends Node
{
	public static final int DEFAULT_DEPTH = 0;
	
	private int[] children;					// The node's child nodes
	private int depth;						// The depth of the node (starting at 0)
	private int myChildren;					// manyItems for children;
	private int parent;						// The node's parent node
	Exception e;							// An instance of Exception
	
	/******************************************************************************
	 *                                                                            *
	 *                              Constructors                                  *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * N0-ARG CONSTRUCTOR for Nodes in which no information is given. Sets color to WHITE (0),
	 * 		and maxDegree to 20, so that the node can have up to 20 neighbors / degree-20, 
	 * 		as Eclipse insisted on a default constructor. TreeNodes also have a depth of 0,
	 * 		a parent of -1, and a children array the same length as their neighbors array.
	 */
	public TreeNode()
	{
		super();
		children = new int[getDegree()];
		depth = DEFAULT_DEPTH;
		parent = -1;
	}

	/**
	 * ONE-ARG CONSTRUCTOR for Nodes in which no information is given beyond the name
	 * 		Sets color to WHITE (0), and maxDegree to 20, so that the node can have 
	 * 		up to 20 neighbors / degree-20. TreeNodes also have a depth of 0, a parent
	 * 		of -1, and a children array the same length as their neighbors array.
	 * 
	 * @param name: the name assignment
	 */
	public TreeNode(int name)
	{
		super(name);
		children = new int[getDegree()];
		depth = DEFAULT_DEPTH;
		myChildren = 0;
		parent = -1;
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for Nodes in which only the maxDegree is known. Sets color to
	 * 		WHITE (0) and maxKids to INPUT, so that each node can have up to INPUT neighbors 
	 * 		/ degree-(INPUT). TreeNodes also have a depth of 0, a parent of -1, and a
	 * 		children array the same length as their neighbors array.
	 *  
	 * @param maxDegree: the maximum number of edges which can extend from the Node
	 * @param name: the name assignment
	 */
	public TreeNode(int maxDegree, int name)
	{
		super(maxDegree, name);
		children = new int[getDegree()];
		depth = DEFAULT_DEPTH;
		myChildren = 0;
		parent = -1;
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for Nodes in which only one of it's neighbors is given. Sets 
	 * 		color to WHITE (0), and maxDegree to 20, so that the node can have up to other 
	 * 		neighbors / degree-20.  TreeNodes also have a depth of (sponsor's depth + 1),
	 * 		a parent of sponor.getName(), and a children array the length (neighbors - 1).
	 * 
	 * @param sponsor: the pre-existing node to which the new node is being attached
	 * @param name: the name assignment
	 */
	public TreeNode(TreeNode sponsor, int name)
	{
		super(sponsor, name);
		children = new int[getDegree() - 1];
		depth = sponsor.getDepth() + 1;
		myChildren = 0;
		parent = sponsor.getName();
	}
	
	/**
	 * THREE-ARG CONSTRUCTOR for Nodes in which only the connecting node's name and maxDegree
	 * 		is given. Sets color to WHITE (0) and maxDegree to INPUT, so that the node can 
	 * 		have up to INPUT neighbors / degree-(INPUT). TreeNodes also have a depth of 
	 * 		0, a parent of sponsor and a children array the length (neighbors - 1).
	 * 
	 * @param sponsor: the name of the node to which the new node is being attached
	 * @param maxDegree: the maximum number of edges which can extend from the node
	 * @param name: the name assignment
	 */
	public TreeNode(int sponsor, int maxDegree, int name)
	{
		super(sponsor, maxDegree, name);
		children = new int[getDegree() - 1];
		depth = DEFAULT_DEPTH;
		myChildren = 0;
		parent = sponsor;
	}
	
	/**
	 * THREE-ARG CONSTRUCTOR for Nodes in which only the connecting node and maxDegree is given. 
	 * 		Sets color to WHITE (0) and maxDegree to INPUT, so that the node can have up to
	 * 		INPUT neighbors / degree-(INPUT). TreeNodes also have a depth of (sponsor's depth + 1),
	 * 		a parent of sponor.getName(), and a children array the length (neighbors - 1).
	 * 
	 * @param sponsor: the pre-existing node to which the new node is being attached
	 * @param maxDegree: the maximum number of edges which can extend from the node
	 * @param name: the name assignment
	 */
	public TreeNode(TreeNode sponsor, int maxDegree, int name)
	{
		super(sponsor, maxDegree, name);
		children = new int[getDegree() - 1];
		depth = sponsor.getDepth() + 1;
		myChildren = 0;
		parent = sponsor.getName();
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/

	/**
	 * addNeighbor - adds a new neighbor to the node and updates metNeighbors IFF 
	 * 		the original node has not reached its maximum degree. TreeNode version
	 * 		also updates children array, assuming that the new neighbor is not 
	 * 		the TreeNode's parent.
	 * 
	 * @param newNeighbor: the node to be added
	 * @throws Exception: node cannot add more nodes
	 */
	protected void addNeighbor(TreeNode newNeighbor)
	{
		if (canAddNeighbors())
		{
			neighbors[getMetNeighbors()] = newNeighbor.getName();
			setMetNeighbors(getMetNeighbors() + 1);
			children[getMyChildren()] = newNeighbor.getName();
			setMyChildren(getMyChildren() + 1);
		}
		else
		{
			e = new Exception("This node is already at its max degree.");
		}
	}
	
	/**
	 * addNeighbors - replaces the neighbors array of nodes IFF the node is empty, else
	 * 		unions original neighbors array with new array. Assumes the new array is 
	 * 		full, with no empty cells. 
	 * 
	 * @param newNeighbors: a new, full array
	 * @throws CloneNotSupportedException 
	 */
	protected void addNeighbors(int[] newNeighbors)
	{
		if (hasNeighbors())
		{
			this.union(newNeighbors);
		}
		else
		{
			setNeighbors(newNeighbors);
			if (newNeighbors != null)
			{
				setMetNeighbors(neighbors.length);
			}
		}
	}
	
	/**
	 * getDepth - standard getter for depth.
	 * 
	 * @return the depth of the node
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * getMyChildren - standard getter for myChildren.
	 * 
	 * @return the myChildren of the node
	 */
	public int getMyChildren()
	{
		return myChildren;
	}
	
	/**
	 * getNode - returns a reference of the calling node. TREENODE VERSION
	 * 
	 * @return returns a reference to the node
	 */
	protected TreeNode getNode()
 	{
 		return this;
 	}
	
	/**
	 * getParent - standard getter for parent.
	 * 
	 * @return the parent of the node
	 */
	public int getParent()
	{
		return parent;
	}
	
	/**
	 * setDepth - sets the depth of TreeNode to the input.
	 * 
	 * @param depth: the desired depth of the node
	 */
	protected void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	 * setNeighbor - adds a new node to the neighbors array. TreeNode
	 * 		version assumes that node is not parent. INT-NAME VERSION
	 * 
	 * @param node: the name of new neighbor
	 */
	protected void setNeighbor(int node)
	{
		if (canAddNeighbors())
		{
			neighbors[getMetNeighbors()] = node;
			setMetNeighbors(getMetNeighbors() + 1);
			children[getMyChildren()] = node;
			setMyChildren(getMyChildren() + 1);
		}
		else
		{
			e = new Exception("This node is already at its max degree.");
			System.out.println(e);
		}
	}
	
	/**
	 * setNeighbor - adds a new node to the neighbors array. TreeNode
	 * 		version assumes that node is not parent. NODE VERSION
	 * 
	 * @param node: the new neighbor
	 */
	protected void setNeighbor(TreeNode node)
	{
		if (canAddNeighbors())
		{
			neighbors[getMetNeighbors()] = node.getName();
			setMetNeighbors(getMetNeighbors() + 1);
			children[getMyChildren()] = node.getName();
			setMyChildren(getMyChildren() + 1);
		}
		else
		{
			e = new Exception("This node is already at its max degree.");
			System.out.println(e);
		}
	}
	
	/**
	 * setNeighbors - standard setter for neighbors. TreeNode version
	 * 		sets the children array as well, minus the parent.
	 * 
	 * @param array: the new neighbors array
	 */
	protected void setNeighbors(int[] array)
	{
		neighbors = array;
		
		for (int i = 0; i < getMetNeighbors(); i++)
		{
			if (neighbors[i] != parent)
			{
				for (int j = getMyChildren(); j < children.length; j++)
				{
					children[j] = array[i];
					setMyChildren(j + 1);
				}
			}
		}
	}
	
	/**
	 * setMyChildren - sets the myChildren of the TreeNode to the input.
	 * 
	 * @param myChildren: the desired myChildren of the Node
	 */
	protected void setMyChildren(int myChildren)
	{
		this.myChildren = myChildren;
	}
	
	/**
	 * setParent - sets the parent of TreeNode to the input. INT-NAME VERSION
	 * 
	 * @param parent: the desired parent of the node
	 */
	protected void setParent(int parent)
	{
		this.parent = parent;
	}
	
	/**
	 * setParent - sets the parent of TreeNode to the input. NODE VERSION
	 * 
	 * @param parent: the desired parent of the node
	 */
	protected void setParent(TreeNode parent)
	{
		this.parent = parent.getName();
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * canAddChildren - determines if the maximum children of the vertex has been reached.
	 * 
	 * @return true if children is NOT full, false otherwise
	 */ 
	public boolean canAddChildren()
	{
		return (myChildren != children.length);
	}
	
	/**
	 * hasChildren - determines if the node has any children
	 * 
	 * @return true if has children, false otherwise
	 */
	public boolean hasChildren()
	{
		return (myChildren > 0);
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/
	
	/**
	 * union - unions two arrays together, with the old array's contents first and
	 * 		the new array's second by deep copying the contents. If adding the 
	 * 		contents of the new array at any point causes the array to reach capacity,
	 * 		the union is finished and the remainder of nodes in array are not added.
	 * 		The TreeNode version does the same for the children array as well.
	 * 
	 * @param array: the array to be added to the current neighbors/children arrays
	 */
 	protected void union(int[] array)
	{
 		for (int i = getMetNeighbors(), j = 0; i < neighbors.length; i++, j++)
		{		
			neighbors[i] = array[j];
			setMetNeighbors(i + 1);
			
			if (neighbors[i] != parent)
			{
				for (int k = getMyChildren(); k < children.length; k++)
				{
					children[k] = array[j];
					setMyChildren(k + 1);
				}
			}
		}
	} 		
}