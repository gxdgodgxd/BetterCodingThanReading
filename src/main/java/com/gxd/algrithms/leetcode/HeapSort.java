package com.gxd.algrithms.leetcode;

/**
 * Created by gxdgodgxd on 17/1/9.
 */
public class HeapSort {

    public void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        buildMaxHeap(arr);

        for(int i=arr.length-1;i>0;i--) {
            arraySwap(arr, 0, i);
            maxHeap(arr, i, 0);
        }

    }

    private void buildMaxHeap(int[] arr) {
        for(int i = arr.length/2;i>=0;i--) {
            maxHeap(arr,arr.length,i);
        }

    }

    public void maxHeap(int[] arr, int heapSize, int index) {
        int left = index*2+1;
        int right = index*2+2;

        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (index != largest) {
            arraySwap(arr,index,largest);
            maxHeap(arr,heapSize,largest);
        }


    }

    public void arraySwap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

        System.out.println("Before heap:");
        heapSort.printArray(array);

        heapSort.heapSort(array);

        System.out.println("After heap sort:");
        heapSort.printArray(array);
    }
}
