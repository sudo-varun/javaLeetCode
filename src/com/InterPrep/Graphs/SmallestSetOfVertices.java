package com.InterPrep.Graphs;

import java.util.*;

public class SmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for(List<Integer> edge: edges) {
            int destination = edge.getLast();
            indegree[destination]++;
        }
        List<Integer> ans = new ArrayList<>((int) (n / 0.75f + 1));
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) ans.add(i);
        }
        return ans;
    }
}