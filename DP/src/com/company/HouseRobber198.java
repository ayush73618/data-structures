package com.company;

public class HouseRobber198 {

    public int rob(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }
    public static void main(String[] args) {
        //Question is that when you have to rob maximum house but not adjacent like if you robbed 1 then not 2 may be 3
        // or 4 so maximum you can rob

        //ex - [1,2,3,1] -- output will be 4 rob 1st and 3rd will give you highest
        // [2,7,3,1,4,2,1,8] -- here you will loot 2nd 5th and last will give you highest 19;
    }
}
