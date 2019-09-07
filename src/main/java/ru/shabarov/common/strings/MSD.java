package ru.shabarov.common.strings;

public class MSD {

    private static final int R = 256 * 256;
    private static final int M = 3;
    private static String [] aux;

    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    public static void sort(String [] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(String [] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            insertionSort(a, lo, hi, d);
            return;
        }
        int [] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        if (hi + 1 - lo >= 0) System.arraycopy(aux, 0, a, lo, hi + 1 - lo);

        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private static void insertionSort(String[] a, int lo, int hi, int d) {
        for (int i = lo + 1; i <= hi; i++) {
            String current = a[i];
            int j = i - 1;
            while (j >= lo && less(current, a[j], d)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }

    private static boolean less(String a, String b, int d) {
        return a.substring(d).compareTo(b.substring(d)) < 0;
    }
}
