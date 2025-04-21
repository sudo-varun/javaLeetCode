package com.InterPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> ans = new ArrayList<>();
        List<String> sortedStrs = new ArrayList<>(strs.length);
        for(int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            sortedStrs.add(i, new String(c));
        }
        System.out.println();
        while(!input.isEmpty()) {
            String current = input.remove(0);
            String sorted = sortedStrs.remove(0);
            List<String> currList = new ArrayList<>();
            currList.add(current);
            // Iterate backward to avoid index skipping
            for (int i = input.size() - 1; i >= 0; i--) {
                if (sorted.equals(sortedStrs.get(i))) {
                    currList.add(input.remove(i)); // Remove and add to group
                    sortedStrs.remove(i);
                }
            }
            ans.add(currList);
        }
        return ans;
    }
}

