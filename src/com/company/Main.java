package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        Utilities utilities = new Utilities();
        Names names = new Names(scanner, utilities);

        System.out.println("Welcome!  You can exit anytime by typing '-1'.  Let's begin!");

        String firstName = names.getFirstName();
        String lastName = names.getLastName();
        String reportName = names.getReportName();

        int[] sixIntegers = new int[6];
        int i = 0;
        double max = 0;
        double min = 0;
        double total = 0;
        double average = 0;
        while (i < 6) {
            System.out.println("Please enter 6 integers, pressing enter after each entry.");
            try {
                String inputString = scanner.next();
                utilities.tryExit(inputString);

                int input = Integer.valueOf(inputString);
                sixIntegers[i] = input;

                average = (input+total)/(i+1);
                total += input;
                if (i == 0 || input > max) {
                    max = input;
                }

                if (i == 0 || input < min) {
                    min = input;
                }

                System.out.println("Input: " + input + ", Total: " + total + ", Average: " + average + ", Max: " + max + ", Min: " + min);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry.  Please enter an integer.  For example - 1, 2 or 3.  You got this.");
            }
        }

        boolean booleanValue = true;
        double doubleValue = 0;
        while(booleanValue) {
            System.out.println("Please enter a double.  For example, 2.1 or 5.3.");
            try {
                doubleValue = scanner.nextDouble();
                utilities.tryExit(String.valueOf(doubleValue));
                average = (doubleValue+total)/(i+1);
                total += doubleValue;
                if (doubleValue > max) {
                    max = doubleValue;
                } else if (doubleValue < min) {
                    min = doubleValue;
                }

                System.out.println("Input: " + doubleValue + ", Total: " + total + ", Average: " + average + ", Max: " + max + ", Min: " + min);

                booleanValue = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry.  Please enter a double.  Other examples - 3.7, 9.2.");
            }
        }

        System.out.println();
        System.out.println("Report Name: " + reportName);
        System.out.println("Owner: " + firstName + " " + lastName);
        System.out.println();
        System.out.println(" Number Input | Max | Min | Average | Total (By Row) ");
        System.out.println("_____________________________________________________");
        double newTotal = 0;
        for (int j : sixIntegers) {
            newTotal += j;
            System.out.println(j + ", " + max + ", " + min + ", " + average + ", " + newTotal);
        }
        System.out.println(doubleValue + ", " + max + ", " + min + ", " + average + ", " + total);

        System.out.println();
        System.out.println("Grand Total of Number Inputs: " + total);
    }
}
