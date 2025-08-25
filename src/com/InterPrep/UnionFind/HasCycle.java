package com.InterPrep.UnionFind;

import java.util.*;
import com.StandardAlogirthms.UnionFind;

public class HasCycle {
    public static int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.getComponents();
    }

    // Problem 2: Detect Cycle in Undirected Graph
    public static boolean hasCycle(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            // If both nodes already connected, adding this edge creates cycle
            if (uf.isConnected(edge[0], edge[1])) {
                return true;
            }
            uf.union(edge[0], edge[1]);
        }

        return false;
    }

    // Problem 3: Accounts Merge (Advanced Union Find)
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int id = 0;

        // Assign unique ID to each email
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                emailToName.put(email, name);
            }
        }

        UnionFind uf = new UnionFind(id);

        // Union emails within same account
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                uf.union(emailToId.get(account.get(1)), emailToId.get(account.get(i)));
            }
        }

        // Group emails by their root parent
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = uf.find(emailToId.get(email));
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Build result
        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(emails.get(0)));
            account.addAll(emails);
            result.add(account);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== UNION FIND STEP-BY-STEP DEMO ===");

        UnionFind uf = new UnionFind(5);
        System.out.println("Initial state (5 separate components):");
        uf.printState();

        System.out.println("Union(0, 1):");
        uf.union(0, 1);
        uf.printState();

        System.out.println("Union(2, 3):");
        uf.union(2, 3);
        uf.printState();

        System.out.println("Union(1, 3) - connects two components:");
        uf.union(1, 3);
        uf.printState();

        System.out.println("Check connections:");
        System.out.println("Are 0 and 3 connected? " + uf.isConnected(0, 3));
        System.out.println("Are 0 and 4 connected? " + uf.isConnected(0, 4));

        System.out.println("\n=== PROBLEM EXAMPLES ===");

        // Test connected components
        int[][] edges1 = {{0,1}, {1,2}, {3,4}};
        System.out.println("Edges: " + Arrays.deepToString(edges1));
        System.out.println("Number of components: " + countComponents(5, edges1));

        // Test cycle detection
        int[][] edges2 = {{0,1}, {1,2}, {2,0}};
        System.out.println("Edges: " + Arrays.deepToString(edges2));
        System.out.println("Has cycle: " + hasCycle(3, edges2));
    }
}
