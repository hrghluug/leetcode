package com.xgh.sort;

/**
 * @author xgh 2023/8/24
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = IntArrays.sampleC();
        long s = System.currentTimeMillis();
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                IntArrays.swap(nums, j, j - 1);
            }
        }
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }
}
