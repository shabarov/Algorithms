package ru.shabarov.mezentcev.chapter03;

/**
 * Created by Mikhail on 08.09.2016.
 */
public class Task3_6 {

    public static boolean isMersennNumber(long n){
        if(n <= 0) throw new IllegalArgumentException("N must be natural number");
        if(n == 1 || n == 2) return false;
        if(!isPlainNumber(n)) return false;

        double p = log2(n+1);

        if(p % 1 != 0) return false;

        return isPlainNumber((long)p);
    }

    private static double log2(double num){
        return Math.log10(num)/Math.log10(2D);
    }
    public static boolean isPlainNumber(long n){

        if(n <= 0) throw new IllegalArgumentException("N must be natural number");
        if(n == 1 || n == 2) return true;
        if(n % 2 == 0) return false;

        double root = Math.sqrt(n);
        long roundedRoot = Math.round(root + 0.5);

        for(long i = 3; i <= roundedRoot; i++){
            if(n % i == 0) return false;
        }

        return true;
    }
}
