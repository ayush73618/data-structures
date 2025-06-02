package com.company;

public class TWOSUM_II {

    public  static  int[] two_Sum(int[] numbers,int target){
        int i =0,j=numbers.length-1;
        int[] res = new int[2];
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum==target){
                res[0]=i+1;
                res[1]=j+1;

                break;
            }
            else if(sum>target){
                j--;

            }
            else{
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // return indexes 1-based indexing when you find two indexed in array which sum is equal to target
        //arr[] = {1,6,8,10};
        //target = 14;
        //output =[2,3]
        
    }
}
