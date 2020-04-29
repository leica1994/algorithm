package com.leica.queue;

/**
 * queue data structure based on array
 *
 * @author leica
 * @date 2020/4/29 22:15
 */
public class ArrayQueue<T> {
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
    public ArrayQueue(int capacity) {
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
        if (tail == size) {
            //the array data is full
            if (head == 0) {
                return false;
            }
            System.arraycopy(data, head, data, 0, tail - head);
            tail -= head;
            head = 0;
        }
        data[tail++] = t;
        return true;
    }

    /**
     * dequeue operation
     *
     * @return the element of the array data {@code head} subscript
     */
    public T dequeue() {
        //the array data is empty
        if (head == tail) {
            return null;
        }
        return data[head++];
    }
}
