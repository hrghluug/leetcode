package com.xgh.doublepointer;

import java.util.Arrays;

/**
 * @author xgh 2022/8/29
 */
public class Q88 {
    public void q88(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
