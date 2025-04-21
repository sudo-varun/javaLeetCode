package com.InterPrep;

public class CountNonDecreasingNumbers {
    public int countNumbers(String l, String r, int b) {
        int start = Integer.parseInt(l);
        int end = Integer.parseInt(r);
        int count = 0;
        for(int i = start; i <= end; i++) {
            String num = Integer.toString(i, b);
            if(isNonDecreasing(num)) {
                count++;
            }
        }
        return count;
    }
    public boolean isNonDecreasing(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
