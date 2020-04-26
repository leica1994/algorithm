package com.leica.linkedlist;

/**
 * Implement LinkedList refer {@link java.util.LinkedList}
 * and implement the following simple functions:
 * 1. singly linked list reversal
 * 2. detection of rings in linked list
 * 3. two ordered linked lists merge
 * 4. delete the penultimate nth node of the linked list
 * 5. find the middle node of the linked list
 *
 * @author leica
 * @date 2020/04/24 16:27
 */
public class LinkedListAlgorithm<T> {

    /**
     * singly linked list reversal
     *
     * @param node the head node
     * @param <T>  the node generic
     * @return the head node after reversal
     */
    public static <T> Node<T> reverse(Node<T> node) {
        Node<T> curr = node;
        Node<T> pre = null;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * detection of rings in linked list
     * there are three ways to achieve:
     * 1. violent solution
     * 2. hashtable
     * 3. speed ​​pointer
     * <p>
     * this method uses the third way to solve: fast and slow pointer
     *
     * @param node the head node
     * @param <T>  the node generics
     * @return is there a ring
     */
    public static <T> boolean checkCircle(Node<T> node) {
        if (node == null) {
            return false;
        }
        Node<T> fast = node.next;
        Node<T> slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * two ordered linked lists merge
     *
     * @param node1 the first node
     * @param node2 the second node
     * @return the head node of new linked list
     */
    public static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        //simplify with sentinel node
        Node<Integer> sentinelNode = new Node<>(0, null);
        Node<Integer> p = sentinelNode;
        while (node1 != null && node2 != null) {
            if (node1.getData() < node2.getData()) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        if (node1.next != null) {
            p.next = node1;
        }
        if (node2.next != null) {
            p.next = node2;
        }
        return sentinelNode.next;
    }

    /**
     * delete the penultimate k th node
     *
     * @param head the head node
     * @param k    the penultimate k
     * @param <T>  the node generics
     * @return the head node after execution
     */
    public static <T> Node<T> deleteLastSubscript(Node<T> head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 1) {
            return head;
        }
        Node<T> fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        Node<T> slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * find the middle node of the linked list
     *
     * @param head the head node
     * @param <T>  node generics
     * @return the middle node
     */
    public static <T> Node<T> findMiddleNode(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<T> fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * print all nodes info
     *
     * @param head the head node
     */
    public static <T> void print(Node<T> head) {
        Node<T> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.getData());
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * linked list basic node
     *
     * @param <T> generic of the node
     */
    public static class Node<T> {
        /**
         * the node data
         */
        private T data;
        /**
         * the next node
         */
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * get the node data
         *
         * @return the node data
         */
        public T getData() {
            return data;
        }
    }

}
