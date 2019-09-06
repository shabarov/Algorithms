package ru.shabarov.common.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Balanced binary search tree
 *
 * Complexity: O(Log(n)) (search, delete/insert)
 *
 * Space - O(n) for height
 *
 * Usage: 1. Elements traverse in asc/desc order
 *        2. Elements count is unknown, and data structure should provide any count storage in memory
 *        3. dynamic data - many inserts/delete
 */
class BinarySearchTree {

    private Node root;

    void add(int value) {
        if (this.root == null) {
            this.root = new Node(value);
        } else {
            this.root = this.root.add(value);
        }
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
        if (this.root.rank == -1) {
            setRankForSubTree(this.root, 0);
        }

        int rank = this.root.rank;
        List<Node> result = new LinkedList<>();
        List<Node> r;

        do {
            r = getNodesForRank(rank);
            result.addAll(r);
            rank++;
        } while (!r.isEmpty());

        return result;
    }

    private void setRankForSubTree(Node node, int rank) {
        if (node != null) {
            node.setRank(rank);
            setRankForSubTree(node.left, rank + 1);
            setRankForSubTree(node.right, rank + 1);
        }
    }

    private List<Node> getNodesForRank(int rank) {
        List<Node> result = new LinkedList<>();
        level(result, rank, this.root);
        return result;
    }

    private void level(List<Node> a, int rank, Node node) {
        if (node != null) {
            if (node.getRank() == rank) {
                a.add(node);
            } else {
                level(a, rank, node.getLeft());
                level(a, rank, node.getRight());
            }
        }
    }

    private static class Node {

        private int value;
        private Node left;
        private Node right;
        private int height;
        private int rank;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 0;
            this.rank = -1;
        }

        Node add(int value) {
            Node newRoot = this;
            if (value <= this.value) {
                this.left = addToSubTree(this.left, value);
                if (heightDifference() == 2) {
                    if (value <= this.left.value) {
                        newRoot = rotateRight();
                    } else {
                        newRoot = rotateLeftRight();
                    }
                }
            } else {
                this.right = addToSubTree(this.right, value);
                if (heightDifference() == -2) {
                    if (value > this.right.value) {
                        newRoot = rotateLeft();
                    } else {
                        newRoot = rotateRightLeft();
                    }
                }
            }
            newRoot.computeHeight();
            return newRoot;
        }

        private Node addToSubTree(Node parent, int value) {
            if (parent == null) {
                return new Node(value);
            }
            return parent.add(value);
        }

        private void computeHeight() {
            int height = -1;
            if (this.left != null) {
                height = Math.max(height, this.left.height);
            }
            if (this.right != null) {
                height = Math.max(height, this.right.height);
            }
            this.height = height + 1;
        }

        private int heightDifference() {
            int leftTarget = 0;
            int rightTarget = 0;
            if (this.left != null) {
                leftTarget = 1 + this.left.height;
            }
            if (this.right != null) {
                rightTarget = 1 + this.right.height;
            }
            return leftTarget - rightTarget;
        }

        private Node rotateRight() {
            Node newRoot = this.left;
            Node grandson = newRoot.right;
            this.left = grandson;
            newRoot.right = this;

            computeHeight();
            return newRoot;
        }

        private Node rotateRightLeft() {
            Node child = this.right;
            Node newRoot = child.left;
            Node grand1 = newRoot.left;
            Node grand2 = newRoot.right;
            child.left = grand2;
            this.right = grand1;

            newRoot.left = this;
            newRoot.right = child;

            child.computeHeight();
            this.computeHeight();
            return newRoot;
        }

        private Node rotateLeft() {
            Node newRoot = this.right;
            Node grandson = newRoot.left;
            this.right = grandson;
            newRoot.left = this;

            computeHeight();
            return newRoot;
        }

        private Node rotateLeftRight() {
            Node child = this.left;
            Node newRoot = child.right;
            Node grand1 = newRoot.left;
            Node grand2 = newRoot.right;
            child.right = grand1;
            this.left = grand2;

            newRoot.left = child;
            newRoot.right = this;

            child.computeHeight();
            this.computeHeight();
            return newRoot;
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

        int getHeight() {
            return height;
        }

        int getRank() {
            return rank;
        }

        void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", height=" + height +
                    ", rank=" + rank +
                    '}';
        }
    }
}
