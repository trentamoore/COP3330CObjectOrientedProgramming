/*
 * Name: Trent Moore
 * Course: 202520 Object Oriented Programming COP-3330C-24217
 * Date: 4/6/25
 * Program Objective:
 * This program demonstrates the use of the Java Collections Framework. This program prompts the user to
 * provide 8 unique words. It then  displays various details about the list, sorts the list using natural order and a custom
 * comparator (by length from longest to shortest). It then  shuffles the list performs search and additional
 * operations using other Collections static methods, and end by converting the list to an array.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class CollectionsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();

        //  Create a List and populate it with eight unique words (ignoring case duplicates)
        System.out.println("Enter eight unique words:");
        while (wordList.size() < 8) {
            System.out.print("Word " + (wordList.size() + 1) + ": ");
            String input = scanner.next();
            boolean duplicate = false;
            // Check for duplicates ignoring case
            for (String word : wordList) {
                if (word.equalsIgnoreCase(input)) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                System.out.println("Duplicate entry (ignoring case) detected. Please enter a different word.");
            } else {
                wordList.add(input);
            }
        }
        System.out.println();

        //  Print the list details using an enhanced for loop
        System.out.println("Original List and Details:");
        CollectionOperations.printListDetails(wordList);
        System.out.println();

        //  Sort the list using Collections.sort (natural order)
        Collections.sort(wordList);
        System.out.println("List Sorted in Natural Order:");
        CollectionOperations.printListWithHeader(wordList);
        System.out.println();

        //  Custom Sort: sort by length from longest to shortest using CustomLengthComparator
        Collections.sort(wordList, new CustomLengthComparator());
        System.out.println("List Custom Sorted by Length (Longest to Shortest):");
        CollectionOperations.printListWithHeader(wordList);
        System.out.println();

        //  Shuffle the list using Collections.shuffle
        Collections.shuffle(wordList);
        System.out.println("List After Shuffling:");
        CollectionOperations.printListWithHeader(wordList);
        System.out.println();

        // Search the list: ask the user for a word to search (ignoring case)
        System.out.print("Enter a word to search for in the list: ");
        String searchWord = scanner.next();
        boolean found = false;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equalsIgnoreCase(searchWord)) {
                System.out.println("The word \"" + searchWord + "\" was found at index " + i + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The word \"" + searchWord + "\" was not found in the list.");
        }
        System.out.println();

        //  Additional Collections methods
        //  Reverse the list using Collections.reverse
        Collections.reverse(wordList);
        System.out.println("List After Reversing (Using Collections.reverse):");
        CollectionOperations.printListWithHeader(wordList);
        System.out.println();

        //  Copy the list using Collections.copy.
        ArrayList<String> copyList = new ArrayList<>(Collections.nCopies(wordList.size(), ""));
        Collections.copy(copyList, wordList);
        System.out.println("Copied List (Using Collections.copy):");
        CollectionOperations.printListWithHeader(copyList);
        System.out.println();

        //  Convert the list to an array and output the array elements
        String[] wordArray = wordList.toArray(new String[0]);
        System.out.println("Array Created from List:");
        for (String word : wordArray) {
            System.out.println(word);
        }
        System.out.println();

        //  Convert the array back into a list and output the list elements
        ArrayList<String> newList = new ArrayList<>(Arrays.asList(wordArray));
        System.out.println("List Created from Array:");
        CollectionOperations.printListWithHeader(newList);
        System.out.println();

        scanner.close();
    }
}

/*
 *In java, a Collection is an interface in the Collections Framework.
 * That represents a group of objects, also known as elements.
 * It allows for basic operations like adding, removing, and checking,
 * the size of a collection. In comparison Collections is a utility class
 * that is filled with static methods that work with collections to sort, shuffle, reverse,
 * or copy. It is easier to think of this interface as a set of methods.
 */