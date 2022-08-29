package com.xgh.doublepointer;

/**
 * @author xgh 2022/8/29
 */
public class Q167 {
    public  int[] q167(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (r > l) {
            if (arr[l] + arr[r] > target) {
                r--;
            }
            if (arr[l] + arr[r] < target) {
                l++;
            }
            if (arr[l] + arr[r] == target) {
                return new int[]{l + 1, r + 1};
            }
        }
        return null;
    }
}
