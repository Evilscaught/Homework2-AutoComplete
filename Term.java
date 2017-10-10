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
                    return -1;
                else if (term1.weight == term2.weight)
                    return 0;
                else
                    return 1;
            }      
        };
    }
    
    //TODO FIXME:
    //Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int index)
    {
        if (index < 0)
        {
            throw new java.lang.IllegalArgumentException("Index cannot be less than zero");
        }
        
        return new Comparator<Term>()
        {
            @Override
            public int compare(Term term1, Term term2) 
            {
                term1.query.toLowerCase();
                term2.query.toLowerCase();
                //Compare two strings starting at 0 to index. 
                return term1.query.substring(index).compareTo(term2.query.substring(index));
            }  
        };
    }
   
    //Compares the two terms in lexicographic order by query
    @Override
    public int compareTo(Term that) 
    {
        return query.compareTo(that.query);
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
        Term[] myTermArr = new Term[4];
               myTermArr[0] = new Term("Hello", 1000);
               myTermArr[1] = new Term("Misery", 500);
               myTermArr[2] = new Term("Zephyr", 0);
               myTermArr[3] = new Term("zzz", 50);
        
        //Print array terms
        for (Term term : myTermArr)
        {
            StdOut.println(term.query);
        }
        StdOut.println("\n\n");
        
        //Sort by reverse weight order and print array terms
        Arrays.sort(myTermArr, Term.byReverseWeightOrder());
        for (Term term : myTermArr)
        {
            StdOut.println(term.query);
        }
        StdOut.println("\n\n");
        
        //Sort by prefix and print array terms
        Arrays.sort(myTermArr, Term.byPrefixOrder(1));
        for (Term term : myTermArr)
        {
            StdOut.println(term.query);
        }
        StdOut.println("\n\n\nProgram Executed");
    }
}


















































