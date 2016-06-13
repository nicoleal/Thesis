/**
 * Approximating the Broadcast Chromatic Number of Graphs
 * 
 * 		Node Class
 * 			An implementation of the most general Node class possible,
 * 			ensuring flexibility in the code for restrictions in vertex degree, 
 * 			number of branches/children, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 30 May 2016
 * {@link https://github.com/nicoleal/Thesis}
 */

public class Node
{
	public static final int DEFAULT_COLOR = Color.WHITE.getRadius();
	public static final int DEFAULT_DEGREE = 20;
	
	private int color;					// The color of the node, WHITE (0) if not-yet-colored
	private int maxDegree; 		// The maximum number of connections the node can have
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
	 * 		up to 20 neighbors / degree-20.
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
	 * TWO-ARG CONSTRUCTOR for Nodes in which only the maxDegree is known. Sets color to
	 * 		WHITE (0) and maxKids to INPUT, so that each node can have up to INPUT neighbors 
	 * 		/ degree-(INPUT).
	 *  
	 * @param maxDegree: the maximum number of edges which can extend from the Node
	 * @param name: the name assignment
	 */
	public Node(int maxDegree, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		this.maxDegree = maxDegree;
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
	 * THREE-ARG CONSTRUCTOR for Nodes in which only the connecting node's name and maxDegree
	 * 		is given. Sets color to WHITE (0) and maxDegree to INPUT, so that the node can 
	 * 		have up to INPUT neighbors / degree-(INPUT).
	 * 
	 * @param sponsor: the name of the node to which the new node is being attached
	 * @param maxDegree: the maximum number of edges which can extend from the node
	 * @param name: the name assignment
	 */
	public Node(int sponsor, int maxDegree, int name)
	{
		color = DEFAULT_COLOR;
		this.name = name;
		this.maxDegree = maxDegree;
		neighbors = new int[maxDegree];
		neighbors[0] = sponsor;
		metNeighbors = 1;
	}
	
	/**
	 * THREE-ARG CONSTRUCTOR for Nodes in which only the connecting node and maxDegree is given. 
	 * 		Sets color to WHITE (0) and maxDegree to INPUT, so that the node can have up to
	 * 		INPUT neighbors / degree-(INPUT).
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
	 * addNeighbor - adds a new neighbor to the node and updates metNeighbors IFF 
	 * 		the original node has not reached its maximum degree.
	 * 
	 * @param newNeighbor: the node to be added
	 * @throws Exception: node cannot add more nodes
	 */
	protected void addNeighbor(Node newNeighbor) throws Exception
	{
		if (canAddNeighbors())
		{
			neighbors[getMetNeighbors()] = newNeighbor.getName();
			setMetNeighbors(getMetNeighbors() + 1);
		}
		else
		{
			Exception e = new Exception("This node is already at its max degree.");
			System.out.println(e);
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
			union(newNeighbors);
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
	 * getNeighbor - standard getter for neighbors[i]
	 * 
	 * @param i: the position of the neighbor
	 */
	public int getNeighbor(int i)
	{
		return neighbors[i];
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
	protected void setDegree(int degree)
	{
		maxDegree = degree;
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
	 * setNeighbor - adds a new node to the neighbors array. INT-NAME VERSION
	 * 
	 * @param node: the name of the new neighbor
	 */
	protected void setNeighbor(int node)
	{
		if (canAddNeighbors())
		{
			neighbors[getMetNeighbors()] = node;
			setMetNeighbors(getMetNeighbors() + 1);
		}
		else
		{
			Exception e = new Exception("This node is already at its max degree.");
			System.out.println(e);
		}
	}
	
	/**
	 * setNeighbor - adds a new node to the neighbors array. NODE VERSION
	 * 
	 * @param node: the newNeighbor
	 */
	protected void setNeighbor(Node node)
	{
		if (canAddNeighbors())
		{
			neighbors[getMetNeighbors()] = node.getName();
			setMetNeighbors(getMetNeighbors() + 1);
		}
		else
		{
			Exception e = new Exception("This node is already at its max degree.");
			System.out.println(e);
		}
	}
		
	/**
	 * setNeighbors - standard setter for neighbors
	 * 
	 * @param array: the new neighbors array
	 */
	protected void setNeighbors(int[] array)
	{
		neighbors = array;
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
	 * @return true if has neighbors, false otherwise
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
	 * copyNeighbors - a copy method which takes the neighbors array and metNeighbors as 
	 * 		input and returns a new array of INPUT length with the deep copied data in place.
	 * 		NOTE BENE, if length is smaller than metNeighbors, some of the neighbors array
	 * 		will not be copied, only those in neighbors[0] - neighbors[length - 1].
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
			temp[i] = array[i];
		}
		
		return temp;
	}
	
	/**
	 * erase - takes the input node and "erases" its color and neighbors array. 
	 * 		All else remains the same. 
	 * 
	 * @param slate: the node to be erased / get a "clean slate"
	 */
	protected void erase(Node slate)
	{
		emptyNeighborhood(slate);
		slate.unColor();
	}
	
	/**
	 * kill - removes the indicated node node from the neighbors array, shifts the
	 * 		other neighbors leftward after removing. Subtracts one from metNeighbors.
	 * 
	 * @param oldNeighbor: the node to be "killed"
	 */
	protected void kill(Node oldNeighbor)
	{
		for (int i = 0; i < getMetNeighbors(); i++)
		{
			if (neighbors[i] == oldNeighbor.getName())
			{
				for (int j = i; j < getMetNeighbors(); j++)
				{
					neighbors[j] = neighbors[j + 1];
				}
			}
		}
		setMetNeighbors(getMetNeighbors() - 1);
	}
	
	/**
	 * emptyNeighborhood - replaces a node's neighbors array with an empty array of length
	 * 		allKids and sets kids to 0; id est, makes the node a leaf. Sets children's
	 * 		parent field to null;
	 * 
	 * @param node: the node to be pruned / lose its neighborhood
	 */
	protected void emptyNeighborhood(Node node)
	{
		setMetNeighbors(0);
		setNeighbors(new int[getDegree()]);
	}
	
	/**
	 * leaf - ensures node is always a leaf, unless specifically stated otherwise,
	 * 		thereby preventing accidental propagation. Sets metNeighbors to 1 and
	 * 		neighbors array to the "parent" only.
	 * 
	 * @throws CloneNotSupportedException
	 */
	protected void leaf() throws CloneNotSupportedException
	{
		newNeighborhood(1);
		setDegree(1);
		setMetNeighbors(1);
	}

	
	/**
	 * newNeighborhood - breaks the neighbors array in two: neighbors[0, breakpoint) and 
	 * 		temp[breakpoint, metNeighbors). Updates metNeighbors and returns the temp array.
	 * 		Sets the value of the ints after the breakpoint in the original array to -1.
	 *  
	 * @param breakpoint: the value at which to break, exclusive, in the neighbors array
	 * @return the new array from the breakpoint inclusive thru the final value in neighbors
	 * @throws CloneNotSupportedException
	 */
	protected int[] newNeighborhood(int breakpoint) throws CloneNotSupportedException
	{
		int[] temp = new int[getDegree()];
		int tempKids = getMetNeighbors();
		
		for (int i = breakpoint, j = 0; i < tempKids; i++, j++)
		{
			temp[j] = neighbors[i];
			neighbors[i] = -1;
			setMetNeighbors(getMetNeighbors() - 1);
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
		String s;
		
		if (name < getName())
		{
			s = "--V" + getName() + "---\n";
		}
		else
		{
			s = "--V" + getName() + "--\n";
		}
		s += "|     |\n|  " + getColor() + "  |\n-------\n";
		
		return s;
	}
	
	/**
	 * reset - completely resets the input node to a standard default node, 
	 * 		with  only its name as an identifier.
	 * 
	 * @returns a new node from Node(name) constructor
	 */
	protected Node reset()
	{
		return new Node(getName());
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
	 * 		the union is finished and the remainder of nodes in array are not added.
	 * 
	 * @param array: the array to be added to the current neighbors array
	 */
 	protected void union(int[] array)
	{
 		if (getMetNeighbors() < neighbors.length)
 		{
 			for (int i = getMetNeighbors(), j = 0; i < neighbors.length; i++, j++)
 			{
 				if (j < array.length)
 				{
 					neighbors[i] = array[j];
 					setMetNeighbors(i + 1);
 				}
 			}
 		}
	}	
 	
}
