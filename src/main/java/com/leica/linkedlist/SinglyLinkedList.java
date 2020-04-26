package com.leica.linkedlist;

/**
 * Implement singly linked list refer {@link java.util.LinkedList}
 * 1> Singly linked list insertion, deletion, and search operations
 * 2> the linked list stores int type data
 *
 * @author leica
 * @date 2020/04/26 15:56
 */
public class SinglyLinkedList {
    /**
     * the head node
     */
    private Node head = null;

    /**
     * find node of this list by specified value
     *
     * @param value the specified valued
     * @return the found node
     */
    public Node findByValue(int value) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return head;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * find node of the list by specified subscript
     *
     * @param index the specified index
     * @return the found node
     */
    public Node findByIndex(int index) {
        if (head == null || index < 0) {
            return null;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    /**
     * singly linked list basic node
     * the node store int type data
     */
    public static class Node {
        /**
         * the node data
         */
        private final int data;
        /**
         * the next node
         */
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        /**
         * get the node data
         *
         * @return the node data
         */
        public int getData() {
            return data;
        }
    }


    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = node1;
        Node node = singlyLinkedList.findByIndex(1);
        System.out.println(node);
    }
}
