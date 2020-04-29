package com.leica.stack;

/**
 * implement stack structure based on array
 *
 * @author leica
 * @date 2020/04/29 10:26
 */
public class ArrayStack<T> {
    /**
     * the array default capacity
     */
    public static final int DEFAULT_CAPACITY = 1 << 3;
    /**
     * the array {@code items} used to store data
     */
    private T[] data;
    /**
     * the number of elements in the stack
     */
    private int count;
    /**
     * the stack size
     */
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
        this.size = capacity;
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * push operation
     *
     * @param t the element t to be push
     * @return the result of push operation
     */
    public boolean push(T t) {
        if (isFull()) {
            ensureCapacity(size);
        }
        data[count++] = t;
        return true;
    }

    /**
     * pop operation : pop the last element
     *
     * @return the last element
     */
    public T pop() {
        if (count == 0) {
            return null;
        }
        return data[count-- - 1];
    }

    /**
     * expanded capacity
     *
     * @param size the original capacity
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity(int size) {
        this.data = (T[]) new Object[size + size >> 1];
        this.size = size;
    }

    /**
     * determine the array is full
     *
     * @return whether the array is full
     */
    private boolean isFull() {
        return count == size;
    }
}
