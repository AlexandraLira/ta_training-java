package com.epam.rd.autotasks.meetstrangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Hello, " + scan.nextLine());
        }
        if (number < 0) {
            System.out.println("Seriously? Why so negative?");
        } else if (number == 0) {
            System.out.println("Oh, it looks like there is no one here");
        }
    }
}

