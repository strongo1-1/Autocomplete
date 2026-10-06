/*
 * Name: Owen Strong
 * Class: CPS 350
 * Purpose: Represents a query and weight, with comparators for autocomplete sorting.
 */

import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    /* Initializes a term with the given query string and weight. */
    public Term(String query, long weight){
        this.query = query;
        this.weight = weight;
    }

    /* Compares the two terms in descending order by weight. */
    public static Comparator<Term> byReverseWeightOrder(){
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                if (o1 == null || o2 == null) {
                    throw new NullPointerException("terms must not be null");
                }
                if (o1.weight < 0 || o2.weight < 0) {
                    throw new IllegalArgumentException("weight must be non-negative");
                }
                return Long.compare(o2.weight, o1.weight);
            }
        };
    }
    /* Compares the two terms in lexicographic order but using only the first r
    characters of each query. */
    public static Comparator<Term> byPrefixOrder(int r){
        if(r < 0){
            throw new IllegalArgumentException("r must be non-negative");
        }
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                String prefix1 = o1.query.length() < r ? o1.query : o1.query.substring(0, r);
                String prefix2 = o2.query.length() < r ? o2.query : o2.query.substring(0, r);
                return prefix1.compareTo(prefix2);
            }
        };
    }
    /* Compares the two terms in lexicographic order by query. */
    public int compareTo(Term that){
        if(that == null){
            throw new NullPointerException("that is null");
        }
        return this.query.compareTo(that.query);
    }

    public String getQuery(){
        return query;
    }

    // Returns a string representation of this term in the following format:
    // weight (i.e., ??.toString()), followed by a tab, followed by query.
    public String toString(){
        return weight + "\t" + query;
    }
}