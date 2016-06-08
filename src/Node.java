/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Node Class
 * 			An implementation of the most general TreeNode class possible,
 * 			ensuring flexibility in the code for restrictions in vertex degree, 
 * 			number of branches/children, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Node implements Cloneable
{
	public static final int DEFAULT_COLOR = Color.WHITE.getRadius();
	public static final int DEFAULT_DEGREE = 20;
	
	private int color;					// The color of the node, WHITE if not-yet-colored
	private static int maxDegree; 		// The maximum number of connections the node can have
	private int metNeighbors;			// The "manyItems" for the neighbors array
	private int name;					// The name of the node, expressed as a numeral
	public int[] neighbors;				// The array holding references to the node's neighbors
	
	
	/******************************************************************************
	 *                                                                            *
	 *                              Constructors                                  *
	 *                                                                            *
	 ******************************************************************************/
	
	
	/**
	 * N0-ARG CONSTRUCTOR for Nodes in which no information is given. Sets color to WHITE (0),
	 * 		and maxDegree to 20, so that the node can have up to 20 neighbors / degree-20, 
	 * 		as Eclipse insisted on a default constructor.
	 */
	public Node()
	{
		color = DEFAULT_COLOR;
		maxDegree = DEFAULT_DEGREE;
		name = -1;
		neighbors = new int[maxDegree];
		metNeighbors = 0;
	}
	
	/**
	 * ONE-ARG CONSTRUCTOR for Nodes in which no information is given beyond the name
	 * 		Sets color to WHITE (0), and maxDegree to 20, so that the node can have 
	 * 		up to 20 children / degree-20.
	 * 
	 * @param name: the name assignment
	 */
	public Node(int name)
	{
		color = DEFAULT_COLOR;
		maxDegree = DEFAULT_DEGREE;
		this.name = name;
		neighbors = new int[maxDegree];
		metNeighbors = 0;
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for Nodes in which only one of it's neighbors is given. Sets 
	 * 		color to WHITE (0), and maxDegree to 20, so that the node can have up to other 
	 * 		neighbors / degree-20.
	 * 
	 * @param sponsor: the pre-existing node to which the new node is being attached
	 * @param name: the name assignment
	 */
	public Node(Node sponsor, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		maxDegree = DEFAULT_DEGREE;
		neighbors = new int[maxDegree];
		neighbors[0] = sponsor.getName();
		metNeighbors = 1;
	}
	
	/**
	 * TWO-ARG CONSTRUCTOR for Nodes in which only the maxDegree is known. Sets color to
	 * 		WHITE (0) and maxKids to INPUT, so that each node can have up to INPUT children 
	 * 		/ degree-(INPUT).
	 *  
	 * @param maxDegree: the maximum number of edges which can extend from the Node
	 * @param name: the name assignment
	 */
	public Node(int maxDegree, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		setDegree(maxDegree);
		neighbors = new int[maxDegree];
		metNeighbors = 0;
	}
	
	/**
	 * THREE-ARG CONSTRUCTOR for Nodes in which only the conecting node and maxDegree is given. 
	 * 		Sets color to WHITE (0) and maxDegree to INPUT, so that the node can have up to
	 * 		INPUT children / degree-(INPUT).
	 * 
	 * @param sponsor: the pre-existing node to which the new node is being attached
	 * @param maxDegree: the maximum number of edges which can extend from the node
	 * @param name: the name assignment
	 */
	public Node(Node sponsor, int maxDegree, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		setDegree(maxDegree);
		neighbors = new int[maxDegree];
		neighbors[0] = sponsor.getName();
		metNeighbors = 1;
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
	protected void addNeighbor(Node newNeighbor) throws Exception
	{
		if (canHaveKids())
		{
			neighbors[getKids()] = newNeighbor.getName();
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
	 * getMetNeighbors - standard getter for metNeighbors (manyItems).
	 * 
	 * @return kids
	 */
	public int getMetNeighbors()
	{
		return metNeighbors;
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
<<<<<<< HEAD
=======
	 * getParent - returns a reference to the calling node's parent.
	 * 
	 * @return returns a reference to the node's parent
	 */
	protected Node getParent()
	{
		return parent.getNode();
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
>>>>>>> origin/master
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
	 * setMetNeighbors - allows for artificial setting of setMetNeighbors (manyItems).
	 * 
	 * @param MetNeighbors: the number of neighbors a vertex actually has
	 */
	protected void setMetNeighbors(int metNeighbors)
	{
		this.metNeighbors = metNeighbors;
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
	
	/******************************************************************************
	 *                                                                            *
	 *                            Boolean  Methods                                *
	 *                                                                            *
	 ******************************************************************************/

	
	
	
	/**
	 * canAddNeighbors - determines if the maximum degree of the vertex has been reached.
	 * 
	 * @return true if neighbors is NOT full, false otherwise
	 */
	public Boolean canAddNeighbors()
	{
		return (metNeighbors != neighbors.length);
	}
		
	
	/**
	 * hasNeighbors - determines if the node has any neighbors
	 * 
	 * @return true if has children, false otherwise
	 */
	public Boolean hasNeighbors()
	{
		return (metNeighbors > 0);
	}
	
	/******************************************************************************
	 *                                                                            *
	 *                            Helper   Methods                                *
	 *                                                                            *
	 ******************************************************************************/

	/**
	 * leaf - ensures node is always a leaf, unless specifically stated otherwise,
	 * 		thereby preventing accidental propagation. Sets metNeighbors to 1 and
	 * 		neighbors array to null.
	 * 
	 * @throws CloneNotSupportedException
	 */
	protected void leaf() throws CloneNotSupportedException
	{
		this.addChildren(null);
		this.setMetNeighbors(1);
	}
	
	/**
	 * copyNeighbors - a copy method which takes the neighbors array and metNeighbors as 
	 * 		input and returns a new array of INPUT length with the deep copied data in place.
	 * 		NOTE, if length is smaller than metNeighbors, some of the neighbors array will
	 * 		not be copied, only those in neighbors[0] - neighbors[length - 1].
	 * 
	 * @param array: the original neighbors array
	 * @param metNeighbors: manyItems
	 * @return the new neighbors array
	 */
	protected int[] copyNeighbors(int[] array, int metNeighbors, int length) throws CloneNotSupportedException
	{
		int[] temp = new int[length]; 
		
		for (int i = 0; i < metNeighbors; i++)
		{
			temp[i] = neighbors[i];
		}
		
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
