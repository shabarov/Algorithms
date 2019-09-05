package ru.shabarov.mezentcev.chapter07;

/**
 * Created by Mikhail on 08.09.2016.
 */
public class Task7_7 {
    public static int[] shiftArray2Right(final int[] array, final int k){
        int [] newArray = new int[array.length + k];
        for(int i = 0; i < array.length; i++){
            newArray[i + k] = array[i];
        }
        return newArray;
    }
}
