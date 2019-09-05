package ru.shabarov.common.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Non-balanced binary search tree
 *
 * Complexity: search, insert - average/best case - O(Log(n))
 *                              worst case - O(n)
 *
 * Space - O(n)
 *
 * Usage: 1. Elements traverse in asc/desc order
 *        2. Elements count is unknown, and data structure should provide any count storage in memory
 *        3. dynamic data - many inserts/delete
 */
class BinarySearchTree {

    private Node root;

    private int n = 0;

    void add(int value) {
        if (this.root == null) {
            this.root = new Node(value, 0);
        } else {
            this.root.add(value);
        }
        this.n++;
    }

    boolean contains(int value) {
        Node node = this.root;
        while (node != null) {
            if (node.getValue() == value) {
                return true;
            } else if (value <= node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    List<Integer> inorder() {
        if (this.root != null) {
            return this.root.inorder(new ArrayList<>());
        }
        return null;
    }

    List<Node> asArray() {
        int rank = 0;
        List<Node> result = new LinkedList<>();
        List<Node> r;

        do {
            r = getNodesForLevel(rank);
            result.addAll(r);
            rank++;
        } while (!r.isEmpty());

        return result;
    }

    private List<Node> getNodesForLevel(int rank) {
        List<Node> result = new LinkedList<>();
        level(result, rank, this.root);
        return result;
    }

    private void level(List<Node> a, int rank, Node node) {
        if (node != null) {
            if (node.getRank() == rank) {
                a.add(node);

            } else if (node.getRank() < rank) {
                level(a, rank, node.getLeft());
                level(a, rank, node.getRight());
            }
        }
    }

    private static class Node {

        private int value;
        private Node left;
        private Node right;
        private int rank;

        Node(int value, int rank) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.rank = rank;
        }

        void add(int value) {
            if (value <= this.value) {
                if (this.left != null) {
                    this.left.add(value);
                } else {
                    this.left = new Node(value, this.rank + 1);
                }
            } else {
                if (this.right != null) {
                    this.right.add(value);
                } else {
                    this.right = new Node(value, this.rank + 1);
                }
            }
        }

        List<Integer> inorder(List<Integer> a) {
            if (this.left != null) {
                this.left.inorder(a);
            }

            a.add(this.value);

            if (this.right != null) {
                this.right.inorder(a);
            }

            return a;
        }

        int getValue() {
            return value;
        }

        Node getLeft() {
            return left;
        }

        Node getRight() {
            return right;
        }

        int getRank() {
            return rank;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", rank=" + rank +
                    '}';
        }
    }

}
