package com.InterPrep.SlidingWindow;

import java.util.*;

public class ContainsDuplicates {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = k;
        Set<Integer> el = new LinkedHashSet<>();
        Map<Integer, Integer> posToEl = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= right; i++) {
            int c = nums[i];
            if(el.contains(c)) return true;
            el.add(c);
            posToEl.put(i, c);
        }
        right++;
        while(right < nums.length) {
            // remove left
            int l = posToEl.get(left);
            el.remove(l);
            posToEl.remove(left);
            left++;
            // check if right is in the set if not add
            int r = nums[right];
            if(el.contains(r)) return true;
            el.add(r);
            posToEl.put(right, r);
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2};
        ContainsDuplicates containsDuplicates = new ContainsDuplicates();
        System.out.println(containsDuplicates.containsNearbyDuplicate(nums, 2));
    }
}
