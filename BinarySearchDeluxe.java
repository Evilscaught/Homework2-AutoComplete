import java.util.Arrays;
import java.util.Comparator;

/*Created on:       Sunday, October 8th, 2017 @7:57 p.m. MST
 *Author:           Scott McKay
 *Collaborators:    None
 */

public class BinarySearchDeluxe 
{
    //Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] array, Key key, Comparator<Key> comparator)
    {
        Arrays.sort(array); 
        
        int low = 0, high = array.length - 1;
        int firstIndex = -1;
        
        while (low <= high)
        {
            int middle = low + (high - low) / 2;
            
            //Comparator returns -n if key < array[middle]
            if (comparator.compare(key, array[middle]) < 0)
            {
                high = middle - 1;
                continue;
            }
            
            //Comparator returns +n if key > array[middle]
            else if (comparator.compare(key, array[middle]) > 0) //[5, 0] to [3, 0]
            {
                low = middle + 1;
                continue;
            }
            
            //Otherwise, comparator returns zero, therefore key == array[middle]
            else
            {
                //Do something here to find the first occurrence.
                firstIndex = middle;
                high = middle - 1;
            }
        }
        //Need to test key against low and high, so that you know what index to return.
        return firstIndex;   
    }
    
    
    //Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] array, Key key, Comparator<Key> comparator)
    {
        Arrays.sort(array);
        
        int low = 0, high = array.length - 1;
        int lastIndex = -1;
        
        while (low <= high)
        {
            int middle = low + (high - low) / 2;
            
            //Comparator returns -n if key < array[middle]
            if (comparator.compare(key, array[middle]) < 0)
            {
                high = middle - 1;
                continue;
            }
            
            //Comparator returns +n if key > array[middle]
            else if (comparator.compare(key, array[middle]) > 0) //[5, 0] to [3, 0]
            {
                low = middle + 1;
                continue;
            }
            
            //Otherwise, comparator returns zero, therefore key == array[middle]
            else
            {
                //Do something here to find the LAST occurrence.
                lastIndex = middle;
                low = middle + 1;
            }
        }
        StdOut.println("Ending While Loop");
        //Need to test key against low and high, so that you know what index to return.
        return lastIndex;  
    }
    
    //Method borrowed from: Algorithms 4E, Author(s): Robert Sedgewick, Kevin Wayne 
    @SuppressWarnings("unused")
    private static <Key> boolean isSorted(Key[] array)
    {
        for (int index = 1; index < array.length; index++)
        {
            if ((array[index-1].toString()).compareTo(array[index].toString()) > 0)
            {
                return false;
            }
        }
        return true;
    }
    
    //Unit testing
    public static void main(String[] args)
    {
        Term[] myTermArr = new Term[15];
        myTermArr[0] = new Term("Missoula", 0);
        myTermArr[1] = new Term("Billings", 0);
        myTermArr[2] = new Term("Butte", 3);
        myTermArr[3] = new Term("Miles City", 0);
        myTermArr[4] = new Term("Los Angeles", 1);
        myTermArr[5] = new Term("San Diego", 9);
        myTermArr[6] = new Term("San Jose", 200);
        myTermArr[7] = new Term("San Francisco", 4000);
        myTermArr[8] = new Term("San Antonio", 130);
        myTermArr[9] = new Term("New York City", 10000);
        myTermArr[10]= new Term("Seattle", 450);
        myTermArr[11]= new Term("Boston", 200);
        myTermArr[12]= new Term("Montreal", 1000);
        myTermArr[13]= new Term("San Achne", 21);
        myTermArr[14]= new Term("Austin", 0);
       
        
        Term userTerm = new Term("Seattle", 0);
        StdOut.println("Searching For: " + userTerm.getQuery());
        StdOut.println("Array in Sorted Order: ");
        Arrays.sort(myTermArr);
        
        for (Term term : myTermArr)
        {
            StdOut.println(term.toString());
        }
        
        StdOut.println("Found first occurence of: '" + userTerm.getQuery() + "' at index: " + firstIndexOf(myTermArr, userTerm, Term.byPrefixOrder(userTerm.getQuery().length())));
        StdOut.println("Found last occurence of: '" + userTerm.getQuery() + "' at index: " +  lastIndexOf(myTermArr, userTerm, Term.byPrefixOrder(userTerm.getQuery().length())));
        
        StdOut.println("Terminated!");
    }
}







