package com.company;

public class SetMatixToZero {
    public static void setMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int col0=1;
        for(int i =0;i<n;i++){
            if(arr[i][0]==0){
                col0=0;
            }
            for(int j =1;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][0]=arr[0][j] = 0;
                }
            }
        }

        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=1;j--){
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j] = 0;
                }
            }
            if(col0==0){
                arr[i][0]=0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setMatrix(arr);
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }

    }
}
