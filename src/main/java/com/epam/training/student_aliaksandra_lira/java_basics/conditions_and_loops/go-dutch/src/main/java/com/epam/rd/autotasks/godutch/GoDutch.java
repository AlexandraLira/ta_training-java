package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int money = scan.nextInt();
        if (money < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        int number = scan.nextInt();
        if (number <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }
        int pay = (int) Math.ceil((double) money / number);
        int bill = (pay * 10) / 100;
        System.out.println(pay + bill);

    }

}
