package com.company;

public class ContainerWithMaximumWater11 {
    public int maxWaterContainerBruteForce(int[] height){
        int max = 0;

        for(int i = 0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int min = Math.min(height[i],height[j]);
                max = Math.max(max,min*(j-i));
            }

        }

        //Time = O(n^2);
        //space = O(1);

        return max;
    }

    public int maxWaterContainerOptimized(int[] height) {

        int max = 0;
        int l = 0;
        int r = height.length - 1;

        while(l<r){
            int current = Math.min(height[l],height[r])*(r-l);

            max  = Math.max(current,max);

            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return max;
        //Time = O(n);
        //space = O(1);

        //Two Pointer Approach
    }
        public static void main(String[] args) {

    }
}
