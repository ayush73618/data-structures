package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {

    }
    public static void bfs(int row,int col,int[][] vis,char[][] grid){
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;

        while(!queue.isEmpty()){
            int row1 = queue.peek().first; //row1 and col1 is ensuring we are using latest queue addition
            int col1 = queue.peek().second;
            queue.remove();

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int trow = row1+i;
                    int tcol = col1+j;
                    //if(trow>=0 && tcol>=0 && trow<n && tcol<m && vis[trow][tcol] !=1 && grid[trow][tcol] =='1'){ //this condition is valid when we are considering all 8 neighbours including diagnals
                    if((i==0 || j ==0) && trow>=0 && tcol>=0 && trow<n && tcol<m && vis[trow][tcol] !=1 && grid[trow][tcol] =='1'){ // this condition is valid only when we were considering horizontal and vertical 1 not diagonal
                        //Here i==0 && j ==0 ensure that you are not going diagonally either you are in same row or same column;
                        vis[trow][tcol] = 1;
                        queue.add(new Pair(trow,tcol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        int[][] visited = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(visited[i][j] ==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,visited,grid);

                }  //Space Complexity --- O(N)(M) + O(N)(M) -- if all grid are 1
                // Time Complexity -- O(N)(M) + O(N)(M)
            }
        }
        return count;
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}


