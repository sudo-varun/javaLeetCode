package com.InterPrep.Graphs;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Map<String, Double>> graph = createGraph(equations, values);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = pathWeight(graph, query.getFirst(), query.getLast(), new HashSet<>());
        }
        return result;
    }
    public double pathWeight(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if(!graph.containsKey(start))
            return -1;
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visited.add(start);
        for(Map.Entry<String, Double> neighbour: graph.get(start).entrySet()) {
            if(!visited.contains(neighbour.getKey())) {
                double productWeight = pathWeight(graph, neighbour.getKey(), end, visited);
                if(productWeight != -1) return neighbour.getValue() * productWeight;
            }
        }
        return -1;
    }

    public Map<String, Map<String, Double>> createGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String firstElem = equation.getFirst();
            String lastElem = equation.getLast();
            graph.putIfAbsent(firstElem, new HashMap<>());
            graph.get(firstElem).put(lastElem, values[i]);
            graph.putIfAbsent(lastElem, new HashMap<>());
            graph.get(lastElem).put(firstElem, 1 / values[i]);
        }
        return graph;
    }
}
