# Thesis
Approximating the Broadcast Chromatic Number of Graphs

A repository for everything code-related to do with my master's thesis, _Approximating the Broadcast Chromatic Number of Graphs_, to be completed c. May 2017. 

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

*14FEB16_v2*
      Tweaked NODE CLASS, COLOR ENUM, and COLORTEST CLASS. Added NODETEST CLASS for JUnit testing of NODE CLASS. Passes 11/11 tests.
      Tests for addChildren(), union(), and other adding/modifying of array methods still need to be written.

*15FEB16_v1*
      Fixed bugs with union() and addChildren() in NODE CLASS. Added 3 tests to NODETEST CLASS. Passes 14/14 tests. Added templates
      for the TREE CLASS and TREETEST CLASS for JUnit testing of TREE CLASS. Passes 0/0. 

*15FEB16v2*
      Added 2 tests to NODETEST CLASS. Passes 16/16 tests. Wrote standard helper methods for TREE CLASS as well as buildCat1(n) method
      which will construct a TYPE 1 (|v| <= 3) CATERPILLAR TREE of length n, with a spine of n/2 and n/2 branches of length 1 each.
      Flexibility written into code for eventual addition of other types of trees while hopefully maintaining code integrity. Added
      4 tests to TREETEST CLASS. Passes 4/4 tests.
      
*16FEB16_v1*
      Added toString methods to COLOR ENUM and NODE CLASS. Added 1 test each to COLORTEST CLASS and NODETEST CLASS. Pass 6/6 and 17/17
      tests respectively. Added MENU CLASS for simple console decision making. Added MENUTEST CLASS for JUnit testing. Passes 1/1 tests.
      
*16FEB16_v2*
      Reworked NODE CLASS toString. Added console printer for T1 Caterpillar graphs in MENU CLASS. Added COLORING CLASS for housing
      tree coloring algorithims. Must rework algorithim 1 for better bigOh. 

*27MAY16_v1*
      Reworked TREE CLASS. Added additional builder methods T2 CATERPILLAR and T1/T2 CATERPILLAR graphs in TREE CLASS. Created
      RANDOMGRAPHGENERATOR CLASS for building of random non-cyclic graphs.  
