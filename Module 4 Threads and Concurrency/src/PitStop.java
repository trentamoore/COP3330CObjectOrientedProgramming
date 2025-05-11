/**
 * PitStop.java
 * Author: Trent Moore
 * Course: Object Oriented Programming COP-3330C-24217
 * Date: 04/06/2025
 * Program Objective:
 * This class represents a shared pit stop resource for the racers.
 * Its synchronized pitStop() method ensures that only one racer can use the pit stop at a time.
 * It simulates different pit stop durations to reflect performance differences between the racers.
 */

public class PitStop {

    /**
     * Synchronized method to simulate a pit stop.
     * Only one racer can use the pit stop at a time.
     * If the racer is "Ford", simulate a longer pit stop,
     * giving an advantage to "Ferrari" with a quicker turnaround.
     *
     * @param racerName The name of the racer taking the pit stop.
     */
    public synchronized void pitStop(String racerName) {
        System.out.println(racerName + " enters the pit stop.");
        try {
            // Simulate different pit stop durations based on the racer.
            // If the racer is "Ford", take a longer pit stop; otherwise, a shorter one.
            long stopTime = racerName.equals("Ford") ? 300 : 100;
            Thread.sleep(stopTime);
        } catch (InterruptedException e) {
            System.out.println(racerName + " was interrupted during the pit stop.");
            Thread.currentThread().interrupt();
        }
        System.out.println(racerName + " leaves the pit stop.");
    }
}