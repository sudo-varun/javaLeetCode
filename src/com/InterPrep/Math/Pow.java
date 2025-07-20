package com.InterPrep.Math;

public class Pow {
    public double myPow(double x, int n) {

        if(n < 0){
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(7.0, 11));
    }
}
