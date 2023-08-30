package com.xgh.sort;

import static com.xgh.sort.IntArrays.swap;

/**
 * @author xgh 2023/8/30
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = IntArrays.sampleC();
        long s = System.currentTimeMillis();
        sort(nums);
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }

    public static void sort(int[] nums) {
        int gap =getGap(nums.length);
        do {
            for (int i = gap; i < nums.length; i += gap) {
                for (int j = i; j > 0 && nums[j] < nums[j - gap]; j -= gap) {
                    swap(nums, j - gap, j);
                }
            }
        } while ((gap /= 2) > 0);
    }

    public static int getGap(int len) {
        int gap = 1;
        while ((gap <<= 1) <= len) ;
        return (gap >> 1) - 1;
    }
}
