package com.InterPrep.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        int m = board[0].length;
        int n = board.length;

        boolean[][] seen = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = dfs(board, seen, i, j, 0, word);
                if(ans) {
                    return true;
                }
            }
        }
        return ans;
    }
    private boolean dfs(char[][] board, boolean[][] seen, int row, int col, int idx, String word) {
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0) {
            return false;
        }
        if(seen[row][col]) {
            return false;
        }
        boolean found;
        seen[row][col] = true;
        if(board[row][col] == word.charAt(idx)) {
            if(idx == word.length() - 1) {
                return true;
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for(int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                found = dfs(board, seen, newRow, newCol, idx+1, word);
                if(found) {
                    return true;
                }
            }
        }
        seen[row][col] = false;
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word: words) {
            if(exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "a"));
    }
}
