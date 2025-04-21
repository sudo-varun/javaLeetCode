package com.InterPrep;

import com.DataStructures.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneNode {
    public GraphNode clone(GraphNode node) {
        return depthFirst(node, new ArrayList<>(), new HashMap<>());
    }
    public GraphNode depthFirst(GraphNode node, List<GraphNode> seen, Map<GraphNode, GraphNode> oldToNew) {
        if(node == null) {
            return null;
        }
        if (seen.contains(node)) {
            return oldToNew.getOrDefault(node, new GraphNode());
        }
        GraphNode newNode = new GraphNode(node.val);
        oldToNew.putIfAbsent(node, newNode);
        for(GraphNode neighbour: newNode.neighbors) {
            seen.add(neighbour);
            newNode.neighbors.add(depthFirst(neighbour, seen, oldToNew));
        }
        return newNode;
    }
}
