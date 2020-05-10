package com.leica.hashtable;

import java.util.HashMap;

/**
 * Implement LRU cache based on hash table
 *
 * @author leica
 * @date 2020/5/10 17:05
 */
public class LastRecentlyUsedBasedHashTable<K, V> {

    /**
     * default linked list capacity : 8
     */
    public static final int DEFAULT_CAPACITY = 8;

    /**
     * the head sentinel node
     */
    private final Node<K, V> head;

    /**
     * the tail sentinel node
     */
    private final Node<K, V> tail;

    /**
     * the linked list length
     */
    private int length;

    /**
     * the linked list capacity
     */
    private final int capacity;

    /**
     * the hash table data
     */
    private final HashMap<K, Node<K, V>> table;

    /**
     * add by lru
     *
     * @param key   the key
     * @param value the value
     */
    public void add(K key, V value) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            Node<K, V> kvNode = new Node<>(key, value);
            table.put(key, kvNode);
            addNode(kvNode);
            if (++length > capacity) {
                Node<K, V> tailNode = popTail();
                table.remove(tailNode.key);
                length--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    /**
     * move the node to the head
     *
     * @param node the node
     */
    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * pop the tail node
     *
     * @return the tail node
     */
    private Node<K, V> popTail() {
        Node<K, V> node = tail.previous;
        removeNode(node);
        return node;
    }

    /**
     * remove node
     *
     * @param node the node
     */
    private void removeNode(Node<K, V> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    /**
     * add new node to the head
     *
     * @param node the new node
     */
    private void addNode(Node<K, V> node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    public LastRecentlyUsedBasedHashTable(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.previous = head;
        table = new HashMap<>();
    }

    public LastRecentlyUsedBasedHashTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * hash table doubly linked list node
     */
    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> previous;
        private Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
