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
     * insertion value at the beginning
     *
     * @param value the value to be inserting
     */
    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }

    /**
     * insert value at the beginning
     *
     * @param node the node to be inserting
     */
    public void insertToHead(Node node) {
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    /**
     * insert value at the tailing
     *
     * @param value the value to be inserting
     */
    public void insertTail(int value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    /**
     * insert the value after the node
     *
     * @param node  the node
     * @param value the value
     */
    public void insertAfter(Node node, int value) {
        Node p = new Node(value, null);
        insertAfter(node, p);
    }

    /**
     * insert the specified node p after the node
     *
     * @param node the node
     * @param p    the node p
     */
    public void insertAfter(Node node, Node p) {
        if (node == null) {
            return;
        }
        p.next = node.next;
        node.next = p;
    }

    /**
     * insert the value before the node
     *
     * @param node  the node
     * @param value the value
     */
    public void insertBefore(Node node, int value) {
        Node p = new Node(value, null);
        insertBefore(node, p);
    }

    /**
     * insert the value before the node
     *
     * @param node the node
     * @param p    the node p
     */
    public void insertBefore(Node node, Node p) {
        if (node == null) {
            return;
        }
        if (node == head) {
            insertToHead(p);
            return;
        }
        Node q = head;
        while (q != null && q.next != node) {
            q = q.next;
        }
        p.next = q.next;
        q.next = p;
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
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = node1;
        Node node = singlyLinkedList.findByIndex(1);
        System.out.println(node);
    }
}
