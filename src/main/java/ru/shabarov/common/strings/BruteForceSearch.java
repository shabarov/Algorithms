package ru.shabarov.common.strings;

public class BruteForceSearch {

    public static int search(String txt, String pat) {
        int N = txt.length();
        int M = pat.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)){
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        return j == M ? i - j : -1;
    }
}
