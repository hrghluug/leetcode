package com.xgh.sort;

import static com.xgh.sort.IntArrays.swap;

/**
 * @author xgh 2023/8/24
 */
public class QuickSort {
    public static void main(String[] args) {
        //        int[] nums = new int[]{5864,-12333,4151,-6239,-10306,10866,-7013,8};
        int[] nums = IntArrays.sampleB();
        long s = System.currentTimeMillis();
        sort(nums, 0, nums.length - 1);
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }

    private static void sort(int[] nums, int begin, int end) {
        if (end > begin) {
            int mid = partition(nums, begin, end);
            sort(nums, begin, mid - 1);
            sort(nums, mid + 1, end);
        }
    }

    private static int partition(int[] nums, int begin, int end) {
        int mid = nums[end];
        int r = end - 1;
        for (int i = begin; i <= r; i++) {
            if (nums[i] > mid) {
                swap(nums, i--, r--);
            }
        }
        swap(nums, ++r, end);
        return r;
    }

}
