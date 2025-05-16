package com.InterPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringFrequency {
    public int maxFreqSum(String s) {
        Map<Character, Integer> vowelMap = new HashMap<>();
        Map<Character, Integer> consonentMap = new HashMap<>();
        for(Character c: s.toCharArray()) {
            if(isVowel(c)) {
                vowelMap.merge(c, 1, Integer::sum);
            } else {
                consonentMap.merge(c, 1, Integer::sum);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> vowelQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Character, Integer>> consonantQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        vowelQueue.addAll(vowelMap.entrySet());
        consonantQueue.addAll(consonentMap.entrySet());
        int maxVowelCount = 0;
        int maxConsonentCount = 0;
        if(!vowelQueue.isEmpty()) {
            maxVowelCount = vowelQueue.poll().getValue();
        }
        if(!consonantQueue.isEmpty()) {
            maxConsonentCount = consonantQueue.poll().getValue();
        }
        return maxConsonentCount + maxVowelCount;
    }
    private boolean isVowel(Character c) {
        return "aeiou".contains(c.toString());
    }
    public static void main(String[] args) {
        StringFrequency stringFrequency = new StringFrequency();
        System.out.println(stringFrequency.maxFreqSum("aeiaeia"));
    }
}
