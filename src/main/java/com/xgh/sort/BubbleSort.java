package com.xgh.sort;

/**
 * @author xgh 2023/8/24
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = IntArrays.sampleB();
        long s = System.currentTimeMillis();
        int length = nums.length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    IntArrays.swap(nums, j, j + 1);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }


}
