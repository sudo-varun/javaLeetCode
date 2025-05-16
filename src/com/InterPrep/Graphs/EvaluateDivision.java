package com.InterPrep.Graphs;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = createGraph(equations, values);
        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            ans[i] = getPathValue(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        return ans;
    }

    private double getPathValue(String start, String end, Map<String, Map<String, Double>> graph, Set<String> seen) {
        if(!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if(graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        seen.add(start);
        for(Map.Entry<String, Double> neighbour: graph.get(start).entrySet()) {
            if(!seen.contains(neighbour.getKey())) {
                double productWeight = getPathValue(neighbour.getKey(), end, graph, seen);
                if(productWeight != -1) {
                    return neighbour.getValue() * productWeight;
                }
            }
        }
        return -1;
    }

    private Map<String, Map<String, Double>> createGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
        }
        return graph;
    }
}
