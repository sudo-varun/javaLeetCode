package com.InterPrep.Graphs;

import java.util.*;

/*

 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];

        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            if(adj[pre] == null) {
                adj[pre] = new ArrayList<>();
            }
            adj[pre].add(course);
            indegree[course]++;
        }
        Queue<Integer> courses = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                courses.offer(i);
            }
        }
        List<Integer> taken = new ArrayList<>();
        while(!courses.isEmpty()) {
            int currCourse = courses.poll();
            taken.add(currCourse);
            if(adj[currCourse] == null) {
                continue;
            }
            for(int preSatisfiedCourse: adj[currCourse]) {
                indegree[preSatisfiedCourse]--;
                if(indegree[preSatisfiedCourse] == 0) {
                    courses.offer(preSatisfiedCourse);
                }
            }
        }
        return taken.size() == n ? taken.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,0}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        System.out.println(Arrays.toString(courseScheduleII.findOrder(2, input)));
    }
}
