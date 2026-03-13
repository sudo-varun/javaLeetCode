package com.DataStructures;


import java.util.*;

class LFUCache {
    Map<Integer, Integer> keyToFreq;
    Map<Integer, Integer> keyToValue;
    Map<Integer, LinkedHashSet<Integer>> freqToKey;
    int minFreq = 0;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();
    }
    private void touch(int key) {
        int freq = keyToFreq.get(key);
        LinkedHashSet<Integer> keys = freqToKey.get(freq);
        keys.remove(key);
        int newFreq = freq + 1;
        if(keys.isEmpty()) {
            freqToKey.remove(freq);
            if(minFreq == freq) minFreq++;
        }
        keyToFreq.put(key, newFreq);
        freqToKey.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);
    }

    public int get(int key) {
        if(!keyToValue.containsKey(key)) return -1;
        touch(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if(keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            touch(key);
        } else {
            if(keyToValue.size() >= capacity) evict();
            keyToValue.put(key, value);
            keyToFreq.put(key, 1);
            minFreq = 1;
            freqToKey.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        }
    }
    public void evict() {
        // remove min freq
        LinkedHashSet<Integer> keys = freqToKey.get(minFreq);
        int key = keys.getFirst();
        keys.remove(key);
        if(keys.isEmpty()) freqToKey.remove(minFreq);
        keyToValue.remove(key);
        keyToFreq.remove(key);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(2,2);
        lfuCache.put(1,1);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
        lfuCache.put(3,3);
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(4));
    }
}
