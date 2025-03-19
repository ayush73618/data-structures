package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] arr = {{1,2,1},{1,1,0},{0,0,1}};
        int n = arr.length;
        int m = arr[0].length;
        //Space Complexity ----------- O(N)(M);
        //Time Complexity -------- 4 times O(N)(M);
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int countFresh =0;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(arr[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else{
                    visited[i][j] =0;
                }
                if(arr[i][j]==1){
                    countFresh++;
                }
            }
        }


        int tm =0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
    //    int count=0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().tm;
            tm = Math.max(tm,time);
            q.remove();
            for(int i =0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = col+dcol[i];

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]!=2 && arr[nrow][ncol]==1){
                    countFresh--;
                    arr[nrow][ncol]=2;
                    q.add(new Pair(nrow,ncol,++time));
                }
            }
        }

        if(countFresh !=0){
            System.out.println(-1);
        }

        else{
            System.out.println(tm);
        }
    }

    static class Pair{
        int row;
        int col;
        int tm;
        Pair(int row,int col,int tm){
            this.row=row;
            this.col=col;
            this.tm=tm;
        }
    }
}
