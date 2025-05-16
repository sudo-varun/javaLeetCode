package com.InterPrep;

import java.util.*;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the graph
        Map<Integer, List<int[]>> graph = buildGraph(times);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];
            if(time > distances[node]) {
                continue;
            }
            for(int[] neighbour: graph.getOrDefault(node, Collections.emptyList())) {
                int newDistance = time + neighbour[0];
                if(newDistance < distances[neighbour[1]]) {
                    distances[neighbour[1]] = newDistance;
                    pq.add(new int[]{newDistance, neighbour[1]});
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, distances[i]);
        }
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    public Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time: times) {
            int source = time[0];
            int destination = time[1];
            int cost = time[2];
            graph.computeIfAbsent(source, k -> new ArrayList<>());
            graph.get(source).add(new int[]{cost, destination});
        }
        return graph;
    }
    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int[][] input = {{1,2,1},{2,3,2},{1,3,2}};
        System.out.println(networkDelay.networkDelayTime(input, 3, 1));
    }
}
