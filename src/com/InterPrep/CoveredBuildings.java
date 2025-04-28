package com.InterPrep;

import java.util.*;

public class CoveredBuildings {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2}, {2,2}, {3,2}, {2,1}, {2,3}};
        CoveredBuildings coveredBuildings = new CoveredBuildings();
        int ans = coveredBuildings.countCoveredBuildings(3, input);
        System.out.println(ans);
    }
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Create a set for O(1) lookups
        Set<String> buildingSet = new HashSet<>();
        for (int[] building : buildings) {
            buildingSet.add(building[0] + "," + building[1]);
        }

        // Create memoization maps for each direction
        Map<String, Boolean> topDP = new HashMap<>();
        Map<String, Boolean> bottomDP = new HashMap<>();
        Map<String, Boolean> leftDP = new HashMap<>();
        Map<String, Boolean> rightDP = new HashMap<>();

        int coveredCount = 0;

        // Check each building
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            // Check for buildings in all four directions with memoization
            boolean hasTop = hasBuildingInDirection(x, y, 0, 1, buildingSet, n, topDP);
            boolean hasBottom = hasBuildingInDirection(x, y, 0, -1, buildingSet, n, bottomDP);
            boolean hasLeft = hasBuildingInDirection(x, y, -1, 0, buildingSet, n, leftDP);
            boolean hasRight = hasBuildingInDirection(x, y, 1, 0, buildingSet, n, rightDP);

            if (hasTop && hasBottom && hasLeft && hasRight) {
                coveredCount++;
            }
        }

        return coveredCount;
    }

    private boolean hasBuildingInDirection(int x, int y, int dx, int dy,
                                           Set<String> buildings, int n,
                                           Map<String, Boolean> dp) {
        String key = x + "," + y + ":" + dx + "," + dy;

        // If we've already computed this, return the cached result
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int nextX = x + dx;
        int nextY = y + dy;

        while (nextX >= 0 && nextX <= n && nextY >= 0 && nextY <= n) {
            if (buildings.contains(nextX + "," + nextY)) {
                dp.put(key, true);
                return true;
            }
            nextX += dx;
            nextY += dy;
        }

        dp.put(key, false);
        return false;
    }
}
