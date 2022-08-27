package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class ElectronicWatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputInSeconds = scanner.nextInt();

        int hours = inputInSeconds / 3600;
        int minutes = (inputInSeconds % 3600) / 60;
        int seconds = inputInSeconds % 60;

        String hoursToPrint;
        if (hours == 24) {
            hoursToPrint = "0";
        } else {
            hoursToPrint = valueOf(hours);
        }

        String minutesToPrint;
        if (minutes < 10) {
            minutesToPrint = "0" + minutes;
        } else {
            minutesToPrint = valueOf(minutes);
        }

        String secondsToPrint;
        if (seconds < 10) {
            secondsToPrint = "0" + seconds;
        } else {
            secondsToPrint = valueOf(seconds);
        }

        System.out.printf("%s:%s:%s%n", hoursToPrint, minutesToPrint, secondsToPrint);
    }
}
