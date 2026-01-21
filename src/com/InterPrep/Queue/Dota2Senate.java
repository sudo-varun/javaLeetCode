package com.InterPrep.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>(), dire = new LinkedList<>();
        char[] s = senate.toCharArray();
        int n = s.length;
        for(int i = 0; i <= senate.length(); i++) {
            char c = s[i];
            if(c == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantPosition = radiant.poll();
            int direPosition = dire.poll();

            if(radiantPosition > direPosition) {
                dire.add(direPosition + n);
            } else {
                radiant.add(radiantPosition + n);
            }
        }
        if(dire.isEmpty()) {
            return "Radiant";
        }
        return "Dire";
    }
}
