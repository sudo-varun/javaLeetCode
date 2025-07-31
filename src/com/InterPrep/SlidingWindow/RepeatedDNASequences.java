package com.InterPrep.SlidingWindow;

import java.util.*;

/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

    For example, "ACGAATTCCG" is a DNA sequence.

When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
that occur more than once in a DNA molecule. You may return the answer in any order.



Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for( int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10) ;
            if(!seen.add(sub)){
                repeated.add(sub);
            }
        }
        return new ArrayList<>(repeated);
    }
}
