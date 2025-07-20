package com.InterPrep;

import java.util.ArrayList;
import java.util.List;

public class FindEvenNumbers {
    List<Integer> numbers;
    public int[] findEvenNumbers(int[] digits) {
        int[] digitFreq = new int[10];
        for(int digit: digits) {
            digitFreq[digit]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if(digitFreq[i] == 0) {
                continue;
            }
            digitFreq[i]--;
            for(int j = 0; j <= 9; j++) {
                if(digitFreq[j] == 0) {
                    continue;
                }
                digitFreq[j]--;
                for(int k = 0; k < 9; k+=2) {
                    if(digitFreq[k] == 0) {
                        continue;
                    }
                    res.add(i*100 + j * 10 + k);
                }
                digitFreq[j]++;
            }
            digitFreq[i]++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
