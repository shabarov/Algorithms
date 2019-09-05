package ru.shabarov.common.search;

public class Main {

    public static void main(String[] args) {

        // Hash Table
        String [] a = {"aaa", "bbb", "ccc"};
        HashTable table = new HashTable(a);
        System.out.println("table contains bbb = " + table.contains("bbb"));
        System.out.println("table contains ddd = " + table.contains("ddd"));

        //Non-balanced BST
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(4);
        binarySearchTree.add(6);
        binarySearchTree.add(2);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(0);
        binarySearchTree.add(7);
        binarySearchTree.add(9);
        binarySearchTree.add(1);
        binarySearchTree.add(8);
        binarySearchTree.add(9);
        binarySearchTree.add(4);
        binarySearchTree.add(1);

        System.out.println(binarySearchTree.inorder());
        System.out.println(binarySearchTree.asArray());

        System.out.println("BST contains 0 = " + binarySearchTree.contains(0));
        System.out.println("BST contains 10 = " + binarySearchTree.contains(10));

        // Bloom Filter for Strings
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add("a");
        bloomFilter.add("ab");
        bloomFilter.add("abc");
        bloomFilter.add("abcd");
        bloomFilter.add("abcde");

        System.out.println(bloomFilter);

        System.out.println("bloomFilter contains 'ab' = " + bloomFilter.contains("ab"));
        System.out.println("bloomFilter contains 'abracadabra' = " + bloomFilter.contains("abracadabra"));
    }
}
