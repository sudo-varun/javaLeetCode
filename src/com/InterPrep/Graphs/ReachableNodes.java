package com.InterPrep.Graphs;


import java.util.*;

public class ReachableNodes {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int ans = 0;

        int[] restrictedNodes = new int[n];
        for (int j : restricted) {
            restrictedNodes[j] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        restrictedNodes[0] = 1; // Mark the starting node as restricted
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            ans++;
            for(int neighbor: graph.getOrDefault(currentNode, new ArrayList<>())) {
                if(restrictedNodes[neighbor] == 0) { // If the neighbor is not restricted
                    restrictedNodes[neighbor] = 1; // Mark it as restricted
                    queue.add(neighbor);
                }
            }
        }
        return ans;
    }
    public Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
            graph.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
        }
        return graph;
    }
}
