package com.InterPrep.Graphs;

import com.DataStructures.GraphNode;

import java.util.HashMap;
import java.util.Map;

public class CloneNode {
    public GraphNode clone(GraphNode node) {
        if(node == null) {
            return null;
        }
        return depthFirst(node, new HashMap<>());
    }
    private GraphNode depthFirst(GraphNode node, Map<GraphNode, GraphNode> oldToNew) {
        if(oldToNew.containsKey(node)) {
           return oldToNew.get(node);
        }
        GraphNode newNode = new GraphNode(node.val);
        oldToNew.putIfAbsent(node, newNode);
        for(GraphNode neighbour: node.neighbors) {
            newNode.neighbors.add(depthFirst(neighbour, oldToNew));
        }
        return newNode;
    }
}
