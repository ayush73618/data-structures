package com.company;

public class Candy135 {
    public static int countCandy(int[] ratings) {

        // ratings = {1,0,2};
        int n = ratings.length;
        int[] candies = new int[n];

        for(int i =0;i<candies.length;i++){
            candies[i] = 1;
        }

        //According to left neighbour

        for(int i= 1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        // now candies = {1,1,2};

        int totCandies = 0;
        //candies = {
        for(int i = n-1;i>0;i--){
            if(ratings[i-1]>ratings[i]){
                candies[i-1] = Math.max(candies[i]+1,candies[i-1]);
            }
            totCandies +=candies[i-1];

        }

        // candies = {2,1,2}

        totCandies +=candies[n-1];

        //Add last to totalCandies because right side candies start from n-1 but add i-1

        return totCandies;
    }

    public static void main(String[] args) {

        System.out.println(countCandy(new int[]{1,0,2}));
    }
}
