package com.company.tree;

public class Heap {

    private static  int currentSize=0;

    public static int insertInHeap(int[] arr,int n){
        if(arr.length ==currentSize){
            return currentSize;
        }
        arr[currentSize++] = n;

        int i = currentSize-1;
        while(i>0){
            int swapIndex = (i-1)/2;

            if(arr[i] > arr[swapIndex]){
                int temp = arr[i] ;
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
                i = swapIndex;
            }
            else{
               return currentSize;

            }
        }

        return currentSize;

    }

    public static int delete(int[] arr){
        //We should delete root element
        // Add last element to root element and then heapify according to your need min-heap or max-heap
        //so we will compare till the last element ;

        //Time complexity == O(log n);
        int root = arr[0];
        arr[0] = arr[--currentSize];
        int i = 0;
        while(i<currentSize) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < currentSize && arr[left] > arr[largest]) {
                largest = left;
            }

            // Check if right child exists and is greater
            if (right < currentSize && arr[right] > arr[largest]) {
                largest = right;
            }

            // If largest is still parent, heap is valid
            if (largest == i) {
                break;
            }

            // Swap with larger child
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            i = largest;
        }


            return root;

    }
    public static void main(String[] args) {
        //HEAP
        //A heap is a complete binary tree that satisfies the heap property.
        // A complete binary tree is a binary tree in which all levels are completely
        // filled except possibly the last, which is filled from left to right.
        // This structure allows a heap to be efficiently represented using an array.

        //Time Taken for insertion is equal to height of a heap tree that is O(log n)
        //{50,30,20,15,10,8,16}
        int[] arr = new int[20];
        arr[0] = 50;
        arr[1] = 30;
        arr[2] = 20;
        arr[3] = 15;
        arr[4] = 10;
        arr[5] = 8;
        arr[6] = 16;

        currentSize = 7;

        int n = 60;

        int m = insertInHeap(arr,n);

       for(int i = 0; i<m;i++){
           System.out.print(arr[i]+" ");
       }

        System.out.println();

       int highest = delete(arr);

//        for(int i = 0; i<currentSize;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        highest = delete(arr);
//
//        for(int i = 0; i<currentSize;i++){
//            System.out.print(arr[i]+" ");
//        }
//
//        System.out.println();
//        highest = delete(arr);
//
//        for(int i = 0; i<currentSize;i++){
//            System.out.print(arr[i]+" ");
//        }

        int[] maxHeap = new int[currentSize];

        System.out.println();
        int j = currentSize;
        //Time complexity O(nlog(n))
        //space is O(n);
        //since we are deleting the highest everytime so we can store it in some new array in last available space
        //it will be in ascending order;
        for(int i = j-1;i>=0;i--){
            maxHeap[i] = delete(arr);

        }

        for(int i = 0; i<maxHeap.length;i++){
            System.out.print(maxHeap[i]+" ");
        }

    }
}
