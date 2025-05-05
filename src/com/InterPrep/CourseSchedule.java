package com.InterPrep;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adjList = new List[n];
        int[] indegree = new int[n];
        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            if(adjList[pre] == null) {
                adjList[pre] = new ArrayList<>();
            }
            adjList[pre].add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            if(adjList[pre] == null) {
                continue;
            }
            for(int course: adjList[pre]) {
                indegree[course]--;
                if(indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        return count == n;
    }
}
