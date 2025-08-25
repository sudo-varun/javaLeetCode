package com.StandardAlogirthms;

public class UnionFind {
    private int[] parent;  // parent[i] = parent of node i
    private int[] rank;    // rank[i] = approximate depth of tree rooted at i
    private int components; // number of connected components

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;

        // Initially, each node is its own parent (separate component)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    // Find with path compression - makes future finds faster
    public int find(int x) {
        if (parent[x] != x) {
            // Path compression: make parent point directly to root
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    // Union by rank - keeps trees balanced
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // Already in same component
        if (rootX == rootY) {
            return false;
        }

        // Union by rank: attach smaller tree under root of larger tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        components--;
        return true;
    }
    // Check if two nodes are in same component
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getComponents() {
        return components;
    }
    // Demonstrate step by step
    public void printState() {
        System.out.println("Current state:");
        for (int i = 0; i < parent.length; i++) {
            System.out.println("Node " + i + ": parent=" + parent[i] + ", rank=" + rank[i]);
        }
        System.out.println("Components: " + components);
        System.out.println();
    }
}

