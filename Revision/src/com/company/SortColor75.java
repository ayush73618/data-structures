package com.company;

public class SortColor75 {
    public void sortColors(int[] nums) {
        int mid = 0;
        int low = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;

            }
        }



    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = {0,1,0,2,2,0,1}
        // output  = {0,0,0,1,1,2,2};

    }
}
