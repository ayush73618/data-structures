package com.company;

public class NoOfTimesLeftSumEqualRightSum {
    public static void main(String[] args) {

        int[] arr = {1,2,3,6,12};
        System.out.println(isLeftSumEqualRightSum(arr));
    }

    public static int isLeftSumEqualRightSum(int[] arr){

        int totalSum = 0;
        for(int i =0;i<arr.length;i++){
            totalSum += arr[i];
        }

        int leftSum = 0;
        int count = 0;
        for(int i =0;i<arr.length;i++){
            leftSum +=arr[i];

            int rightSum = totalSum-leftSum;

            if(leftSum==rightSum){
               count++;
            }
        }


        return count;
    }
}
