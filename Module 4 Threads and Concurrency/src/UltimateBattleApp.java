/**
 * UltimateBattleApp.java
 * Author: Trent Moore
 * Course: Object Oriented Programming COP-3330C-24217
 * Date: 04/06/2025
 * Program Objective:
 * This is the main application that initiates the race between two contenders: Ford and Ferrari.
 * It creates two Contender objects with different lap completion rates and pit stop times,
 * passes them a shared PitStop instance, starts their threads, and determines the winner.
 */

public class UltimateBattleApp {
    public static void main(String[] args) {
        // Create a shared PitStop instance for both racers
        PitStop pitStop = new PitStop();

        // Create two racers with different attributes.
        // "Ford" completes 2 laps per iteration and has a longer maximum pit stop time,
        // while "Ferrari" completes 1 lap per iteration and has a shorter maximum pit stop time.
        Contender racer1 = new Contender("Ford", 2, 200, pitStop);
        Contender racer2 = new Contender("Ferrari", 1, 100, pitStop);

        // Create threads for each racer
        Thread t1 = new Thread(racer1);
        Thread t2 = new Thread(racer2);

        // Start the racer threads
        t1.start();
        t2.start();

        // Wait for both threads to finish before ending the race
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Race is over.");
    }
}