package com.company;

public class CountDaysWithoutMeeting3169 {
    public static int countDays(int days, int[][] meetings) {
        int[] arr = new int[days+1];
        int prevStart = 0;
        int prevEnd = 0;
         for(int i =0;i<meetings.length;i++){
             int a = meetings[i][0];
             int b = meetings[i][1];

              for(int j=a;j<=b;j++){
                  if(arr[j] !=1){
                      arr[j] =1;
                  }
              }
         }

         int count =0;

         for(int i =1;i<arr.length;i++){
             if(arr[i]!=1){
                 count++;
             }
         }

        return count;

    }

    public static int countDaysOptimized(int days, int[][] meetings) {
        int[] arr = new int[days+1];
        int prevStart = 0;
        int prevEnd = 0;
        for(int i =0;i<meetings.length;i++){
            int a = meetings[i][0];
            int b = meetings[i][1];

            if(prevEnd >0 && prevStart>0){
                if(a<prevStart && b <prevEnd && b > prevStart){
                    days -=prevStart-a;
                }

            }else{
                days = b-a+1;
            }


        }

        int count =0;

        for(int i =1;i<arr.length;i++){
            if(arr[i]!=1){
                count++;
            }
        }

        return count;

    }
    public static void main(String[] args) {

        int days =10;
        int[][] arr = new int[][]{{5,7},{1,3},{9,10}};

        System.out.println(countDays(days,arr));

    }
}
