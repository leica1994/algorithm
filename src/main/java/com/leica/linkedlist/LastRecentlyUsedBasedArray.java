package com.leica.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU cache based on array
 * 1. space complexity is O(n)
 * 2. time complexity is O(n)
 * 3. does not support null cache
 *
 * @author leica
 * @date 2020/04/24 16:26
 */
public class LastRecentlyUsedBasedArray<T> {
    /**
     * default capacity: 8
     */
    private static final int DEFAULT_CAPACITY = 1 << 3;
    /**
     * the array capacity
     */
    private final int capacity;
    /**
     * the number of elements in the array
     */
    private int count;
    /**
     * the array {@code data} used to store data
     */
    private final T[] data;
    /**
     * the map of the value t and the index
     */
    private final Map<T, Integer> holder;

    public LastRecentlyUsedBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public LastRecentlyUsedBasedArray(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        holder = new HashMap<>(capacity);
    }

    /**
     * offer the value t to the array
     *
     * @param t the value t
     */
    public void offer(T t) {
        if (t == null) {
            throw new IllegalArgumentException("the cache container does not support null");
        }
        Integer index = holder.get(t);
        if (index == null) {
            if (isFull()) {
                removeAndCache(t);
            } else {
                cache(t, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * determine the element {@code t} is in the array
     *
     * @param t the element
     * @return the element {@code t} is in the array
     */
    public boolean contains(T t) {
        return holder.containsKey(t);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * check whether the array is full
     *
     * @return the array is full
     */
    private boolean isFull() {
        return capacity == count;
    }

    /**
     * remove the last recently used data and offer the data t
     *
     * @param t the data t
     */
    private void removeAndCache(T t) {
        T key = data[--count];
        holder.remove(key);
        cache(t, count);

    }

    /**
     * cache data to the head but move right first
     *
     * @param t     the data t
     * @param index the
     */
    private void cache(T t, int index) {
        rightShift(index);
        data[0] = t;
        holder.put(t, 0);
        count++;
    }

    /**
     * If there is a specified value in the cache, update the location
     *
     * @param index the index
     */
    private void update(Integer index) {
        T target = data[index];
        rightShift(index);
        data[0] = target;
        holder.put(target, 0);
    }

    /**
     * The data on the left of {@code index} is uniformly shifted to the right by one
     *
     * @param index the index
     */
    private void rightShift(int index) {
        for (int i = index - 1; i >= 0; i--) {
            data[i + 1] = data[i];
            holder.put(data[i], i + 1);
        }
    }

}