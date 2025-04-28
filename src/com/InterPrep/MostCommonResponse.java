package com.InterPrep;

import java.util.*;

public class MostCommonResponse {
    public String findCommonResponse(List<List<String>> responses) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> {
            if(a.getValue() != b.getValue()) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });
        List<Set<String>> deduplicatedLists = new ArrayList<>();
        for (List<String> list : responses) {
            deduplicatedLists.add(new LinkedHashSet<>(list)); // preserves order
        }
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Set<String> set : deduplicatedLists) {
            for (String word : set) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        pq.addAll(frequencyMap.entrySet());
        Map.Entry<String, Integer> ans = pq.poll();
        return ans.getKey();
    }
}
