package com.InterPrep;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberSetBits {
        public int countPrimeSetBits(int left, int right) {
            // add prime numbers 2, 3, 5, 7, 11, 13, 17, 19
            Set<Integer> primeNumbers = new HashSet<>();
            primeNumbers.add(2);
            primeNumbers.add(3);
            primeNumbers.add(5);
            primeNumbers.add(7);
            primeNumbers.add(11);
            primeNumbers.add(13);
            primeNumbers.add(17);
            primeNumbers.add(19);
    
            int primeNumbersCount = 0;
            for(int i = left; i <= right; i++) {
                int setBitCount = 0;
                int currNum = i;
                while(currNum > 0) {
                    setBitCount += currNum & 1;
                    currNum >>= 1;
                }
                if(primeNumbers.contains(setBitCount)) {
                    primeNumbersCount++;
                }
            }
            return primeNumbersCount;
        }
    public static void main(String[] args) {
        PrimeNumberSetBits primeNumberSetBits = new PrimeNumberSetBits();
        System.out.println(primeNumberSetBits.countPrimeSetBits(10,15));
    }
}
