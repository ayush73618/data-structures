package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class KnpSack01 {
;
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter no. of Element");
//        int n = sc.nextInt();
//        System.out.println("Enter total Weight");
//        int tot= sc.nextInt();

        int tot = 7;

        int[] value = new int[]{10,8,6};
        int[] weight = new int[]{1,7,9};
        int n = weight.length;
        int[][] dp = new int[n+1][tot+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(knapSackWithMemoization(weight,value,tot,n,dp));
    }

    public static int knapSackWithoutMemoization(int weight[], int value[], int totalWeight,int n) {
        if (n <= 0 || totalWeight <= 0) {
            return 0;
        }


        if (weight[n - 1] <= totalWeight) {
            return Math.max((value[n - 1] + knapSackWithoutMemoization(weight, value, totalWeight - weight[n - 1], --n)), (knapSackWithoutMemoization(weight, value, totalWeight, --n)));
        } else {
            return knapSackWithoutMemoization(weight, value, totalWeight, --n);
        }

    }

    public static int knapSackWithMemoization(int weight[], int value[], int totalWeight,int n,int dp[][]){
        if(n<=0 || totalWeight<=0){
            return 0;
        }

        if(dp[n][totalWeight]!=-1){
            return dp[n][totalWeight];
        }

        if(weight[n-1] <=totalWeight) {
            return dp[n][totalWeight]=Math.max((value[n-1] + knapSackWithMemoization(weight,value,totalWeight-weight[n-1],n-1,dp)),(knapSackWithMemoization(weight,value,totalWeight,n-1,dp)));
        }
        else{
            return dp[n][totalWeight]=knapSackWithMemoization(weight,value,totalWeight,n-1,dp);
        }
    }
}
