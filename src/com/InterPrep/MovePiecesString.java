package com.InterPrep;

import java.util.Arrays;

public class MovePiecesString {
    public static void main(String[] args) {
        MovePiecesString mps = new MovePiecesString();
        System.out.println(mps.canChange("_L__R__R_", "L______RR"));
    }
    public boolean canChange(String start, String target) {
       int startIndex = 0, targetIndex = 0;
       int startLength = start.length();
       while(startIndex < startLength && targetIndex < startLength) {
           while(startIndex < startLength && start.charAt(startIndex) == '_') {
               startIndex++;
           }
           while(targetIndex < startLength && target.charAt(targetIndex) == '_') {
               targetIndex++;
           }
           if (startIndex == startLength || targetIndex == startLength) {
               return startIndex == startLength && targetIndex == startLength;
           }
           if(start.charAt(startIndex) != target.charAt(targetIndex) ||
                   (start.charAt(startIndex) == 'L' && startIndex < targetIndex) ||
                   (start.charAt(startIndex) == 'R' && startIndex > targetIndex)
           ) return false;

           startIndex++;
           targetIndex++;
       }
       return true;
    }
}
