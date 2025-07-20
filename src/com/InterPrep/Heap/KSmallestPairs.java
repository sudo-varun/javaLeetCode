package com.InterPrep.Heap;

import java.util.*;

public class KSmallestPairs {
    /*
    You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

    Define a pair (u, v) which consists of one element from the first array and one element from the second array.

    Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



    Example 1:

    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    Output: [[1,2],[1,4],[1,6]]
    Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

    Example 2:

    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
    Output: [[1,1],[1,1]]
    Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getFirst() + a.get(1) - b.getFirst() - b.get(1));
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return result;
        for(int i=0; i<nums1.length && i<k; i++) {
            pq.offer(new ArrayList<>(Arrays.asList(nums1[i], nums2[0], 0)));
        }
        while(k-- > 0 && !pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            result.add(Arrays.asList(curr.get(0), curr.get(1)));
            if(curr.get(2) + 1 < nums2.length) {
                pq.offer(new ArrayList<>(Arrays.asList(curr.get(0), nums2[curr.get(2) + 1], curr.get(2) + 1)));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,5,6};
        int[] nums2 = new int[]{3,5,7,9};
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        System.out.println(kSmallestPairs.kSmallestPairs(nums1, nums2, 3));
    }
}
