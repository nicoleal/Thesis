/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Node Class
 * 			An implementation of the most general TreeNode class possible,
 * 			ensuring flexibility in the code for restrictions in vertex degree, 
 * 			number of branches/children, et hoc genus omne. 
 * 
 * @author Nicole Loew
<<<<<<< HEAD
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
=======
 * @version CS5999 Graduate Thesis Spring 2017; 27 May 2016
>>>>>>> origin/master
 * {@link https://github.com/nicoleal/Thesis}
 */

@SuppressWarnings("serial")
public class Node extends Exception implements Cloneable
{
	public static final int DEFAULT_COLOR = Color.WHITE.getRadius();
	public static final int DEFAULT_DEGREE = 20;
	
	private int color;
	private int allKids; 
	private int depth;
	private int kids;
	private static int maxDegree; 
	private int maxKids;
	private int name;
	private Node parent;
	public Node[] children;
	
	
	/******************************************************************************
	 *                                                                            *
	 *                              Constructors                                  *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * N0-ARG CONSTRUCTOR for Nodes in which no information is given. Sets color to WHITE (0),
	 * 		parent to null, and maxDegree to 20, so that the node can have up to 20 children /
	 * 		degree-20, as Eclipse insisted on a default constructor.
	 */
	public Node()
	{
		color = DEFAULT_COLOR;
		name = -1;
		parent = null;
		depth = 0;
		kids = 0;
		maxDegree = DEFAULT_DEGREE;
		allKids = maxDegree;
		maxKids = allKids;
		children = new Node[allKids];
	}
	
	/**
	 * ONE-ARG CONSTRUCTOR for Nodes in which no information is given. Sets color to WHITE (0),
	 * 		parent to null, and maxDegree to 20, so that the node can have up to 20 children /
	 * 		degree-20.
	 * 
	 * @param name: the name assignment from TREE
	 */
	public Node(int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		parent = null;
		depth = 0;
		kids = 0;
		maxDegree = DEFAULT_DEGREE;
		allKids = maxDegree;
		maxKids = allKids;
		children = new Node[allKids];
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for Nodes in which only the parent is given. Sets color to WHITE (0),
	 * 		and maxDegree to 20, so that the node can have up to 19 children / degree-20.
	 * 
	 * @param parent: the parent Node
	 * @param name: the name assignment from TREE
	 */
	public Node(Node parent, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		maxDegree = DEFAULT_DEGREE;
		allKids = maxDegree - 1;
		maxKids = allKids;
		depth = parent.getDepth() + 1;
		kids = 0;
		this.parent = parent;
		children = new Node[allKids];
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for Nodes in which only the max degree is known. Sets color to
	 * 		WHITE (0) and maxKids to input, so that each node can have up to input children 
	 * 		/ degree-(input).
	 *  
	 * @param maxDegree: the maximum number of edges which can extend from the Node
	 * @param name: the name assignment from TREE
	 */
	public Node(int maxDegree, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		Node.maxDegree = maxDegree;
		allKids = maxDegree;
		maxKids = allKids;
		depth = 0;
		kids = 0;
		parent = null;
		children = new Node[allKids];
	}
	
	/**
	 * THREE-ARG CONSTRUCTOR for Nodes in which only the parent and maxDegree is given. Sets
	 * 		color to WHITE (0) and maxKids to (input - 1), so that the node can have up to
	 * 		(input - 1) children / degree-(input).
	 * 
	 * @param parent: the parent Node
	 * @param maxDegree: the maximum number of edges which can extend from the Node, INCLUDING
	 * 		the parent-this.Node edge
	 * @param name: the name assignment from TREE
	 */
	public Node(Node parent, int maxDegree, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		Node.maxDegree = maxDegree;
		allKids = maxDegree - 1;
		maxKids = allKids;
		depth = parent.depth + 1;
		kids = 0;
		this.parent = parent;
		children = new Node[allKids];
	}
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Standard Methods                                *
	 *                                                                            *
	 ******************************************************************************/

	
	/**
	 * addChild - adds a child to the node and updates kids IFF it has not reached its
	 * 		maximum degree.
	 * 
	 * @param child: the child to be added
	 * @throws Exception: node cannot add more children
	 */
	protected void addChild(Node child) throws Exception
	{
		if (canHaveKids())
		{
			children[getKids()] = child;
			setKids(getKids() + 1);
		}
		else
		{
			throw new Exception("This node is already at its max degree.");
		}
	}
	
	/**
	 * addChildren - replaces the children array of nodes IFF the node is empty, else
	 * 		unions original children array with new array. Assumes the new array is 
	 * 		full, with no empty cells. 
	 * 
	 * @param children: a new, full array
	 * @throws CloneNotSupportedException 
	 */
	protected void addChildren(Node[] array) throws CloneNotSupportedException
	{
		if (hasKids())
		{
			this.union(array);
		}
		else
		{
			this.children = array;
			if (array != null)
			{
				setKids(children.length);
			}
		}
	}
	
	/**
	 * getAllKids - standard getter for allKids.
	 * 
	 * @return allKids
	 */
	public int getAllKids()
	{
		return allKids;
	}
	
	/**
	 * getColor - standard getter for the color/broadcast radius.
	 * 
	 * @return the int value of the Color
	 */
	public int getColor()
	{
		return color;
	}
	
	/**
	 * getDegree - standard getter for maxDegree.
	 * 
	 * @return maxDegree
	 */
	public int getDegree()
	{
		return maxDegree;
	}
	
	/**
	 * getDepth - standard getter for depth.
	 * 
	 * @return the depth of the node from the root
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * getKids - standard getter for kids (manyItems).
	 * 
	 * @return kids
	 */
	public int getKids()
	{
		return kids;
	}
	
	/**
	 * getMaxKids - standard getter for maxKids.
	 * 
	 * @return maxKids
	 */
	public int getMaxKids()
	{
		return maxKids;
	}
	
	/**
	 * getName - standard getter for name.
	 * 
	 * @return the name of the node
	 */
	public int getName()
	{
		return name;
	}
	
	/**
	 * getNode - returns a reference of the calling node.
	 * 
	 * @return returns a reference to the node
	 */
	protected Node getNode()
 	{
 		return this;
 	}
	
	/**
	 * setAllKids - standard setter for allKids, which also copies and creates a new
	 * 		children array IFF the array is not empty. 
	 * 
	 * @param degree: the value to which allKids is to be set
	 */
	protected void setAllKids(int degree) throws CloneNotSupportedException
	{
		allKids = degree;
		
		if (kids != 0)
		{
			Node[] temp = new Node[allKids];
			temp = copyKids(children, kids, degree);
			children = temp;
		}
	}
	
	/**
	 * setColor - sets the color of Node to the input color. COLOR-GIVEN VERSION.
	 * 
	 * @param color: the desired Node color/broadcast area/radius
	 */
	protected void setColor(Color color)
	{
		this.color = color.getRadius();
	}
	
	/**
	 * setColor - sets the color of Node to the input color. RADIUS-GIVEN VERSION.
	 * 
	 * @param radius: the desired broadcast radius / color for Node
	 */
	protected void setColor(int radius)
	{
		color = radius;
	}
	
	/**
	 * setDegree - a private method only accessible by its 2-arg version, sets maxDegree
	 * 		to the proper value and lets its "mask" handle the rest. 
	 *  
	 * @param degree: the degree to which maxDegree is to be set.
	 */
	private void setDegree(int degree)
	{
		maxDegree = degree;
	}
	
	/**
	 * setDegree - "Mask" for 1-arg setDegree, allowing maxDegree to be modified without
	 * 		disturbing dependences and cascades accordingly.
	 * 
	 * @param degree: the degree to which maxDegree is to be set
	 * @param p: TRUE if node has a parent, FALSE otherwise
	 */
	protected void setDegree(int degree, boolean p) throws CloneNotSupportedException
	{
		setDegree(degree);
		setAllKids(degree - 1);
		if (degree == 1)
		{
			prune(this);
			setMaxKids(0);
		}
		else
		{
			if (p)
			{
				setMaxKids(degree - 2);
			}
			else
			{
				setMaxKids(degree - 1);
			}
		}
	}
	
	/**
	 * setDepth - standard setter for depth.
	 * 
	 * @param depth: the depth of the node
	 */
	protected void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	 * setKids - allows for artificial setting of kids (manyItems).
	 * 
	 * @param kids: the number of kids a vertex actually has
	 */
	protected void setKids(int kids)
	{
		this.kids = kids;
	}
	
	/**
	 * setMaxKids - standard setter method for maxKids.
	 * 
	 * @param degree: the degree which to set maxKids
	 */
	protected void setMaxKids(int degree)
	{
		maxKids = degree;
	}
	
	/**
	 * setName - standard setter for name.
	 * 
	 * @param name the name to be given to the node
	 */
	protected void setName(int name)
	{
		this.name = name;
	}

	/**
	 * setParent - sets the parent and adjusts depth of node if 1) node doesn't already
	 * 		have a parent and 2) isn't already at its max degree.
	 * 
	 * @param parent: the parent to be attached to the node
	 * @throws Exception: if node already has parent / has reached max degree
	 */
	protected void setParent(Node parent) throws Exception
	{
		if (hasParent())
		{
			throw new Exception("This node already has a parent.");
		}
		else if ((parent.getKids() + 1) == maxDegree)
		{
			throw new Exception("This node is already at its max degree.");
		}
		else
		{
			this.parent = parent;
			setDepth(parent.getDepth() + 1);
		}
	}
	
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/

	
	
	
	/**
	 * canHaveKids - determines if the maximum degree of the vertex has been reached.
	 * 
	 * @return true if children is not full, false otherwise
	 */
	public Boolean canHaveKids()
	{
		return (kids != children.length);
	}
		
	
	/**
	 * hasKids - determines if the node has any children
	 * 
	 * @return true if has children, false otherwise
	 */
	public Boolean hasKids()
	{
		return (kids > 0);
	}
	
	/**
	 * hasParent - determines if the node has a parent.
	 * 
	 * @return true if has parent, false otherwise
	 */
	public Boolean hasParent()
	{
		return (parent != null);
	}
	
	
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/

	/**
	 * bachelor - ensures node is always a leaf, unless specifically stated otherwise,
	 * 		thereby preventing accidental propagation. Sets allKids and kids to 0,
	 * 		maxKids to -1, and children array to null.
	 * 
	 * @throws CloneNotSupportedException
	 */
	protected void bachelor() throws CloneNotSupportedException
	{
		this.addChildren(null);
		this.setAllKids(0);
		this.setMaxKids(-1);
		this.setKids(0);
	}
	
	/**
	 * copyKids - a copy method which takes the children array and kids as input and
	 * 		returns a new array of length allKids with the deep copied data in place.
	 * 
	 * @param array: the original children array
	 * @param manyItems: kids
	 * @return the new children array
	 */
	protected Node[] copyKids(Node[] array, int manyItems, int length) throws CloneNotSupportedException
	{
		Node[] temp = new Node[length]; 
		
		for (int i = 0; i < manyItems; i++)
		{
			temp[i] = array[i].deepCopy();
		}
		
		return temp;
	}
	
	/**
	 * deepCopy - a deep copy of the Node, with own Objects.
	 * 
	 * @return the copy-made Node
	 * @throws CloneNotSupportedException
	 */
	private Node deepCopy() throws CloneNotSupportedException
	{
		Node temp = new Node(getName());
		
		temp = (Node) super.clone();
		temp.parent = parent;
		temp.children = children;
		
		return temp;
	}
	
	/**
	 * erase - takes the input node and "erases" its parent, color, and children array. 
	 * 		All else remains the same. 
	 * 
	 * @param slate: the node to be erased
	 */
	protected void erase(Node slate)
	{
		prune(slate);
		orphan(slate);
		slate.unColor();
	}
	
	/**
	 * kill - removes the indicated child node from the children array, shifts the
	 * 		other children leftward after removing. Subtracts one from kids.
	 * 
	 * @param child: the node to be "killed"
	 */
	protected void kill(Node child)
	{
		for (int i = 0; i < getKids(); i++)
		{
			if (children[i].getName() == child.getName())
			{
				for (int j = i; j < getKids(); j++)
				{
					children[j] = children[j + 1];
				}
			}
		}
		setKids(getKids() - 1);
	}
	
	/**
	 * orphan - resets the input node's parent to null. Erases node from parent,
	 * 		sets depth to 0;
	 * 
	 * @param child: the node to be orphaned.
	 */
	protected void orphan(Node child)
	{
		child.parent.kill(child);
		child.parent = null;
		child.setDepth(0);
	}
	
	/**
	 * prune - replaces a parent node's child array with an empty array of length
	 * 		allKids and sets kids to 0; id est, makes the node a leaf. Sets children's
	 * 		parent field to null;
	 * 
	 * @param parent: the node to be pruned
	 */
	protected void prune(Node parent)
	{
		setKids(0);
		parent.children = new Node[getAllKids()];
	}
	
	/**
	 * reset - completely resets the input node to a standard, parentless default node, 
	 * 		with  only its name as an identifier.
	 * 
	 * @returns a new node from Node(name) constructor
	 */
	protected Node reset()
	{
		return new Node(getName());
	}
	
	/**
	 * secede - breaks the children array in two: children[0, breakpoint) and 
	 * 		temp[breakpoint, kids). Updates kids and returns  the temp array.
	 * 		The values in the children now in temp are set to null.
	 *  
	 * @param breakpoint: the value at which to break, exclusive of the child array
	 * @return the new array from the breakpoint inclusive thru the final value in children
	 * @throws CloneNotSupportedException
	 */
	protected Node[] secede(int breakpoint) throws CloneNotSupportedException
	{
		Node[] temp = new Node[getAllKids()];
		int tempKids = getKids();
		
		for (int i = breakpoint, j = 0; i < tempKids; i++, j++)
		{
			temp[j] = children[i].deepCopy();
			children[i] = null;
			setKids(getKids() - 1);
		}
		
		return temp;
	}
	
	/**
	 * toString - returns the name and color of the node in the following format:
	 * 	
	 * 		--VXX--
	 *		|     |
	 *		|  X  |
	 *		-------
	 * 
	 * @return the String
	 */
	public String toString()
	{
		String s = "--V" + this.getName() + "--\n";
		s += "|     |\n";
		s += "|  " + this.getColor() + "  |\n";
		s += "-------\n";
		return s;
	}
	
	/**
	 * unColor - resets the node's color to the default White (0).
	 */
	protected void unColor()
	{
		setColor(DEFAULT_COLOR);
	}
	
	/**
	 * union - unions two arrays together, with the old array's contents first and
	 * 		the new array's second by deep copying the contents. If adding the 
	 * 		contents of the new array at any point causes the array to reach capacity,
	 * 		the temp array is returned without whatever remains in the new array.
	 * 
	 * @param array: the new, full array
	 * @return the unioned array
	 * @throws CloneNotSupportedException
	 */
 	private void union(Node[] array) throws CloneNotSupportedException
	{
		int kidsTemp = getKids();
			for (int i = kidsTemp; i < children.length; i++)
			{		
				this.children[i] = array[0];
				kill(array[0]);
			}
			setKids(kidsTemp + array.length);
	}
	

 	
 	
}
