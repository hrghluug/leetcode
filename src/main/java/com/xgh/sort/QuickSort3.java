package com.xgh.sort;

import static com.xgh.sort.IntArrays.swap;

/**
 * @author xgh 2023/8/30
 */
public class QuickSort3 {
    public static final int[] arr = new int[2];

    public static void main(String[] args) {
        //        int[] nums = new int[]{5864,-12333,4151,-6239,-10306,10866,-7013,8};
        int[] nums = IntArrays.sampleB();
        long s = System.currentTimeMillis();
        sort(nums, 0, nums.length - 1);
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }

    public static void sort(int[] nums, int begin, int end) {
        if (end > begin) {
            partition(nums, begin, end);
            sort(nums, begin, arr[0] - 1);
            sort(nums, arr[1] + 1, end);
        }
    }

    public static void partition(int[] nums, int begin, int end) {
        int r = end - 1;
        for (int i = begin; i <= r; i++) {
            if (nums[i] > nums[end]) {
                swap(nums, i--, r--);
            }
        }
        swap(nums, ++r, end);
        int le = r;
        int re = r;
        while (le > begin && nums[r] == nums[--le]) ;
        while (re < end && nums[r] == nums[++re]) ;
        arr[0]=++le;
        arr[1]=--re;
    }

}
