package com.InterPrep;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String word: words) {
            freq.merge(word, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    int freqCompare = a.getValue() - b.getValue(); // lowest freq first
                    if (freqCompare != 0) {
                        return freqCompare;
                    } else {
                        return b.getKey().compareTo(a.getKey()); // reverse lexicographical to keep consistent when popping
                    }
                }
        );
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll(); // Remove lowest freq
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> c = pq.poll();
            result.add(c.getKey());
        }
        Collections.reverse(result);
        return result;
    }
}
