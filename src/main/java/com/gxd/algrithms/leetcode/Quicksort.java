package com.gxd.algrithms.leetcode;

import java.util.Arrays;

/**
 * Created by gxdgodgxd on 16/8/30.
 */

public class Quicksort {

    public static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = mypartition(array, start, end);
            quicksort(array, start, pivot - 1);
            quicksort(array, pivot + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int p = array[start];
        int i = start;
        int temp;
        for (int j = start + 1; j <= end; j++) {
            if (array[j] < p) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i];
        array[i] = array[start];
        array[start] = temp;
        return i;
    }

    private static int mypartition(int[] array, int start, int end) {
        int p = array[start];
        int i = start, j = end;
        int temp;
        while (i < j) {
            while (i<j && array[j] > p) {
                j--;
            }
            if (i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
            while (i < j && array[i] < p) {
                i++;
            }
            if (i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
        }
        array[i] = p;
        return i;
    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 2, 9};
        System.out.println(Arrays.toString(a));
        Quicksort.quicksort(a);
        System.out.println(Arrays.toString(a));
    }
}

