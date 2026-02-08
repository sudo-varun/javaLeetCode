package com.InterPrep.Graphs;

import java.util.ArrayList;
import java.util.List;

public class SourceToDestination {
    enum State { UNVISITED, VISITING, VISITED }
    public boolean sd(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
        }
        State[] states = new State[n];
        return dfs(graph, source, destination, states);
    }
    public boolean dfs(List<Integer>[] graph, int currNode, int destination, State[] states) {
        if(states[currNode] == State.VISITING) return false;

        if(states[currNode] == State.VISITED) return true;

        if(graph[currNode].isEmpty()) return currNode == destination;

        if(currNode == destination) return false;

        states[currNode] = State.VISITING;

        for(int adj: graph[currNode]) {
            if(!dfs(graph, currNode, destination, states)) return false;
        }
        states[currNode] = State.VISITED;
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,3},{1,2},{2,1}};
        SourceToDestination std = new SourceToDestination();
        System.out.println(std.sd(4, edges, 0, 3));
    }
}
