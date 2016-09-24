package com.gxd;

import java.util.Arrays;

/**
 * Created by gxdgodgxd on 16/8/31.
 */
public class Mergesort {

    public static void mergesort(int[] a) {
        mergesort(a, 0, a.length - 1);
    }

    private static void mergesort(int[] a, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergesort(a,start, mid);
            mergesort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[a.length];
        for (int i = start; i <= end; i++) {
            temp[i] = a[i];
        }
        int i=start,j=mid+1,k=start;
        while (i <= mid && j <= end) {
            if (temp[i] <= temp[j]) {
                a[k] = temp[i++];
            }else{
                a[k] = temp[j++];
            }
            k++;
        }
        while (i <= mid) {
            a[k++] = a[i++];
        }
        while (j <= end) {
            a[k++] = a[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 2, 5, 7, 0, 9};
        System.out.println(Arrays.toString(a));
        Mergesort.mergesort(a);
        System.out.println(Arrays.toString(a));
    }
}
