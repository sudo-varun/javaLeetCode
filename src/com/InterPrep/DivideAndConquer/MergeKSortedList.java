package com.InterPrep.DivideAndConquer;
import com.DataStructures.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l: lists) {
            if(l != null) {
                pq.offer(l);
            }
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
            if(head.next!=null) pq.offer(head.next);
        }
        return dummy.next;
    }
}
