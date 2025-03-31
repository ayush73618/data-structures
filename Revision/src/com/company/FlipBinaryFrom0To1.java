package com.company;

public class FlipBinaryFrom0To1 {
    public static int flip(int[] nums){
        int count =0;
        int len = nums.length;

        for(int i =0;i<len-2;i++){
            if(nums[i]==0){
                nums[i]=1-nums[i];
                nums[i+1] = 1-nums[i+1];
                nums[i+2] = 1-nums[i+2];
                count++;
            }
        }

        if(nums[len-1]==0 || nums[len-2]==0){ // since all will be one if it's possible if not then either of last 2 will be 0 
            return -1;
        }

        return count;
    }
    public static void main(String[] args) {

        //Question flip 3 consecutive index if from 0 to 1 or 1 to 0 and check at last we can convert this array into all 1
        // ,if yes return number of minimum operation else -1
        System.out.println(flip(new int[]{1,0,0,0}));
    }
}
