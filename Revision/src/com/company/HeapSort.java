package com.company;

public class HeapSort {

    public static void heapify(int[] arr,int n ,int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left <n && arr[left]>arr[largest]){
            largest = left;
        }
        if (right <n && arr[right] > arr[largest]){
            largest = right;

        }

        if(i !=largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr,n,largest);  //SubNode which has been changed only that should be heapify;
        }


    }

    public static  void heapSort(int[] arr,int n){

        for(int i = (n/2)-1;i>=0;i--){
            heapify(arr,n,i);  //Building an Heap take O(n)
        }

        for(int i = n-1;i>=0;i--){
            int temp = arr[0]; //for each swap take O(1) time and for n element it is O(n)
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,i,0); // O(log(n)
        }
    }

    public static void heapifyMin(int[] arr,int n ,int i){
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left <n && arr[left]<arr[smallest]){
            smallest = left;
        }
        if (right <n && arr[right] < arr[smallest]){
            smallest = right;

        }

        if(i !=smallest){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapifyMin(arr,n,smallest);  //SubNode which has been changed only that should be heapify;
        }


    }


   public static void heapSortMin(int[] arr ,int n ){
       for(int i = (n/2)-1;i>=0;i--){
           heapifyMin(arr,n,i);  //Building an Heap take O(n)
       }

       for(int i = n-1;i>=0;i--){
           int temp = arr[0]; //for each swap take O(1) time and for n element it is O(n)
           arr[0] = arr[i];
           arr[i] = temp;

           heapifyMin(arr,i,0); // O(log(n)
       }
   }
    public static void main(String[] args) {

        int[] arr = {3, 9, 4, 1, 2, 8, 10};

        heapSort(arr, arr.length); //overall O(n log(n)) //THis is for ascending order max element at last using max-heap

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        heapSortMin(arr,arr.length); //This is for descending order max element at last using max-heap
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
