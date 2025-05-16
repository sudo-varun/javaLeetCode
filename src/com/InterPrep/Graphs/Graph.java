package com.InterPrep.Graphs;

import java.util.*;

public class Graph {
    Map<Integer, List<int[]>> graph;
    Set<Integer> nodes;
    public Graph(int n, int[][] edges) {
        graph = new HashMap<>();
        nodes = new HashSet<>();
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int edgeCost = edge[2];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{edgeCost, to});
            nodes.add(from);
            nodes.add(to);
        }
    }

    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int edgeCost = edge[2];
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{edgeCost, to});
        nodes.add(from);
        nodes.add(to);
    }

    public int shortestPath(int node1, int node2) {
        int[] distances = new int[nodes.size() + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, node1});
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[node1] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[1];
            int currDist = curr[0];
            if(currDist > distances[currNode]) {
                continue;
            }
            for(int[] neighbour: graph.getOrDefault(currNode, Collections.emptyList())) {
                int nextNode = neighbour[1];
                int nextDistance = neighbour[0];
                int totalDist = currDist + nextDistance;
                if( totalDist < distances[nextNode]) {
                    distances[nextNode] = totalDist;
                    pq.offer(new int[]{totalDist, nextNode});
                }
            }
        }
        return distances[node2] == Integer.MAX_VALUE ? -1 : distances[node2];
    }
}

