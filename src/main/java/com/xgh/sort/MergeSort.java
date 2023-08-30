package com.xgh.sort;

import java.util.Arrays;

/**
 * @author xgh 2023/8/24
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = IntArrays.sampleC();
        long s = System.currentTimeMillis();
        nums = sort(nums);
        System.out.println(System.currentTimeMillis() - s);
        int[] nums2 = IntArrays.sampleC();
        long s1 = System.currentTimeMillis();
        Arrays.sort(nums2);
        System.out.println(System.currentTimeMillis() - s1);
        IntArrays.ascSorted(nums);
    }


    public static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        return merge(sort(Arrays.copyOfRange(nums, 0, nums.length / 2)), sort(Arrays.copyOfRange(nums, nums.length / 2, nums.length)));
    }


    public static int[] merge(int[] left, int[] right) {
        int len = left.length + right.length;
        int[] res = new int[len];
        int l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (right[r] < left[l]) {
                res[r + l] = right[r++];
            } else {
                res[r + l] = left[l++];
            }
        }
        if (l < left.length) {
            System.arraycopy(left, l, res, r + l, left.length - l);
        }

        if (r < right.length) {
            System.arraycopy(right, r, res, l + r, right.length - r);
        }
        return res;
    }
}
