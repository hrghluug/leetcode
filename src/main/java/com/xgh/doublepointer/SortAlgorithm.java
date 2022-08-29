package com.xgh.doublepointer;

/**
 * @author xgh 2022/8/29
 */
public class SortAlgorithm {
    public void quickSort(int[] arr, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int temp;
        int l1 = l, r1 = r;
        int mid = arr[l];
        while (r != l) {
            if (arr[l + 1] >= mid) {
                temp = arr[l + 1];
                arr[l + 1] = arr[r];
                arr[r] = temp;
                r--;
            } else {
                temp = arr[l];
                arr[l] = arr[l + 1];
                arr[l + 1] = temp;
                l++;
            }
        }
        quickSort(arr, l1, l);
        quickSort(arr, l + 1, r1);
    }
}
