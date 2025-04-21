package com.InterPrep;

public class ValidPalindromeII {
    public static void main(String[] args) {
        String p = "racecaer";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome(p));
    }
    public boolean validPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char[] sChars = s.toCharArray();
        int skipsLeft = 0;
        while(left < right) {
            if(sChars[left] != sChars[right]) {
                skipsLeft++;
                left++;
                continue;
            }
            left++;
            right--;
        }
        left = 0;
        right = sChars.length - 1;
        int skipsRight = 0;
        while(left < right) {
            if(sChars[left] != sChars[right]) {
                skipsRight++;
                right--;
                continue;
            }
            left++;
            right--;
        }
        return skipsLeft <= 1 || skipsRight <= 1 || (skipsLeft == 0 && skipsRight == 0);
    }
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char[] sChars = s.toCharArray();
        while(left < right) {
            if(sChars[left] != sChars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
