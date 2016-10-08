package ru.shabarov.mezentcev.chapter04;

/**
 * Created by Mikhail on 08.09.2016.
 */
public class Task4_6 {
    public static boolean isSubSequence(final int[] a, final int[] c){
        int firstElementIndex = 0;
        int aLength = a.length;
        int cLength = c.length;
        if(cLength < 1) throw new IllegalArgumentException("Length of C must be greater than 0");
        if(cLength > aLength) throw new IllegalArgumentException("Length of A must be greater or equal to length of C");
        boolean isFoundMismatch = false;

        while(firstElementIndex <= aLength - cLength){

            //System.out.printf("Check element index %d\n", firstElementIndex);

            for(int compareIndex = 0; compareIndex < cLength; compareIndex++){
                if(a[firstElementIndex + compareIndex] != c[compareIndex]){
                    isFoundMismatch = true;
                    break;
                }
            }

            if(!isFoundMismatch) return true;

            firstElementIndex++;
            isFoundMismatch = false;
        }
        return false;
    }
}
