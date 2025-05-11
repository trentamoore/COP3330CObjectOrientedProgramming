// Name: Trent Moore
// Date: Sunday, March 16th, 2025
// Course: 202520 Object Oriented Programming COP-3330C-24217
// Purpose: To showcase the use of generics in Java programming

import java.util.*;

public class GenericDemoApp {
    public static void main(String[] args) {
        // Define arrays of different types
        Integer[] numbers = {10, 20, 30, 40};
        String[] names = {"Dexter", "Debra", "Doakes"};
        Double[] ratings = {9.1, 8.6, 9.3};

        // Demonstrate generic utility method for finding index
        System.out.println("Index of 30: " + GenericUtility.findIndex(numbers, 30));
        System.out.println("Index of 'Debra': " + GenericUtility.findIndex(names, "Debra"));
        System.out.println("Index of 9.3: " + GenericUtility.findIndex(ratings, 9.3));

        // Create a generic container for Character objects
        GenericContainer<Character> characterContainer = new GenericContainer<>();
        characterContainer.add(new Character("Dexter Morgan", 35, "Forensic Blood Spatter Analyst"));
        characterContainer.add(new Character("Debra Morgan", 32, "Detective"));

        // Print all characters stored in the container
        characterContainer.printAll();

        // Create a generic container for Episode objects
        GenericContainer<Episode> episodeContainer = new GenericContainer<>();
        episodeContainer.add(new Episode("Born Free", 1, 9.4));
        episodeContainer.add(new Episode("The Getaway", 4, 9.8));

        // Sort episodes based on rating in descending order
        episodeContainer.sort(Comparator.comparing(Episode::getRating).reversed());

        // Print all sorted episodes
        episodeContainer.printAll();
    }
}
