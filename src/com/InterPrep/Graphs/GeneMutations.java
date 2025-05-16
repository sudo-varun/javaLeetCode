package com.InterPrep.Graphs;

import java.util.*;

public class GeneMutations {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if(!set.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        int currMutations = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currGene = queue.poll();
                if(currGene.equals(endGene)) return currMutations;
                for(int j = 0; j < currGene.length(); j++) {
                    for(int k = 0; k < 4; k++) {
                        char[] chars = currGene.toCharArray();
                        chars[j] = genes[k];
                        String newGene = new String(chars);
                        if(set.contains(newGene) && !visited.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                }
            }
            currMutations++;
        }
        return -1;
    }
}
