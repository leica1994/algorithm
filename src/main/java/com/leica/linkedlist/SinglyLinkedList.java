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
        if (q == null) {
            return;
        }
        p.next = q.next;
        q.next = p;
    }

    /**
     * delete the specified node
     *
     * @param node the specified node
     */
    public void deleteByNode(Node node) {
        if (node == null || head == null) {
            return;
        }
        if (node == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != node) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = node.next;
    }

    /**
     * delete the node by the specified value
     *
     * @param value the specified value
     */
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    /**
     * determine whether two nodes {@code node1} and {@code node2} are the same
     *
     * @param node1 the node1
     * @param node2 the node2
     * @return whether
     */
    public boolean equals(Node node1, Node node2) {
        Node p = node1;
        Node r = node2;
        while (p != null && r != null) {
            if (p.data != r.data) {
                return false;
            }
            p = p.next;
            r = r.next;
        }
        return p == null && r == null;
    }

    /**
     * determine whether the list is palindrome
     *
     * @return whether the list is palindrome
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            //find the middle node
            Node p = head;
            Node q = head;
            if (p.next == null) {
                return true;
            }
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;

            }

            Node leftLink;
            Node rightLink;
            if (q.next == null) {
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;

            } else {
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return equals(leftLink, rightLink);

        }
    }

    /**
     * inversion the linked list
     *
     * @param node the head node
     * @return the head node of invert
     */
    public Node inverseLinkListWithHead(Node node) {
        Node head = new Node(9999, null);
        head.next = node;
        Node cur = node.next;
        node.next = null;
        Node next;

        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        return head;
    }

    /**
     * inversion the linked list
     *
     * @param node the head node
     * @return the head node of invert
     */
    public Node inverseLinkList(Node node) {
        Node pre = null;
        Node r = head;
        while (r != node) {
            Node next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return r;
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

}
