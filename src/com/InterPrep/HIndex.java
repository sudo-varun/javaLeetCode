package com.InterPrep;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] citationFreq = new int[n+1];
        for(int c: citations) {
            citationFreq[Math.min(n, c)] += 1;
        }
        int h = n;
        int paperCount = citationFreq[n];
        System.out.println(Arrays.toString(citationFreq));
        while (paperCount < h) {
            h -= 1;
            paperCount += citationFreq[h];
        }
        return h;
    }

    public static void main(String[] args) {
        HIndex hindex = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(hindex.hIndex(citations));
    }
}
