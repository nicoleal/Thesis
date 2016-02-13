/**
 * An Exploration of Broadcast Chromatic Numbers in Restricted Trees
 * 
 * 		Color Enum
 * 			Because it is sometimes easier to refer to a V-i by its color rather
 * 			than its number, a color class listing up to the first twenty-one
 * 			colors / {V-i | 0 <= i <= 20} an ENUM was created for greater ease 
 * 			of use, et hoc genus omne. 
 * 
 * @author Nicole Loew
 * @version CS5999 Graduate Thesis Spring 2017; 13 February 2016
 */

public enum Color 
{
	WHITE 		(0,  0xFFFFFF), 
	RED 		(1,  0xED0A3F), 
	BLUE 		(2,  0x0066FF),
	GREEN 		(3,  0x3AA655), 
	YELLOW 		(4,  0xFFEB00),
	PURPLE		(5,  0x6B3FA0), 
	ORANGE 		(6,  0xFF8833), 
	GRAY		(7,  0xC8C8CD), 
	GOLD		(8,  0xE6BE8A), 
	PINK 		(9,  0xFFA6C9),
	MAROON 		(10, 0xC32148), 
	CERULEAN	(11, 0x339ACC), 
	JADE		(12, 0xAFE313), 
	LEMON 		(13, 0xFFFF9F), 
	INDIGO		(14, 0x4F69C6), 
	TANGERINE 	(15, 0xFF9980), 
	CHARCOAL	(16, 0x736A62), 
	PEACH		(17, 0xFFCBA4), 
	SCARLET 	(18, 0xFD0E35), 
	NAVY		(19, 0x0066CC), 
	MINT 		(20, 0x93DFB8);
	
	private final int radius;
	private final int hexColor;
	
	/**
	 * Modified 2-arg constructor for Color, adding in a radius variable
	 * 		(which preforms the same function as ordinal()) and the Crayola
	 * 		(en.wikipedia.org/wiki/List_of_Crayola-crayon_colors#Standard_colors)
	 *  	hex value for each color, assuming Standard Color hex values.
	 * 
	 * 	@param radius: the ordinal/broadcast distance/i-value of the color
	 *  @param hexColor: the hexidecimal value of the color, according to wikipedia
	 */
	Color(int radius, int hexColor) 
	{
		this.radius = radius;
		this.hexColor = hexColor;
	}
	
	/**
	 * toString - overrides the ENUM toString by returning the radius/ordinal
	 * 		value as a String rather than the name().
	 * 
	 * @return the radius/ordinal value of the color as a String
	 * @overrides the default toString()
	 */
	public String toString()
	{
		return Integer.toString(radius);
	}
	
	/**
	 * getRadius - performs the same basic function as ordinal() but with
	 * 		an easier to remember name, returning the radius/ordinal value.
	 * 
	 * @param color: the ENUM
	 * @return the radius/ordinal value as an int
	 */
	public int getRadius(Color color)
	{
		return color.radius;
	}
	
	/**
	 * getHex - returns the hexadecimal value of the ENUM, according to the 
	 * 		list of Standard Crayola crayon colors, as sited in the constructor.
	 * 
	 * @param color: the ENUM
	 * @return the hex value of the color as an int
	 */
	public int getHex(Color color)
	{
		return color.hexColor;
	}
	
	/**
	 * getColor - wrapper for name() method, with an easier to remember name.
	 * 
	 * @param color: the ENUM
	 * @return the name of the color as a String
	 */
	public String getColor(Color color)
	{
		return color.name();
	}
}
