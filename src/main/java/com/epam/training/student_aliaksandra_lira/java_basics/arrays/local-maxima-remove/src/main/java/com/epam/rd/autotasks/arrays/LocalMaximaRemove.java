package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {

        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        int[] newArray = new int[array.length];
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] <= array[i - 1] || i != array.length - 1 && array[i] <= array[i + 1]) {
                newArray[max++] = array[i];
            }

        }

        return Arrays.copyOfRange(newArray, 0, max);
    }
}
