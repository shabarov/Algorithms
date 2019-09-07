package ru.shabarov.common.strings;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] a = getArray();
        LSD.sort(a, 6);
        System.out.println("a = " + Arrays.toString(a));

        a = getArray();
        MSD.sort(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
    }

    private static String [] getArray() {
        return new String [] {"KR8564", "VI5879", "AN1034", "BR0521", "AN1033", "CT2345", "MU8765"};
    }
}
