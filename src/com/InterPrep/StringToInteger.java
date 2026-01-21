package com.InterPrep;


import java.util.HashMap;
import java.util.Map;

public class StringToInteger {
    public int myAtoi(String s) {
        int ans = 0;
        s = s.trim();
        if(s.isEmpty()) {
            return 0;
        }
        boolean isNegative = s.charAt(0) == '-';
        boolean hasPositiveChar = s.charAt(0) == '+';
        if(isNegative) {
            s = s.substring(1);
        }
        if(hasPositiveChar) {
            s = s.substring(1);
        }
        Map<Character, Integer> digits = new HashMap<>();
        int i = 0;
        for(char d = '0'; d <= '9'; d++) digits.put(d, i++);

        for(char c: s.toCharArray()) {
            if(digits.containsKey(c)) {
                long res = (long)ans * 10 + digits.get(c);
                if(isNegative && res > (long)Integer.MAX_VALUE + 1) {
                    return Integer.MIN_VALUE;
                } else if (!isNegative && res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    ans = (int)res;
                }
            } else {
                break;
            }
        }
        return isNegative ? -ans : ans;
    }
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("-21474836482"));
    }
}
