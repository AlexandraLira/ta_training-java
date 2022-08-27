package com.epam.rd.autotasks;

class Spiral {
    public static int[][] spiral(int rows, int cols) {
        int[][] array = new int[rows][cols];

        int num = 1;
        int max = rows * cols;

        int rmin = 0, rmax = rows - 1;
        int cmin = 0, cmax = cols - 1;

        while (num <= max) {
            for (int i = cmin; num <= max && i <= cmax; i++) {
                array[rmin][i] = num++;
            }
            rmin++;
            for (int i = rmin; num <= max && i <= rmax; i++) {
                array[i][cmax] = num++;
            }
            cmax--;
            for (int i = cmax; num <= max && i >= cmin; i--) {
                array[rmax][i] = num++;
            }
            rmax--;
            for (int i = rmax; num <= max && i >= rmin; i--) {
                array[i][cmin] = num++;
            }
            cmin++;
        }
        return array;
    }
}

