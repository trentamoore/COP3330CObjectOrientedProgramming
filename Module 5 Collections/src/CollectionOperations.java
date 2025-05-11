/*
 * CollectionOperations.java
 * Name: Trent Moore
 * Course: 202520 Object Oriented Programming COP-3330C-24217
 * Date: 4/6/25
 * This class provides utility methods for displaying and processing the collection of words.
 * It includes methods to print the list details and to print the list with a header.
 */

import java.util.ArrayList;

public class CollectionOperations {

    /**
     * Prints the list of words along with the total number of entries,
     * the longest word, and the shortest word.
     *
     * @param list The ArrayList of strings containing the words.
     */
    public static void printListDetails(ArrayList<String> list) {
        System.out.println("Words in the list:");
        for (String word : list) {
            System.out.println(word);
        }
        System.out.println("Total number of entries: " + list.size());

        // Initialize longest and shortest with the first element
        String longest = list.get(0);
        String shortest = list.get(0);

        // Find longest and shortest entries
        for (String word : list) {
            if (word.length() > longest.length()) {
                longest = word;
            }
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }
        System.out.println("Longest entry: " + longest);
        System.out.println("Shortest entry: " + shortest);
    }

    /**
     * Prints the list of words preceded by a header.
     *
     * @param list The ArrayList of strings to be printed.
     */
    public static void printListWithHeader(ArrayList<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }
}