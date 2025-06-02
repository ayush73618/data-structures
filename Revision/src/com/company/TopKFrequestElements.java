package com.company;

import java.util.*;

public class TopKFrequestElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        List<Map.Entry<Integer,Integer>> list = sortByValue(map);
        System.out.println(list);
        int[] arr = new int[k];
        int j =0;
        int i =0;
        for(Map.Entry<Integer,Integer> m : list){
            if(j<k){
                arr[i++] = (int)m.getKey();
            }
            j++;
        }

        return arr;
    }

    public static List<Map.Entry<Integer, Integer>> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (i1, i2) -> i2.getValue().compareTo(i1.getValue()));

        return list;
    }


    public static int[] usingBucketSort(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucketList = new List[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            bucketList[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            bucketList[(int)m.getValue()].add(m.getKey());
        }

        int[] ans = new int[k];
        int m =0;

        for(int i =bucketList.length-1;i>=0 && m<k ;i--){
            if(!bucketList[i].isEmpty()){
                for(int j:bucketList[i]){
                    ans[m++] = j;
                }
            }

        }

        return ans;


    }


    public static void main(String[] args) {
        // arr = [1,3,2,1,2,1] k = 2 so we need to return 2 element which have highest frequency if
        //here 1 has appeared 3 times and 2 2 times  so answer will be 1 and 2;
        // so answer will be [1,2]
    }
}
