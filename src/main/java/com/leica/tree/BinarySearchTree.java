package com.leica.tree;

/**
 * implementation of binary search tree based on linked list
 *
 * @author leica
 * @date 2020/5/12 21:39
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * root node
     */
    private Node<T> root;

    /**
     * insert the data to the tree
     *
     * @param data the data
     */
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }
        Node<T> node = root;
        while (true) {
            if (data.compareTo(node.data) < 0) {
                if (node.left == null) {
                    node.left = new Node<>(data);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node<>(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    /**
     * search the specified data in the tree
     *
     * @param data the specified data
     * @return the node where the specified data is located
     */
    public Node<T> find(T data) {
        if (root == null) {
            return null;
        }
        Node<T> node = root;
        while (node != null) {
            if (data.compareTo(node.data) < 0) {
                node = node.left;
            } else if (data.compareTo(node.data) > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * delete the node where the specified data is located
     *
     * @param data the data
     */
    public void delete(T data) {
        Node<T> node = root;
        Node<T> parent = null;
        while (node != null && node.data != data) {
            parent = node;
            if (data.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            return;
        }
        if (node.right != null && node.left != null) {
            Node<T> minNode = node.right;
            Node<T> minNodeParent = node;
            while (minNode.left != null) {
                minNodeParent = minNode;
                minNode = minNode.left;
            }
            node.data = minNode.data;
            node = minNode;
            parent = minNodeParent;
        }

        Node<T> child;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }
        if (parent == null) {
            root = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    /**
     * linked list node
     *
     * @param <T> data type
     */
    private static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }
}
