package main.java.GFG;

import java.util.ArrayList;
import java.util.List;

/**
 * Creating an own map class that has basic get and put/add functionality
 * @param <K> the key
 * @param <V> the value
 */
public class MockMap<K, V> {

    private List<HashTable<K,V>> bucketList;
    private int numBuckets;
    private int size;

    public MockMap() {
        bucketList = new ArrayList<>();
        numBuckets = 10;
        size = 0;
        for(int i = 0; i < numBuckets; i++) {
            bucketList.add(null);
        }
    }
    private int getBucket(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    public V get(K key) {
        int bucketIndex = getBucket(key);
        HashTable<K, V> head = bucketList.get(bucketIndex);

        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucket(key);

        HashTable<K, V> head = bucketList.get(bucketIndex);

        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketList.get(bucketIndex);
        HashTable<K, V> newVal = new HashTable<>(key, value);
        newVal.next = head;
//        head = newVal; might not be needed
        bucketList.set(bucketIndex, newVal);

        //Increase size of buckets if size exceeds 80% limit
        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0*size)/numBuckets >= 0.8)
        {
            List<HashTable<K, V>> temp = bucketList;
            bucketList = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketList.add(null);

            for (HashTable<K, V> headNode : temp)
            {
                while (headNode != null)
                {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}

class HashTable<K, V> {
    K key;
    V value;

    HashTable<K, V> next;

    HashTable(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
