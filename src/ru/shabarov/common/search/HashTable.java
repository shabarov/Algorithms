package ru.shabarov.common.search;

import java.util.LinkedList;

class HashTable {

    private LinkedList<String>[] table;

    private int n;

    HashTable(String[] a) {
        this.n = a.length;
        this.table = (LinkedList<String>[]) new LinkedList[n];

        for (String e : a) {
            int bucket = bucket(e, this.n);
            if (table[bucket] == null) {
                table[bucket] = new LinkedList<>();
            }
            table[bucket].add(e);
        }
    }

    boolean contains(String e) {
        int bucket = bucket(e, this.n);
        return this.table[bucket].contains(e);
    }

    private int bucket(String e, int n) {
        return Math.abs(e.hashCode()) % n;
    }
}
