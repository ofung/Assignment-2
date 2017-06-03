package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Liv on 6/2/17.
 */
public class Names {
    Pattern multiLetterPattern = Pattern.compile("[a-zA-Z]+");
    Pattern letterPattern = Pattern.compile("^[a-zA-Z]$");
    Scanner nameInput;
    Utilities utilities;

    public Names(Scanner nameInput, Utilities utilities) {
        this.nameInput = nameInput;
        this.utilities = utilities;
    }

    public String getFirstName() {
        boolean booleanValue = true;
        String firstName = "";
        while(booleanValue)
        {
            System.out.println("Please enter your first name.");
            firstName = nameInput.next();
            utilities.tryExit(firstName);
            Matcher nameMatcher = multiLetterPattern.matcher(firstName);
            boolean matched = nameMatcher.matches();
            if (matched) {
                booleanValue = false;
            } else {
                System.out.println("Invalid Character.  Please enter alphabetical characters only.");
            }

        }

        return firstName;
    }

    public String getLastName() {
        Integer nameLength = getLastNameLength();
        String lastName = "";

        System.out.println("Please enter your last name, one letter at a time.  Press \"enter\" after each letter.");
        int i = 0;
        while (i < nameLength) {
            String lastNameLetters = nameInput.next();
            utilities.tryExit(lastNameLetters);
            Matcher nameMatcher = letterPattern.matcher(lastNameLetters);
            boolean matched = nameMatcher.matches();
            if (matched) {
                lastName += lastNameLetters;
                i++;
            } else {
                System.out.println("Invalid Character.  Please enter single alphabetical characters only.");
            }
        }

        return lastName;
    }

    public Integer getLastNameLength() {
        System.out.println("How many letters are in your last name?");
        String lastNameCountString;
        while(true) {
            try {
                lastNameCountString = nameInput.next();
                utilities.tryExit(lastNameCountString);
                return Integer.valueOf(lastNameCountString);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer.  Please enter a whole number for the last name count.");
            }
        }
    }

    public String getReportName() {
        System.out.println("Please enter the report name.");
        return nameInput.next();
    }
}
