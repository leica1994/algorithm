package com.leica.queue;

/**
 * queue based on linked list
 *
 * @author leica
 * @date 2020/4/29 22:57
 */
public class LinkedListQueue<T> {

    /**
     * head node
     */
    private Node<T> head;
    /**
     * tail node
     */
    private Node<T> tail;

    /**
     * enqueue operation
     *
     * @param t the element to be enqueue
     * @return the result of enqueue
     */
    public boolean enqueue(T t) {
        Node<T> tNode = new Node<>(t, null);
        if (tail == null) {
            head = tail = tNode;
        } else {
            tail.next = tNode;
        }
        return true;
    }

    /**
     * dequeue operation
     *
     * @return the data of  the first node
     */
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T value = head.getData();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    /**
     * the linked list base node
     *
     * @param <T> node generics
     */
    public static class Node<T> {
        /**
         * node data
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

        public T getData() {
            return data;
        }
    }
}
