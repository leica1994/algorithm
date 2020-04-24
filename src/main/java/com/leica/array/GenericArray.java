package com.leica.array;

import java.util.ArrayList;

/**
 * Implement arrays with generalizations refer {@link ArrayList}
 *
 * @author leica
 * @date 2020/04/24 10:30
 * @see ArrayList
 */
public class GenericArray<T> {
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     */
    private T[] elementData;
    /**
     * The size of the GenericArray (the number of elements it contains).
     */
    private int size;
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     */
    @SuppressWarnings("unchecked")
    public GenericArray(int capacity) {
        this.elementData = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public GenericArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * get the capacity of an array
     *
     * @return the capacity of the array
     */
    public int getCapacity() {
        return elementData.length;
    }

    /**
     * get the number of actual elements in the array
     *
     * @return the number of actual elements in the array
     */
    public int size() {
        return size;
    }

    /**
     * determine if the array is empty
     *
     * @return Returns <tt>true</tt> if this array contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Modify the element at index
     *
     * @param index the subscript of modified
     * @param e     the element of modified
     */
    public void set(int index, T e) {
        checkIndex(index);
        elementData[index] = e;
    }

    /**
     * get the element in the array according to the index
     *
     * @param index the index
     * @return the element in the array according to the index
     */
    public T get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param e the specified element
     * @return Returns <tt>true</tt> if this list contains the specified element.
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * find the index according to the specified element
     *
     * @param e the specified element e
     * @return the index according to the specified element
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Appends the specified element to the specified position of this list.
     *
     * @param e element to be appended to this list
     * @return whether it was added successfully
     */
    public boolean add(int index, T e) {
        checkIndex(index);
        //If the current number of elements is equal to the capacity of the array
        if (size == elementData.length) {
            ensureCapacity(size);
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the beginning of this array.
     *
     * @param e the element to add
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * Inserts the specified element into the end of the array
     *
     * @param e the element to add
     */
    public void add(T e) {
        add(size, e);
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index to remove
     * @return the element of removed
     */
    public T remove(int index) {
        checkIndexForRemove(index);
        T t = get(index);
        System.arraycopy(elementData, index + 1, elementData, index, size-- - index - 1);
        //reduce capacity
        if (size == elementData.length >> 2 && elementData.length >> 1 != 0) {
            resize(elementData.length >> 1);
        }
        return t;
    }

    /**
     * remove the first element of the array
     *
     * @return the element to removed
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * remove the last element of the array
     *
     * @return the element to removed
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * remove the specified element of the array
     *
     * @param e the element to removed
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, elementData.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(elementData[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * expand the array to 1.5 times its original capacity if the array is full
     *
     * @param capacity the array capacity
     */
    private void ensureCapacity(int capacity) {
        resize(capacity + capacity >> 1);
    }

    /**
     * adjust the array capacity
     *
     * @param capacity he array capacity
     */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        this.elementData = newArray;
    }

    /**
     * check if the index to be remove is legal
     *
     * @param index the index to check
     */
    private void checkIndexForRemove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }

    /**
     * check if the index is legal
     *
     * @param index the index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }
}