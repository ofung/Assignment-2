package com.company;

/**
 * Created by Liv on 6/2/17.
 */
public class Utilities {
    public void tryExit(String input) {
        switch(input) {
            case "-1":
                System.out.println("Exiting...");
                System.exit(0);
        }
    }
}
