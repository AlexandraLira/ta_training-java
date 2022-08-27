package com.epam.rd.autotasks;

class CycleSwap {

    public static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    public static void cycleSwap(int[] array, int shift) {
        for (int i = 0; i < shift; i++) {
            if (array.length == 0) break;
            int temp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
    }

}

