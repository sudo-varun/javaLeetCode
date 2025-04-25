package com.InterPrep;

import java.util.ArrayList;
import java.util.List;

public class SeparateDigits {
    public static void main(String[] args) {
        System.out.println(String.valueOf(13));
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> separated = new ArrayList<>();

        for(int num: nums) {
            String n = String.valueOf(num);
            for (char c : n.toCharArray()) {
                separated.add(c - '0');
            }
        }
        return separated.stream().mapToInt(Integer::intValue).toArray();
    }
}