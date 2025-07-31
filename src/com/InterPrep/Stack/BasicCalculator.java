package com.InterPrep.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//(1+(4+5+2)-3)+(6+8)
public class BasicCalculator {
    public int calculate(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                queue.add((char) calculate(s.substring(i + 1)));

            } else if (s.charAt(i) == ')') {
                 queue.add(((char) calculateStack(queue)));
            } else {
                queue.add(s.charAt(i));
            }
        }
        return calculateStack(queue);
    }
    private int calculateStack(Queue<Character> expression) {
        int ans = 0;
        boolean isNegative = false;
        while(!expression.isEmpty()) {
            char c = expression.poll();
            if(c == '-') {
                isNegative = true;
            } else if(c != '+') {
                if(!isNegative) {
                    ans += Character.digit(c, 10);
                } else {
                    ans -= Character.digit(c, 10);
                }
                isNegative = false;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();
        queue.add('-');
        queue.add('4');
        queue.add('+');
        queue.add('5');
        queue.add('-');
        queue.add('2');
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
