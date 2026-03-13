package com.InterPrep.LinkedList;

import java.util.*;

public class LRUCache {
    class Node {
        public int val;
        public int key;
        public Node prev;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node head;
    Node tail;
    int length;
    Map<Integer, Node> lookup;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.lookup = new HashMap<>();
        this.length = 0;
    }

    public int get(int key) {
        Node ans = lookup.get(key);
        if(ans == null) {
            return -1;
        }
        detach(ans);
        attach(ans);
        return ans.val;
    }

    public void put(int key, int value) {
        Node n = lookup.get(key);
        if(n != null) {
            n.val = value;
            detach(n);
            attach(n);
        } else {
            n = new Node(key, value);
            attach(n);
            lookup.put(key, n);
            this.length++;
        }
        prune();
    }
    private void detach(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
        node.next = null;
        node.prev = null;
    }
    private void attach(Node node) {
        if(this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            node.prev = null;
        }
    }
    private void prune() {
        if(this.length <= this.capacity || this.tail == null) {
            return;
        }
        Node detached = this.tail;
        detach(detached);
        lookup.remove(detached.key);
        this.length--;
    }

    public static void main(String[] args) {
        String s = "abab";
        Queue<Character> a = new LinkedList<>();
        a.add('a');
        System.out.println(a.poll());
        StringBuilder sb = new StringBuilder();
    }
}
