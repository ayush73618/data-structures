package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumOperationToMakeArrayUnique3396 {
    public int minimumOperationsOptimized(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = nums.length-1;i>=0;i--){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i])==2){
                return (i+3)/3;
            }
        }

        return 0;
        //Here we are using greedy Approach , start from last if found duplicate means need to remove till that element
        // Now let's say we are on index 5 means 6 element need to remove for that there is formula (i+3)/3 -- get that
        // ceil value here it will be 6 . here we are using i+3 becuase if there is only 1 element it will return 0 but it
        //is also an operation that's why .
    }

    public int minimumOperations(int[] nums) {
        int count = 0, temp;
        List<Integer> list = new ArrayList<>();
        for (int n : nums)
            list.add(n);
        while (true) {
            HashMap<Integer, Integer> mpp = new HashMap<>();
            temp = 0;
            for (int num : list)
                if (mpp.put(num, mpp.getOrDefault(num, 0) + 1) != null && mpp.get(num) == 2) //Add all in HasMap
                    temp++;
            if (temp == 0) // No duplicate found then break and return count;
                break;
            int removeCount = Math.min(3, list.size()); // Remove first 3 ;
            for (int i = 0; i < removeCount; i++)
                list.remove(0);
            count++;
            //Continue till all are unique
        }
        return count;
    }

    public static void main(String[] args) {
        // arr = [1,2,3,4,2,3,3,5,7]
        // Now you will remove 1st three element in one operation , return minimum no. of operation to make array distinct
        //Here output is 2 first remove -- 1,2,3 then remove 4,2,3 now remains [3,5,7] which is unique
    }
}
