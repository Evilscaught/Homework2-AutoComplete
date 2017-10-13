import java.util.Arrays;

/*Created:          Sunday, October 8th, 2017 @8:01 p.m.
 *Author:           Scott McKay
 *Co-Others:        Travis Wheeler (Unit Testing) 
 *Purpose of Class: Driver class for Auto-Complete.
 *
 *Collaborators:    None
 */

public class Autocomplete 
{
    private Term[] terms;
    
    //Initializes the data structure from the given array of items.
    public Autocomplete(Term[] terms)
    {
        this.terms = terms;
        Arrays.sort(terms);
    }
    
    //Returns all terms that start with the given prefix, in descending order of weight
    public Term[] allMatches(String prefix)
    {   
        Term query = new Term(prefix, 0);
        
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, query, Term.byPrefixOrder(query.getQuery().length()));
        int lastIndex  = BinarySearchDeluxe.lastIndexOf(terms, query, Term.byPrefixOrder(query.getQuery().length()));
        
        //If there are no suggestions.
        if (firstIndex == -1)
        {
            Term[] noSuggestions = new Term[1];
            noSuggestions[0] = new Term("No Suggestions", 0);
            return noSuggestions;
        }
        else
        {
            //Add one to the end to ensure array size does not equal zero.
            int arraySize  = (lastIndex - firstIndex) + 1;     
            Term[] suggestions = new Term[arraySize];
            
            //Copy suggestions to new array, 'suggestions'
            for (int index = 0; index < arraySize; index++)
            {
                suggestions[index] = terms[firstIndex];
                firstIndex++;
            }
            Arrays.sort(suggestions, Term.byReverseWeightOrder());
            
            return suggestions;
        }
    }
    
    //Returns the number of terms taht start with the given prefix.
    public int numberOfMatches(String prefix)
    {
        return 0;
    }
    
    public static void main(String[] args) 
    {
        StdOut.println("Autocomplete: v0.3.0");
        StdOut.println("Author:       Scott McKay");
        StdOut.println("Course:       Data Structures [Section 00]");
        
        StdOut.println("Type '-q' to exit program");
        
        //Read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();    
        Term[] terms = new Term[N];
        
        
        for (int index = 0; index < N; index++) 
        {
            long weight = in.readLong();           //Read the next weight
            in.readChar();                         //Scan past the tab
            String query = in.readLine();          //Read the next query
            terms[index] = new Term(query, weight);//Construct the term
        }

        //Read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) 
        {
            String prefix = StdIn.readLine();
            if (prefix.contentEquals("-q"))
            {
                break;
            }
            
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
            {
                StdOut.println(results[i]);
            }
        }
        
        StdOut.println("Exit Success");
    }
}












