/**
 * Contender.java
 * Author: Trent Moore
 * Course: Object Oriented Programming COP-3330C-24217
 * Date: 04/06/2025
 * Program Objective:
 * This class simulates a racer in a track battle between cars. Each racer completes a set number of laps per iteration,
 * taking random pit stops between iterations, until reaching a target of 200 laps. The first racer to complete
 * 200 or more laps wins the race.
 */

public class Contender implements Runnable {
    private String name;
    private int lapsPerIteration; // Number of laps completed per iteration
    private int lapsCompleted;    // Total laps completed
    private int maxPitStopTime;   // Maximum pit stop time in milliseconds
    private PitStop pitStop;      // Shared PitStop instance for pit stops

    public static volatile boolean winner = false; // Flag to indicate if a winner has been declared

    /**
     * Constructor for Contender.
     * @param name The name of the racer.
     * @param lapsPerIteration The number of laps completed each iteration.
     * @param maxPitStopTime The maximum pit stop time in milliseconds.
     * @param pitStop The shared PitStop instance for pit stops.
     */
    public Contender(String name, int lapsPerIteration, int maxPitStopTime, PitStop pitStop) {
        this.name = name;
        this.lapsPerIteration = lapsPerIteration;
        this.maxPitStopTime = maxPitStopTime;
        this.pitStop = pitStop;
        this.lapsCompleted = 0;
    }

    /**
     * The run method simulates the racer's progress.
     * It takes a random pit stop (up to maxPitStopTime), completes a number of laps,
     * checks if the target of 200 laps has been reached, and then takes a pit stop.
     */
    @Override
    public void run() {
        while (!winner) {
            try {
                // Take a pit stop rest: sleep for a random time (in milliseconds) up to maxPitStopTime
                int sleepTime = (int) (Math.random() * maxPitStopTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted during pit stop rest.");
                Thread.currentThread().interrupt();
                return;
            }

            // Complete laps
            lapsCompleted += lapsPerIteration;
            System.out.println(name + " completed laps. Total laps: " + lapsCompleted);

            // Check if this racer has reached or exceeded 200 laps
            if (lapsCompleted >= 200 && !winner) {
                winner = true;
                System.out.println(name + " wins the race!");
                break;
            }

            // Take a pit stop using the shared PitStop object
            pitStop.pitStop(name);
        }
    }
}