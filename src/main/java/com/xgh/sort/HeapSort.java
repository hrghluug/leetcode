package com.xgh.sort;

import static com.xgh.sort.IntArrays.swap;

/**
 * @author xgh 2023/8/30
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = IntArrays.sample();
        long s = System.currentTimeMillis();
        sort(nums);
        System.out.println(System.currentTimeMillis() - s);
        IntArrays.ascSorted(nums);
    }

    public static void sort(int[] nums) {
        init(nums);
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    public static void init(int[] nums) {
        for (int i = nums.length / 2; i > 0; i--) {
            heapify(nums, i - 1, nums.length);
        }
    }

    public static void heapify(int[] nums, int idx, int len) {
        int left = (idx + 1) * 2 - 1;
        int right = (idx + 1) * 2;
        int largest = idx;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != idx) {
            swap(nums, idx, largest);
            heapify(nums, largest, len);
        }
    }
}
