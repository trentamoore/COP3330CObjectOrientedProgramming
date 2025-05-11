/*
 * CustomLengthComparator.java
 * Name: Trent Moore
 * Course: 202520 Object Oriented Programming COP-3330C-24217
 * Date: 4/6/25
 * * This class implements the Comparator interface to provide a custom comparison of strings.
 * The comparison is based on the number of characters in each string, sorting from longest
 * to shortest.
 */

import java.util.Comparator;

public class CustomLengthComparator implements Comparator<String> {

    /**
     * Compares two strings by their lengths in descending order.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return A negative integer if s2 is longer than s1, zero if equal, or a positive integer if s1 is longer.
     */
    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
}