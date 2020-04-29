package com.leica.queue;

/**
 * circular queue data structure based on array
 *
 * @author leica
 * @date 2020/4/29 23:11
 */
public class CircularQueue<T> {
    /**
     * the array used to store data
     */
    private final T[] data;
    /**
     * array size
     */
    private final int size;
    /**
     * head index
     */
    private int head;
    /**
     * tail index
     */
    private int tail;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = capacity;
    }

    /**
     * enqueue operation
     *
     * @param t the element
     * @return whether the data t enqueue is successful
     */
    public boolean enqueue(T t) {
        if ((tail + 1) % size == head) {
            return false;
        }
        data[tail] = t;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * dequeue operation
     *
     * @return the element of the array data {@code head} subscript
     */
    public T dequeue() {
        //the array is empty
        if (head == tail) {
            return null;
        }
        T value = data[head];
        head = (head + 1) % size;
        return value;
    }
}
