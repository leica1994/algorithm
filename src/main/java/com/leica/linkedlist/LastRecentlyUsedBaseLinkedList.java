package com.leica.linkedlist;

/**
 * Implement LRU cache based on array
 *
 * @author leica
 * @date 2020/04/24 16:26
 */
public class LastRecentlyUsedBaseLinkedList<T> {

    /**
     * default capacity : 10
     */
    public static final Integer DEFAULT_CAPACITY = 10;

    /**
     * the head node
     */
    private Node<T> head;

    /**
     * the linked list length
     */
    private Integer length;

    /**
     * the linked list capacity
     */
    private final Integer capacity;

    public LastRecentlyUsedBaseLinkedList(Integer capacity) {
        head = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public LastRecentlyUsedBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * add the data {@code t} to the linked list
     *
     * @param t the data t
     */
    public void add(T t) {
        Node<T> node = findPreNode(t);
        if (node == null) {
            if (length.equals(capacity)) {
                deleteElementAtEnd();
            }
        } else {
            deleteNextNode(node);
        }
        insertElementAtBegin(t);
    }


    /**
     * delete the next node of the specified node
     *
     * @param node the specified node
     */
    private void deleteNextNode(Node<T> node) {
        Node<T> next = node.getNext().getNext();
        node.setNext(next);
        length--;
    }

    /**
     * insert the element t to the list
     *
     * @param t the element to be insert
     */
    private void insertElementAtBegin(T t) {
        head = new Node<>(t, head);
        length++;
    }

    /**
     * delete the tail node
     */
    private void deleteElementAtEnd() {
        Node<T> node = head;
        if (node.getNext() == null) {
            return;
        }
        //penultimate node
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        length--;
    }

    /**
     * find the node before the element {@code t}
     *
     * @param t the element t
     * @return the node before the element {@code t} if present
     */
    private Node<T> findPreNode(T t) {
        Node<T> node = head;
        while (node.next != null) {
            if (t.equals(node.next.getElement())) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * the linked list node
     *
     * @param <T> node generics
     */
    public static class Node<T> {
        /**
         * node element
         */
        private T element;
        /**
         * the next node
         */
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
