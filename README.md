# Thesis
An exploration of Broadcast Chromatic Numbers in restricted classes of trees.

A repository for everything code-related to do with my master's thesis, _An Exploration of Broadcast Chromatic Numbers in Restricted_
_Classes of Trees_, to be completed c. May 2017. 

*13FEB16_v1*
      Added the COLOR ENUM, to provide color names/radius values/hexadecimal color values for broadcast nodes. This is mostly done for
      ease of use and to ensure consistancy later on, if/when a graphical representation is needed. The standard helper methods (getters,
      no setters, constructor, toString) were added as well. 
      
*13FEB16_v3*
      Made minor readability changes to COLOR ENUM. Added the NODE CLASS, to provide the building blocks for the eventual Tree Class.
      Tried to maintain future flexibility while considering code integrity. Provided four different constructors, the standard helper
      methods (minus toString(), which will be added when I decide upon what it should print and how), along with union, secede, deep
      clone, and deep copy methods.

*14FEB16_v1*
      Made additions to NODE CLASS, adding the "name" variable (to be passed into the constructor(s) from the eventual Tree Class)).
      Added the COLORTEST CLASS for JUnit testing of COLOR ENUM. Passes 4/4 tests. Added the NODETEST CLASS for JUnit testing of COLOR
      CLASS. Passes 0/0 tests.
