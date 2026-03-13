package com.InterPrep;


import java.util.*;

public class UniqueActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userToMinute = new HashMap<>();
        for(int[] log: logs) {
            int user = log[0];
            int minute = log[1];
            if(!userToMinute.containsKey(user)) {
                userToMinute.put(user, new HashSet<>());
            }
            userToMinute.get(user).add(minute);
        }
        int[] ans = new int[k];
        for(Map.Entry<Integer, Set<Integer>> entry: userToMinute.entrySet()) {
            int uam = entry.getValue().size();
            ans[uam]++;
        }
        return ans;
    }
}
