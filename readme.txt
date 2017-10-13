/******************************************************************************
 *  Name: Scott McKay  
 *
 *  Hours to complete assignment (optional): 22 Hours
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
When BinarySearch lands upon the query it is searching for, it will save the
location regardless of whether it's the first one in its sequence.  'high' will
then be adjusted to 'middle - 1' Binary Search will restart the process on 
the left half of the array.  This will repeat until the query does not match
with the results of Binary Search, therefore working it's way to the first index.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor:
Constant time.

allMatches():
N + M*log(M) in worst case. 

numberOfMatches():
log(N) in worst case.



/******************************************************************************
 *  Known bugs / limitations. 
 *****************************************************************************/
None have been discovered thus far.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
Assistance from Travis Wheeler (Monday,    October 9th, 2:00 - 2:15 p.m. MST)
	-Questions regarding what do if user query exceeds length of any query in file.
Assistance from Travis Wheeler (Wednesday, October 11th, 2:40 - 3:00 p.m. MST)
	-Questions regarding the nature of byPrefixOrder() in Term.java
Assistance from Clinton R. McKay (Thursday, October 12th, 2017, 7:30 - 9:10 p.m. MST)
	-Getting a better understanding of Binary Search.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Binary Search wasn't working properly.  This was fixed by removing the subtraction
of 1 from query.length() in Term.java under the method byPrefixOrder().



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/