package com.InterPrep;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() <= 1) return false;
        int right = 1;
        while(right <= s.length() / 2) {
            String subString = s.substring(0, right);
            System.out.println("checking sub string: " + subString);
            if(s.length() % subString.length() != 0) {
                right++;
                continue;
            }
            boolean isRepeated = true;
            for(int i = right; i <= s.length(); i += right) {
                if(!subString.equals(s.substring(i - right, i))) {
                    isRepeated = false;
                    break;
                }
            }
            if(isRepeated) return true;
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("bb"));
    }
}
