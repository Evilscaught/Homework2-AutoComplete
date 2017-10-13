/*Created: Sunday, October 8th, 2017 @7:50 p.m.
 *Purpose: 'Term' will be used to store a string and weight.  Compare methods will be implemented.
 *Class:   Data Structures Section 00
 *Author:  Scott McKay
 *
 *Collaborators: None
 */

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term>
{
    private String query;
    private long weight;
    // Initializes a term with the given query string and weight
    public Term(String query, long weight)
    {
        if (weight < 0)
        {
            throw new java.lang.IllegalArgumentException("Weight cannot be less than zero");
        }
        if (query == null)
        {
            throw new java.lang.NullPointerException("Query cannot be null");
        }
        
        this.query = query;
        this.weight = weight;
    }
    
    //Compares the two terms in descending order by weight
    public static Comparator<Term> byReverseWeightOrder()
    {   
        return new Comparator<Term>()
        {
            @Override
            public int compare(Term term1, Term term2) 
            {
                if      (term1.weight < term2.weight)
                    return 1;
                else if (term1.weight == term2.weight)
                    return 0;
                else
                    return -1;
            }      
        };
    }
    
    //Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r)
    {
        if (r < 0)
        {
            throw new java.lang.IllegalArgumentException("Index cannot be less than zero");
        }
        return new Comparator<Term>()
        {
            
            @Override
            public int compare(Term term1, Term term2) 
            {
                int index = r;
                if (index >= term1.query.length())
                {
                    index = term1.query.length();
                }
                if (index >= term2.query.length())
                {
                    index = term2.query.length();
                }
                
                //Debugging
                //StdOut.println("Comparing Term 1: " + term1.query.substring(0, index) + " with Term 2: " + term2.query.substring(0, index));
                
                //Compare two strings starting at 0 to index. 
                return term1.query.toLowerCase().substring(0, index).compareTo(term2.query.toLowerCase().substring(0, index));
            }  
        };
    }
   
    //Compares the two terms in lexicographic order by query
    @Override
    public int compareTo(Term that) 
    {
        return query.toLowerCase().compareTo(that.query.toLowerCase());
    }
    
    public long getWeight()
    {
        return weight;
    }
    
    public String getQuery()
    {
        return query;
    }
    
    //Returns a string representation of this term in the following format:
    //the weight, followed by a tab, followed by the query.
    public String toString()
    {
        return weight + "\t" + query;
    }
    
    //Unit testing *(You should have some unit testing here to confirm that your methods work)
    public static void main(String[] args)
    {
        Term[] myTermArr = new Term[3];
               myTermArr[0] = new Term("CCCCC", 50);
               myTermArr[1] = new Term("ABZZZ", 100);
               myTermArr[2] = new Term("ABDDD", 0);
               
        //Print array terms
        StdOut.println("String queries in Term[] array: ");
        for (Term term : myTermArr)
        {
            StdOut.println(term.toString());
        }
        StdOut.println("\n\n");
        
        //Sort by prefix and print array terms
        StdOut.println("Sorted by prefix order: (r = 2)");
        Arrays.sort(myTermArr, Term.byPrefixOrder(2));
        for (Term term : myTermArr)
        {
            StdOut.println(term.toString());
        }
        StdOut.println("\n\n\nProgram Executed");
        
        //Sort by reverse weight order and print array terms
        StdOut.println("Sorted by reverse weight order.");
        Arrays.sort(myTermArr, Term.byReverseWeightOrder());
        for (Term term : myTermArr)
        {
            StdOut.println(term.toString());
        }
        StdOut.println("\n\n");
        
        //Sort by prefix and print array terms
        StdOut.println("Sorted by prefix order: (r = min.length)");
        Arrays.sort(myTermArr, Term.byPrefixOrder(100));
        for (Term term : myTermArr)
        {
            StdOut.println(term.toString());
        }  
    }
}


















































