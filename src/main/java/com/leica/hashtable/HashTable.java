package com.leica.hashtable;

/**
 * hash table
 *
 * @author leica
 * @date 2020/5/9 22:26
 */
public class HashTable<K, V> {

    /**
     * hash table default capacity : 8
     */
    public static final int DEFAULT_INITIAL_CAPACITY = 8;

    /**
     * default load factor : 0.75
     */
    public static final float LOAD_FACTOR = 0.75f;
    /**
     * The hash table data
     */
    private Entry<K, V>[] table;

    /**
     * number of elements actually stored
     */
    private int size;

    /**
     * the total number of entries in the hash table.
     */
    private int count;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * Maps the specified {@code key} to the specified
     * {@code value} in this hashtable. Neither the key nor the
     * value can be {@code null}. <p>
     * <p>
     * The value can be retrieved by calling the {@code get} method
     * with a key that is equal to the original key.
     *
     * @param key   the hashtable key
     * @param value the value
     */
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>();
        }
        Entry<K, V> temp = table[index];
        if (temp.next == null) {
            temp.next = new Entry<>(key, value, null);
            size++;
            count++;
            if (count >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {
            do {
                temp = temp.next;
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
            } while (temp.next != null);
            table[index].next = new Entry<>(key, value, table[index].next);
            size++;
        }
    }

    /**
     * Delete the value corresponding to the specified key
     *
     * @param key the specified key
     * @return the value of deleted
     */
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return null;
        }
        Entry<K, V> pre;
        Entry<K, V> head = e;
        do {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                size--;
                if (head.next == null) {
                    count--;
                }
                return e.value;
            }

        } while (e.next != null);
        return null;
    }

    /**
     * Get the corresponding value according to the specified key
     *
     * @param key the specified key
     * @return the corresponding value of the specified key
     */
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return null;
        }
        do {
            e = e.next;
            if (key == e.key) {
                return e.value;
            }
        } while (e.next != null);
        return null;
    }

    /**
     * Initializes or doubles table size.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length << 1];
        count = 0;
        for (Entry<K, V> kvEntry : oldTable) {
            if (kvEntry == null || kvEntry.next == null) {
                continue;
            }
            Entry<K, V> e = kvEntry;
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    table[index] = new Entry<>();
                }
                table[index].next = new Entry<>(e.key, e.value, table[index].next);
            }

        }

    }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    /**
     * Hashtable bucket collision list entry
     *
     * @param <K> key generic
     * @param <V> value generic
     */
    public static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
