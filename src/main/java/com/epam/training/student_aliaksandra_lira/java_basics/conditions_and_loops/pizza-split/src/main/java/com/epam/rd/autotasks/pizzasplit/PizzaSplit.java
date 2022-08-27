package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int slices = scanner.nextInt();
        int slicesCache = slices;
        int pizzas = 1;
        while (slicesCache % people != 0) {
            slicesCache += slices;
            pizzas++;
        }
        System.out.println(pizzas);

    }
}
