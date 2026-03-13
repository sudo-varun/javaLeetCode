package com.InterPrep.LinkedList;

import com.DataStructures.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode start = head;
        int l = 0;
        while(start != null) {
            l++;
            start = start.next;
        }
        int elementToRemove = l - n;
        if(elementToRemove == 0) {
            return head.next;
        }
        start = head;
        for(int i = 0; i < elementToRemove - 1; i++) {
            start = start.next;
        }
        if(start.next.next != null) {
            start.next = start.next.next;
        } else {
            start.next = null;
        }
        return head;
    }
}
