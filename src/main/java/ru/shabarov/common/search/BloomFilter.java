package ru.shabarov.common.search;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

class BloomFilter {

    private static final int N = 1000;

    private final BitSet bits = new BitSet(N);

    private List<HashFunction> func = Arrays.asList(v -> hash(v, 31) % N,
            v -> hash(v, 33) % N,
            v -> hash(v, 37) % N);

    void add(String e) {
        this.func.forEach(f -> {
            BitSet mask = getMask(e, f);
            bits.or(mask);
        });
    }

    boolean contains(String e) {
        for (HashFunction f : this.func) {
            BitSet mask = getMask(e, f);
            BitSet clonedBits = new BitSet();
            clonedBits.or(bits);
            clonedBits.and(mask);
            if (clonedBits.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private BitSet getMask(String e, HashFunction f) {
        BitSet mask = new BitSet(N);
        int hash = f.hash(e);
        mask.set(hash);
        return mask;
    }

    @Override
    public String toString() {
        return "BloomFilter{" +
                "bits=" + bits +
                '}';
    }

    @FunctionalInterface
    private interface HashFunction {
        int hash(String value);
    }

    private int hash(String s, int prime) {
        int hash = 0;
        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                hash = prime * hash + c;
            }
        }
        return Math.abs(hash);
    }
}
