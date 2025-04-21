package com.InterPrep;

public class FindClosestPerson {
    public static void main(String[] args) {

    }
    public int findClosest(int x, int y, int z) {
        int xDistance = Math.abs(z-x);
        int yDistance = Math.abs(y-x);
        if (xDistance == yDistance) {
            return 0;
        } else if(xDistance < yDistance) {
            return 1;
        }
        return 2;
    }
}
