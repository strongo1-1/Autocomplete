/*
 * Name: Owen Strong
 * Class: CPS 350
 * Purpose: Provides binary searches for the first and last matching array entries.
 */

public class BinarySearchDeluxe {
    /*
     * Returns the index of the first key in a[] that equals the search key, or
     * -1 if no such key.
     */
    public static <Key extends Comparable<? super Key>> int firstIndexOf(Key[] a, Key key) {
        if (a == null || key == null) {
            throw new NullPointerException("Arguments must not be null");
        }
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = a[mid].compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid; // Found a match, but continue searching to the left
                high = mid - 1;
            }
        }
        return result;
    }

    /*
     * Returns the index of the last key in a[] that equals the search key, or
     * -1 if no such key.
     */
    public static <Key extends Comparable<? super Key>> int lastIndexOf(Key[] a, Key key) {
        if (a == null || key == null) {
            throw new NullPointerException("Arguments must not be null");
        }
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = a[mid].compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid; // Found a match, but continue searching to the right
                low = mid + 1;
            }
        }
        return result;
    }
}