package ru.shabarov.mezentcev.chapter05;

/**
 * Created by Mikhail on 08.09.2016.
 */
public class Task5_11 {
    public static boolean isMagicMatrix(int [][] a) {

        int rows = a.length;
        if(rows < 1) throw new IllegalArgumentException("Matrix must have row count greater than 0");

        int cols = a[0].length;
        if(cols < 1) throw new IllegalArgumentException("Matrix must have column count greater than 0");

        if(rows != cols) throw new IllegalArgumentException("Matrix must be a square");

        int[] rowSum = new int[cols];
        int colSum = 0;
        int diagSum1 = 0;
        int diagSum2 = 0;
        int M = 0;

        //System.out.printf("First line: %d %d %d\n", a[0][0], a[0][1], a[0][2]);

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(row == 0){
                    diagSum1 += a[col][col];
                    diagSum2 += a[cols - 1 - col][cols - 1 - col];
                }
                colSum += a[row][col];
                rowSum[col] += a[row][col];

                if(row == (rows - 1) && rowSum[col] != M){
                    System.out.printf("Column %d is not a magic\n", col);
                    return false;
                }
            }
            if(row == 0){
                M = diagSum1;
                if(diagSum1 != diagSum2){
                    System.out.printf("Diagonals are not magic");
                    return false;
                }
            }

            if(colSum != M){
                System.out.printf("Row %d is not a magic\n", row);
                return false;
            }
            colSum = 0;
        }
        return true;
    }

}
