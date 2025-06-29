package com.company;

public class RemoveDuplicateFromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;

        for(int i = 2;i<n;i++){
            if(nums[i] != nums[j-2]){ //check if last 2 element is same or not
                nums[j] = nums[i];//if not then replace j to current element i
                j++; // using this we will return a length  where every el ement will
                //appear at max 2 times;
            }


        }

        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        //output={1,1,2,2,3,...}

        //here you have to return an integer value which loop will run and in that all
        // the element should have appeared maximum of twice
        //so in above case 1 is 3 time but in output it should be 2 so total 5 element are
        //there which can be appeared 2 times or less than 2 time.
        //now after a j length no matter whatever you can return
    }
}
