package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that simulates the arcade game Skee-Ball based on user input.
 */
public class Main {

    /**
     * A final value that indicates the upperbound for the amount of plays allowed in the simulation.
     */
    final static int MAX_PLAYS = 10;

    /**
     * The main method in which the user is prompted for a valid input, and then a simulation
     * is created based on that input.
     * @param args
     */
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        boolean validInput = false;

        // While validInput is NOT equal to true (not false). keep running the loop and asking the user for a valid input.
        while (!validInput) {
            System.out.printf("%s", "Enter the number of plays (1-10)? ");
            int plays = input.nextInt(); // user input stored in the variable plays.
            if ((plays >= 1) && (plays <= MAX_PLAYS)) {

                validInput = true;
                int[] score = new int[plays]; // an array is created to store the score for each play.
                Main simulation = new Main(); // An instance of the main object is created.
                simulation.simulatePlay(plays, score); // The method simulatePlay is called using an instance of the simulation.
                simulation.showResults(score); // The method showResults is called using an instance of the simulation. The score for each play and the total score is displayed.

            } else {
                // If the input is not between 1 and 10, prompt the user again for a valid input.
                System.out.printf("%s", "Invalid input. Please enter a number between 1 and 10.\n");
            }

        }
        input.close();

    }

    /**
     * Simulates a number of plays based on the input and outputs the hall value for each play.
     * @param plays The number of plays is taken as input from the main method and passed as a parameter here to run the simulation.
     * @param score An array is passed as a parameter to store and keep track of the score from each play.
     */
    public void simulatePlay(int plays, int[] score) {

        for (int i = 0; i < plays; i++) {
            Random r = new Random();
            int percent = r.nextInt(100) + 1;

            if (percent <= 3) {
                // 3% chance of this occurrence.
                score[i] = getHall(1); // Store 80 points
                System.out.printf("Rolling ball #%d. Landed in %d \n", i + 1, score[i]);

            } else if (percent <= 12) {
                // 9% chance of this occurrence.
                score[i] = getHall(2); // Store 60 points.
                System.out.printf("Rolling ball #%d. Landed in %d \n", i + 1, score[i]);

            } else if (percent <= 30) {
                // 18% chance of this occurrence.
                score[i] = getHall(3); // Store 40 points.
                System.out.printf("Rolling ball #%d. Landed in %d \n", i + 1, score[i]);

            } else if (percent <= 50) {
                // 20% chance of this occurrence.
                score[i] = getHall(4); // Store 20 points
                System.out.printf("Rolling ball #%d. Landed in %d \n", i + 1, score[i]);

            } else if (percent <= 70) {
                // 20% chance of this occurrence as well.
                score[i] = getHall(5); // Store 10 points.
                System.out.printf("Rolling ball #%d. Landed in %d \n", i + 1, score[i]);

            } else {
                // 30% chance of this occurrence.
                score[i] = getHall(6); // Store 0 points.
                System.out.printf("Rolling ball #%d. Landed in %d \n", i + 1, score[i]);
            }
        }
    }

    /**
     *  This method gets the hall value.
     * @param caseValue A case value is passed from the simulatePlay method. This is used as a case to
     *                determine what hall value should be returned. Each case value corresponds to a certain
     *                percentage.
     * @return Depending on the case value, a certain hall int value will be returned.
     */
    public int getHall(int caseValue) {

        return switch (caseValue) {
            case 1 -> 80; // 3% chance
            case 2 -> 60; // 9% chance
            case 3 -> 40; // 18% chance
            case 4 -> 20; // 20% chance
            case 5 -> 10; // 20% chance
            default -> 0; // 30% chance
        };

    }

    /**
     * Displays the score associated with each play and the total score achieved.
     * @param score An array containing all of the scores for one simulation is passed as the parameter.
     */
    public void showResults(int[] score) {
        // Creates the output table
        System.out.println("\n+----------+---------+");
        System.out.printf("%s %10s %9s\n", "|", "Play # |", "Score |");
        System.out.println("+----------+---------+");

        int n = score.length;
        int i = 0;
        int total = 0;
        while (i < n) {

            System.out.printf("%8d %3s %6d %n", i + 1, "|", score[i]);
            total = total + score[i]; // Sum up all of the values in the score array to get the total score.
            i += 1; // iterate i.
        }
        System.out.println("+----------+---------+");
        System.out.printf("%s %d", "\nTotal:", total);

    }

}