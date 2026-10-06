/*
 * Name: Owen Strong
 * Class: CPS 350
 * Purpose: Finds autocomplete matches for a query prefix and orders terms by weight.
 */

public class Autocomplete {
    private Term[] terms;

    // implement sorting algorithm in this class
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        this.terms = terms.clone();
        for (int i = 1; i < this.terms.length; i++) {
            Term current = this.terms[i];
            int j = i - 1;
            while (j >= 0 && Term.byReverseWeightOrder().compare(this.terms[j], current) > 0) {
                this.terms[j + 1] = this.terms[j];
                j--;
            }
            this.terms[j + 1] = current;
        }
    }

    /*
     * Returns all terms that start with the given prefix, in descending order
     * of weight.
     */
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            return new Term[0];
        }

        int count = 0;
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].getQuery().startsWith(prefix)) {
                count++;
            }
        }

        Term[] matches = new Term[count];
        int index = 0;
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].getQuery().startsWith(prefix)) {
                matches[index++] = terms[i];
            }
        }
        return matches;
    }
}