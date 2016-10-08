package ru.shabarov.mezentcev.chapter02;

/**
 * Created by Mikhail on 07.09.2016.
 */
public class Task2_7 {
    private static int PRECISION = 100;
    public static double calculateSeries(double x){
        double series = 1D;
        for(int i = 1; i <= PRECISION; i++){
            double koeff = calculateNumenator(i) / calculateDenominator(i);
            double part = koeff * Math.pow(x, (double)i);

            if(i % 2 != 0) part *= -1D;

            series += part;
        }
        return series;
    }

    public static double seriesCheck(double x){
        return 1.0 / (Math.sqrt(Math.pow(x + 1D, 3)));
    }

    private static double calculateNumenator(int i){
        double result = 1D;
        for(int j = 1; j <= i; j++){
            result *= 2.0 * j + 1;
        }
        return result;
    }
    private static double calculateDenominator(int i){
        double result = 1D;
        for(int j = 1; j <= i; j++){
            result *= 2.0 * j;
        }
        return result;
    }
}
