package com.InterPrep;
public class DigitCount {
    public boolean digitCount(String num) {
        int[] freq = new int[10];
        for(char digit: num.toCharArray()) {
            freq[digit - '0']++;
        }
        for(int i = 0; i < num.length(); i++) {
            if((num.charAt(i) - '0') != freq[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        DigitCount digitCount = new DigitCount();
        System.out.println(digitCount.digitCount("1210"));
    }
}
