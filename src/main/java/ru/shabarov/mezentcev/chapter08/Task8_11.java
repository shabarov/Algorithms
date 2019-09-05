package ru.shabarov.mezentcev.chapter08;

/**
 * Created by Mikhail on 08.09.2016.
 */
public class Task8_11 {
    public static int calculateElementsSum(final int [][] matrix){
        int n = matrix.length;
        int mean = n / 2;
        int sum = 0;
        for(int j = 0; j < mean; j++){
            for(int i = 1 + j; i < n - 1 - j; i++){
                sum += matrix[j][i];
            }
        }
        return sum;
    }
}
