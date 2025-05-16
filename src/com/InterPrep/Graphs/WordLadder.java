package com.InterPrep.Graphs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);
        int current = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if(endWord.equals(currWord)) return current;
                for(int j = 0; j < currWord.length(); j++) {
                    for(int k = 'a'; k <= 'z'; k++) {
                        char arr[] = currWord.toCharArray();
                        arr[j] = (char) k;
                        String nextWord = new String(arr);
                        if(wordList.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            current++;
        }
        return 0;
    }
}
