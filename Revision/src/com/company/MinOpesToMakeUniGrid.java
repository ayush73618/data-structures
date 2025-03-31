package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinOpesToMakeUniGrid {
    public int minOperations(int[][] grid, int x) {

        int diff = grid[0][0] %x;
        int gridElement = 0;
        int max = Integer.MAX_VALUE;

        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                gridElement = grid[i][j];
                if(gridElement%x != diff){
                    return -1;
                }
                int sum =0;
                for(int k =0;k<grid.length;k++){
                    for(int l =0;l<grid[k].length;l++){
                        sum += Math.abs((grid[k][l]-gridElement))/x ;
                    }
                }

                max = Math.min(sum,max);

            }
        }


        return max;

        //time complexity --- O(n.m)^2;
        //Space Complexity --- O(1);
    }

    public int TimeOptimizedMinOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int max =0;
        int diff = grid[0][0]%x;
        for(int[] i : grid){
            for(int j:i){
                if(j%x != diff) return -1;
                list.add(j);
            }
        }


        Collections.sort(list);
        int med = list.get(list.size()/2);

        for(int val : list){
            max += Math.abs(val-med) /x;
        }


        return max;

        //time complexity --- O(n.m log(n.m));
        //Space Complexity --- O(n.m);
    }

    //Another one

    public int AnotherminOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int max =Integer.MAX_VALUE;
        int diff = grid[0][0]%x;
        for(int[] i : grid){
            for(int j:i){
                if(j%x != diff) return -1;
                list.add(j);
            }
        }


        Collections.sort(list);
        // int med = list.get(list.size()/2);
        int pref = 0;
        int sum = 0;

        for(int val : list){
            sum +=val;
            //  max += Math.abs(val-med) /x;
        }

        int i =0;
        for(int val : list){
            int left = ((i*val)-pref)/x;
            int right = ((sum - ((list.size()-i)*val + pref ))/x);
            max = Math.min((left+right),max);

            pref +=val;
            i++;
        }

        //Here process is very simple -- get the leftSum now convert all element to left side of current Element need an operation
        // i * values - prefix divided by x so let's say 2,4,6,8,10 now we are at level 6 now to convert all element to the left of 6
        // that is 2 and 4 what we need prefix sum is 6 and i = 2 so 2*6 - 6 and divided by x let's say 2 so total is 3
        // Now for the right side total sum - (totalelement on the right including currentelement * value + prefix) divided by x
        // so here sum is 30 - (3 * 6 - 6) which is 6 and 6 divide by x which is 2 is 3 so total operation will be 6 .
        // we will see for all element like this and get the min value;

        return max;

        //time complexity --- O(n.m log(n.m));
        //Space Complexity --- O(n.m);
    }
    public static void main(String[] args) {
        // Given an 2D array need to find minimum operation , so that all element are equal ,
       // given a value x - either you can add or subtract x from grid element any no. of time.


    }
}
