package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();
        if (a >= h) {
            System.out.println("1");
        } else if (b >= a) {
            System.out.println("Impossible");
        } else {
            int c = a - b;
            int d = (h - a) / c;
            int e = d + 1;
            System.out.println(e);
        }
    }
}
