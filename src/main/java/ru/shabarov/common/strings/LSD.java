package ru.shabarov.common.strings;

/**
 * Complexity: O((n + b) * log(base=b)(k)), where n - elements amount,
 * b - numbers/char base (256^2 in this example), k - maximum number/string
 */
class LSD {

    static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256 * 256;
        String [] aux = new String[N];
        for (int d = w - 1; d >= 0; d--) {
            int [] count = new int[R];
            for (String s : a) {
                count[s.charAt(d) + 1]++;
            }
            for (int r = 0; r < R - 1; r++) {
                count[r + 1] += count[r];
            }
            for (String s : a) {
                aux[count[s.charAt(d)]++] = s;
            }
            System.arraycopy(aux, 0, a, 0, N);
        }
    }
}
