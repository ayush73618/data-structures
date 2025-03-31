package com.company;

public class ProductOfArrayExceptItself238 {

    public static int[] productExceptSelfBruteForce(int[] nums){
        int[] ans = new int[nums.length];

        for(int i =0;i< nums.length;i++){
            int prod = 1;
            for(int j =0 ;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                else{
                    prod *=nums[j];
                }
            }

            ans[i] = prod;
        }

        //Time = O(n^2)
        // space = O(1);

        return ans;
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for(int i =1;i<nums.length;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        for(int i = 0;i<nums.length;i++){
            nums[i] = prefix[i]*suffix[i];
        }

        return nums;

        //Time -- O(n)
        //space --- O(n);
    }

    public static int[] productExceptSelfSpaceOptimized(int[] nums){
        int[] ans = new int[nums.length];
        ans[0] = 1;
        ans[nums.length-1] =1;

        for(int i = 1;i<nums.length;i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        int suffix = 1;
        for(int i = nums.length-2;i>=0;i--){
            suffix *=nums[i+1];
            ans[i] *=suffix;
        }

        return ans;

        //Time - O(n);
        //Space -- O(1)
    }


    public static void main(String[] args) {

        int[] ans = new int[]{1,2,3,4};

      //  ans = productExceptSelfBruteForce(ans);
      //   ans = productExceptSelf(ans);
        ans = productExceptSelfSpaceOptimized(ans);

        for(int i = 0;i< ans.length;i++){
            System.out.print(ans[i]+" ");
        }



    }
}
