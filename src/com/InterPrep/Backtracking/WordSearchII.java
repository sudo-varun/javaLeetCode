package com.InterPrep.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode start = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, start, result);
            }
        }
        return result;
    }
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(char[][] board, int row, int col, TrieNode curr, List<String> result) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char c = board[row][col];
        if (c == '#' || curr.next[c - 'a'] == null) return;
        curr = curr.next[c - 'a'];
        if(curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }
        board[row][col] = '#';
        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            dfs(board, newRow, newCol, curr, result);
        }
        board[row][col] = c;
    }
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result); // Output: ["eat","oath"]
    }
}
