package com.InterPrep;
/*
Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.

There is one laser beam between any two security devices if both conditions are met:

    The two devices are located on two different rows: r1 and r2, where r1 < r2.
    For each row i where r1 < i < r2, there are no security devices in the ith row.

Laser beams are independent, i.e., one beam does not interfere nor join with another.

Return the total number of laser beams in the bank.
Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0th row with any on the 3rd row.
This is because the 2nd row contains security devices, which breaks the second condition

 */
public class LaserBeamsInBank {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int left = 0, right = 1;
        int totalBeams = 0;
        while(right < m) {
            if(bank[left].contains("1") && !bank[right].contains("1")) {
                right++;
                continue;
            }
            if(bank[left].contains("1") && bank[right].contains("1")) {
                int leftDevices = 0, rightDevices = 0;
                for(char c: bank[left].toCharArray()) {
                    if(c == '1') leftDevices++;
                }
                for(char c: bank[right].toCharArray()) {
                    if(c == '1') rightDevices++;
                }
                totalBeams += leftDevices * rightDevices;
                right++;
                left = right - 1;
                continue;
            }
            right++;
            left++;
        }
        return totalBeams;
    }
    public static void main(String[] args) {
        String[] input = new String[]{"000","111","000"};
        LaserBeamsInBank laserBeamsInBank = new LaserBeamsInBank();
        System.out.println(laserBeamsInBank.numberOfBeams(input));
    }
}
