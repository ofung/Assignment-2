package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner nameInput = new Scanner(System.in);
        System.out.println("Please enter your first name.");
        String firstName = nameInput.next();
        System.out.println(firstName);

        System.out.println("How many letters are in your last name?");
        Integer lastNameCount = nameInput.nextInt();
        System.out.println(lastNameCount);

        String[] lastName = new String[lastNameCount];

        System.out.println("Please enter your last name, one letter at a time.  Press \"enter\" after each letter.");
        for (int i = 0; i < lastNameCount; i++) {
            String lastNameLetters = nameInput.next();
            lastName[i] = lastNameLetters;
        }
        for (int i = 0; i < lastNameCount; i++) {
            System.out.print(lastName[i]);
        }
    }
}