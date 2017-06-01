package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner nameInput = new Scanner(System.in);
        Pattern namePattern = Pattern.compile("[a-zA-Z]+");
        boolean booleanValue = true;
        String firstName;
        while(booleanValue)
        {
            System.out.println("Please enter your first name.");
            firstName = nameInput.next();
            Matcher nameMatcher = namePattern.matcher(firstName);
            boolean matched = nameMatcher.matches();
            if (matched) {
                System.out.println(firstName);
                booleanValue = false;
            } else {
                System.out.println("Invalid Character.  Please enter alphabetical characters only.");
            }

        }

        System.out.println("How many letters are in your last name?");
        Integer lastNameCount = nameInput.nextInt();
        System.out.println(lastNameCount);

        String[] lastName = new String[lastNameCount];

        System.out.println("Please enter your last name, one letter at a time.  Press \"enter\" after each letter.");
//        for (int i = 0; i < lastNameCount; i++) {
//            String lastNameLetters = nameInput.next();
//            lastName[i] = lastNameLetters;
//        }
        int i = 0;
        while(lastNameCount > i) {
            String lastNameLetters = nameInput.next();
            lastName[i] = lastNameLetters;
           i++;
        }
        // Fix to only take the correct letter if user enters more than 1
        for (int j = 0; j < lastNameCount; j++) {
            System.out.print(lastName[j]);
        }


    }
}