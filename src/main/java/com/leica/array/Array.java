package com.leica.array;

/**
 * 1> Insertion, deletion and random access of arrays according to subscript
 * 2> the data in the array is of type int
 *
 * @author leica
 * @date 2020/04/24 9:12
 */
public class Array {
    /**
     * the array {@code data} used to store data
     */
    private final int[] data;
    /**
     * array size
     */
    private final int size;
    /**
     * the number of actual elements in the array
     */
    private int count;

    /**
     * construct method to define array size
     *
     * @param capacity the array size
     */
    public Array(int capacity) {
        this.size = capacity;
        this.data = new int[capacity];
    }

    /**
     * add elements to the array
     *
     * @param index the coordinates of the element to be inserted
     * @param value data to add
     * @return whether this execution is successful
     */
    public boolean insert(int index, int value) {
        //the array is full
        if (count == size) {
            return false;
        }
        //the index is invalid
        if (index < 0 || index > count) {
            return false;
        }
        System.arraycopy(data, index, data, index + 1, count - index);
        data[index] = value;
        count++;
        return true;
    }

    /**
     * delete the elements in the array according to the index
     *
     * @param index the index to delete
     * @return whether this execution is successful
     */
    public boolean delete(int index) {
        // the index is invalid
        if (index < 0 || index > count) {
            return false;
        }
        System.arraycopy(data, index + 1, data, index, count-- - index - 1);
        return true;
    }

    /**
     * find the element in the array according to the index
     *
     * @param index the index of need to be search
     * @return the result of this operating
     */
    public int find(int index) {
        if (index < 0 || index > count) {
            return -1;
        }
        return data[index];
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(data[i]);
            if (i != count - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}