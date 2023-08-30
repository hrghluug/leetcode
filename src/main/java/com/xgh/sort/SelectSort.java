package com.xgh.sort;

/**
 * @author xgh 2023/8/24
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = IntArrays.sampleB();
        long s = System.currentTimeMillis();
        int length = nums.length - 1;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length + 1; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            IntArrays.swap(nums,min,i);
        }
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }
}
