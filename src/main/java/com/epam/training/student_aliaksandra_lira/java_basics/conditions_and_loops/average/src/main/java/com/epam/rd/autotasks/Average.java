package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers;
        int count = 0;
        int sum = 0;
        while (scanner.hasNext()) {
            numbers = scanner.nextInt();
            if (numbers == 0) break;
            count++;
            sum += numbers;
        }
        System.out.println(sum / count);
    }

}