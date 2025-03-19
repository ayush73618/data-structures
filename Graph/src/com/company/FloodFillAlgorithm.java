package com.company;

import java.util.Scanner;

public class FloodFillAlgorithm {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 //       int[][] arr = {{2,1,2,1,3},{2,3,3,3,2},{2,3,1,3,2},{1,2,3,2,2}};
        int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 0;
        int sc = 0;
        int newColor = 2;

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                arr[i][j] = scan.nextInt();
//            }
//        }

        floodFill(arr,sr,sc,newColor);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }


    public static void floodFill(int[][] arr,int sr,int sc,int newColor){  //Space complexity -- O(N)(M) + O(N)(M);
        int[][] visited = new int[arr.length][arr[0].length];              //Time Complexity --- O(N)XO(M)X4---because every node is traversing 4 times.
                    dfs(arr, sr, sc , newColor,visited,arr[sr][sc]);
    }

    public static void dfs(int[][] arr,int sr,int sc,int newColor,int[][] visited,int initialColor){
        arr[sr][sc] = newColor;
        int n = arr.length;
        int m = arr[0].length;
        visited[sr][sc] = 1;
        for(int k=-1;k<=1;k++){
            for(int j=-1;j<=1;j++){
                int trow=sr+k;
                int tcol=sc+j;
                if((k==0 || j ==0) && trow>=0 && tcol>=0 && trow<n && tcol<m && visited[trow][tcol] !=1 && arr[trow][tcol] ==initialColor){

                    dfs(arr,trow,tcol,newColor,visited,initialColor);
                   
                }
            }
        }

    }
}
