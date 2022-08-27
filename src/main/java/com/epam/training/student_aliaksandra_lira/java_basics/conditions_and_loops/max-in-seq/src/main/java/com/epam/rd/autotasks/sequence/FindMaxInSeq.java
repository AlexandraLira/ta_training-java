package com.epam.rd.autotasks.sequence;

import java.util.Scanner;

public class FindMaxInSeq {

    public static int max() {
        Scanner scanner = new Scanner(System.in);
        int previous = scanner.nextInt();
        while (scanner.hasNext()) {
            int next = scanner.nextInt();
            if (next == 0) break;
            if (next > previous) previous = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        System.out.println(max());
    }
}
