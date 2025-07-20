package com.InterPrep.Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfLife {
    /*
    Input: board = [
        [0,1,0],
        [0,0,1],
        [1,1,1],
        [0,0,0]
        ]
Output: [
        [0,0,0],
        [1,0,1],
        [0,1,1],
        [0,1,0]
        ]
     */
    static int[][] directions = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int noOfLiveNeighbours = getNumberOfNeighbouringLives(i, j, board);
                if(board[i][j] == 1) {
                    if(noOfLiveNeighbours == 2 || noOfLiveNeighbours == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if(noOfLiveNeighbours == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getNumberOfNeighbouringLives(int i, int j, int[][] board) {
        int noOfLives = 0;
        for(int[] direction: directions) {
            int neighbourX = j + direction[0];
            int neighbourY = i + direction[1];
            if(neighbourX >= 0 && neighbourY >= 0 && neighbourX < board[0].length && neighbourY < board.length) {
                if((board[neighbourY][neighbourX] & 1) == 1) {
                    noOfLives++;
                }
            }
        }
        return noOfLives;
    }
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
