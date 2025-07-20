package com.InterPrep.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;     // store larger numbers
    PriorityQueue<Integer> maxHeap;     // store smaller numbers
    public MedianFinder() {
        // Initialize your data structure here.
        // The median will be either the top of the max heap or the average of the tops of both heaps.
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        while(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
    /*
    test ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
    result [null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,6.00000,null,5.50000,null,6.00000,null,5.50000,null,5.00000,null,4.00000,null,3.00000]

     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian()); // 6.0
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian()); // 8.0
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 6.0
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian()); // 6.0
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // 6.0
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian()); // 5.5
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian()); // 6.0
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 5.5
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian()); // 5.0
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian()); // 4.0
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian()); // 3.0
    }
}
