package com.xgh.doublepointer;

import org.junit.Test;

/**
 * @author xgh 2022/8/22
 */
public class Q11 {
    @Test
    public void maina() {
        int[] ints = {1, 2, 3, 4, 5, 25, 24, 3, 4};
        System.out.println(maxArea(ints));
    }

    /**
     * 时间复杂度高
     *
     * @param height
     * @return
     */
    @Deprecated
    public int maxArea2(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, calcArea(height, i, j));
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int max = calcArea(height, l, r);
        while (r > l) {
            if (height[l]>height[r]){
                r--;
            }else {
                l++;
            }
            max=Math.max(max,calcArea(height,l,r));
        }
        return max;
    }

    public int calcArea(int[] height, int l, int r) {
        return (r - l) * Math.min(height[l], height[r]);
    }
}
