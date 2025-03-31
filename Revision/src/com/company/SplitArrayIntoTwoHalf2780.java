package com.company;

import java.util.HashMap;
import java.util.List;

public class SplitArrayIntoTwoHalf2780 {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (right.containsKey(num)) {
                right.put(num, (right.get(num) + 1));
            } else {
                right.put(num, 1);
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (left.containsKey(num)) {

                left.put(num, (left.get(num) + 1));
            } else {
                left.put(num, 1);
            }


            right.put(num, (right.get(num) - 1));

            int lenLeft = i + 1;
            int lenRight = nums.size() - i - 1;

            if (2 * left.get(num) > lenLeft && 2 * right.get(num) > lenRight) {
                return i;
            }

        }


        return -1;

    }

    public static  int boyerMooreVotingAlgorithm(List<Integer> nums){

        int maxElement = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                maxElement = nums.get(i);
                count = 1;

            } else if (nums.get(i) == maxElement) {
                count++;
            } else {
                count--;
            }


        }


        count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == maxElement) {
                count++;

            }
        }

        System.out.println(maxElement + " " + count);
        int tot = 0;
        for (int i = 0; i < nums.size(); i++) {

            if (nums.get(i) == maxElement) {
                tot += 1;
                count = count - 1;
            }

            if (2 * tot > i + 1 && 2 * count > nums.size() - i - 1) {
                return i;
            }

        }

        return -1;



    }
    public static void main(String[] args) {

        //Question is Simple need to split two array where count of a number x will be more than
        // half of length of left side of split array and same number will be more than half of length
        // on the right side of array
        // ex --- [1,2,2,2] now here left=[1,2,2] and right=[2];
        // 2 in left side occurred 2 times so 2 * 2 > length of left =3 and same 2 occur 1 time on right side
        // so 2*1 > 1 that why 2 will be the answer here 2 is index where we have split the array not the number


    }
}
