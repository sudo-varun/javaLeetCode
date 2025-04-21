package com.InterPrep;

import java.util.Arrays;

class RankTeams {
    public static void main(String[] args) {
        String[] votes = {"ABC","BCA","ACB","ACB","ACB"};
        RankTeams rankTeams = new RankTeams();
        System.out.println(rankTeams.rankTeams(votes));
    }
    public String rankTeams(String[] votes) {
        int noOfTeams = votes[0].length();
        int[][] ranking = new int[26][noOfTeams];
        for (String vote: votes) {
            for(int i = 0; i < vote.length(); i++) {
                ranking[vote.charAt(i) - 'A'][i]++;
            }
        }
        System.out.println(Arrays.deepToString(ranking));
        Character[] dummy = new Character[noOfTeams];
        //store values in the dummy
        for(int i = 0; i < noOfTeams; i++){
            dummy[i] = votes[0].charAt(i);
        }
        Arrays.sort(dummy, (a,b) -> {
            int indexA = a - 'A', indexB = b - 'A';
            for(int i =0; i < noOfTeams; i++) {
                int difference = ranking[indexA][i] - ranking[indexB][i];
                if(difference != 0) // frequencies are not same
                    return difference > 0 ? -1 : 1;
            }
            return a - b;
        });
        StringBuilder result = new StringBuilder();
        for (char c: dummy) {
            result.append(c);
        }
        return result.toString();
    }
}