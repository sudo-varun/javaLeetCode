package com.InterPrep.Graphs;

import java.util.*;

public class MinEdgeReversals {
    int[] reversals;
    public int[] minEdgeReversals(int n, int[][] edges) {
        Map<Integer, List<List<Integer>>> graph = createGraph(edges);
        reversals = new int[n];
        int[] seen = new int[n];
        reversals[0] = walk(graph, seen, 0);
        Arrays.fill(seen, 0);
        reroot(graph, seen, 0);
        return reversals;
    }

    public int walk(Map<Integer, List<List<Integer>>> graph, int[] seen, int currNode) {
        seen[currNode] = 1;
        int r = 0;
        List<List<Integer>> neighbours = graph.get(currNode);
        for(List<Integer> neighbour: neighbours) {
            int nextNode = neighbour.getFirst();
            int cost = neighbour.getLast();
            if(seen[nextNode] == 1) continue;

            r += cost + walk(graph, seen, nextNode);
        }
        return r;
    }

    public void reroot(Map<Integer, List<List<Integer>>> graph, int[] seen, int currNode) {
        seen[currNode] = 1;
        List<List<Integer>> neighbours = graph.get(currNode);
        for(List<Integer> neighbour: neighbours) {
            int nextNode = neighbour.getFirst();
            int cost = neighbour.getLast();
            if(seen[nextNode] == 1) continue;

            reversals[nextNode] = reversals[currNode] + 1 - 2 * cost;
            reroot(graph, seen, nextNode);
        }
    }

    public Map<Integer, List<List<Integer>>> createGraph(int[][] edges) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            graph.computeIfAbsent(start, k -> new ArrayList<>());
            graph.get(start).add(List.of(end, 0));
            graph.computeIfAbsent(end, k -> new ArrayList<>());
            graph.get(end).add(List.of(start, 1));
        }
        return graph;
    }

    public static void main(String[] args) {
        MinEdgeReversals minEdgeReversals = new MinEdgeReversals();
        int[][] edges = {{2,0},{2,1},{1,3}};
        int[] ans = minEdgeReversals.minEdgeReversals(4, edges);
        System.out.println(Arrays.toString(ans));
    }
}
