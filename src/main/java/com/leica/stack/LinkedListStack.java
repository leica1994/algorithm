package com.leica.stack;

/**
 * implement stack based on linked list
 *
 * @author leica
 * @date 2020/04/29 10:50
 */
public class LinkedListStack<T> {
    /**
     * the top node
     */
    private Node<T> top = null;

    /**
     * push operation
     *
     * @param t the element t to be push
     * @return the result of push operation
     */
    public boolean push(T t) {
        top = new Node<>(t, top);
        return true;
    }

    /**
     * pop the last element
     *
     * @return the last element
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> temp = top;
        top = top.next;
        return temp.getData();
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
