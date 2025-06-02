package com.company;

import java.util.HashSet;

public class ValidSudoku36 {

    public boolean validSudoku(char[][] board){

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];


        for(int i = 0;i<9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        for(int i  = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }

                char val = board[i][j];
                int box = (i/3) * 3  + (j/3);  // Combines row-block and column-block into unique box ID (0–8)
                // if we wrote i/3 + j/3 then we don't get 0-8 we will repeat only 0-2

                //when i is 3 and j is 0 now we are in box 4 but using that formula i/3 + j/3 we are getting only 1 that's why we have used (i/3) * 3 + (j/3)

                if(rows[i].contains(val) || cols[j].contains(val) || boxes[box].contains(val)){
                    return false;
                }

                rows[i].add(val);
                cols[j].add(val);
                boxes[box].add(val);
            }
        }

        return true;
    }

    public boolean validSudokuOptimized(char[][] board){

        HashSet<String> seen = new HashSet<>(); // just using one string set and then use this one

        for(int i  = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }

                char val = board[i][j];
                int box = (i/3) * 3  + (j/3);

                if(!seen.add(val + " at row "+i) || !seen.add(val +" at col "+j) || !seen.add(val+" at box "+ box)){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
