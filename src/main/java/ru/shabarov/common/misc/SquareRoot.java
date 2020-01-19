package ru.shabarov.common.misc;

public class SquareRoot {

    public static void main(String [] args) {
        System.out.println("sqrt(16) = " + sqrt(16));
    }

    /**
     * sqrt_n+1 = (sqrt_n + (num / sqrt_n)) / 2.0
     *
     * if a^2 = N
     * then a = (a + N/a) / 2
     */
    private static double sqrt(int number) {
        double t;
        double squareRoot = number / 2.0;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }
}
