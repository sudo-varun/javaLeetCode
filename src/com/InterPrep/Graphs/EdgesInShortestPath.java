package com.InterPrep.Graphs;

import java.util.*;

/*
You are given an undirected weighted graph of n nodes numbered from 0 to n - 1. The graph consists of m edges represented by a 2D array edges, where edges[i] = [ai, bi, wi] indicates that there is an edge between nodes ai and bi with weight wi.

Consider all the shortest paths from node 0 to node n - 1 in the graph. You need to find a boolean array answer where answer[i] is true if the edge edges[i] is part of at least one shortest path. Otherwise, answer[i] is false.

Return the array answer.

Note that the graph may not be connected.
Example 1:

Input: n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]

Output: [true,true,true,false,true,true,true,false]

Explanation:

The following are all the shortest paths between nodes 0 and 5:

    The path 0 -> 1 -> 5: The sum of weights is 4 + 1 = 5.
    The path 0 -> 2 -> 3 -> 5: The sum of weights is 1 + 1 + 3 = 5.
    The path 0 -> 2 -> 3 -> 1 -> 5: The sum of weights is 1 + 1 + 2 + 1 = 5.


 */
public class EdgesInShortestPath {
    public boolean[] findAnswer(int n, int[][] edges) {
        int[] distances = new int[n];
        Map<Integer, List<int[]>> graph = buildGraph(edges);
        int[] prev = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        Arrays.fill(prev, -1);
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[1];
            int currDistance = curr[0];
            if(currDistance > distances[currNode]) {
                continue;
            }
            for(int[] neighbour: graph.getOrDefault(currNode, Collections.emptyList())) {
                int nextNode = neighbour[1];
                int nextDistance = neighbour[0];
                int newDistance = currDistance + nextDistance;
                if(newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    pq.offer(new int[]{newDistance, nextNode});
                }
            }
        }
        boolean[] answer = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // Edge is on a shortest path if it maintains the shortest distance property
            if ((distances[u] != Integer.MAX_VALUE && distances[v] != Integer.MAX_VALUE) &&
                    (distances[u] + w == distances[v] || distances[v] + w == distances[u])) {
                answer[i] = true;
            }
        }
        return answer;
    }
    public Map<Integer, List<int[]>> buildGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int cost = edge[2];
            graph.computeIfAbsent(source, k -> new ArrayList<>());
            graph.get(source).add(new int[]{cost, destination});
            graph.computeIfAbsent(destination, k -> new ArrayList<>());
            graph.get(destination).add(new int[]{cost, source});
        }
        return graph;
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
        EdgesInShortestPath edgesInShortestPath = new EdgesInShortestPath();
        edgesInShortestPath.findAnswer(6, input);
    }
}
