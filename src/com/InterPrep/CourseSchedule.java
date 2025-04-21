package com.InterPrep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adjList = new List[n];
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            if (adjList[course] == null) {
                adjList[course] = new ArrayList<>();
            }
            adjList[course].add(prerequisite);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);
            if(adjList[current] != null) {
                for(int next: adjList[current]) {
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return ans.size() == n;
    }
}
