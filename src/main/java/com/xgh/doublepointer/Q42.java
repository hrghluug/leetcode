package com.xgh.doublepointer;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderElementImpl;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xgh 2022/8/29
 */
public class Q42 {
    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 动态规划 算出当前左边最大和右边最大
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i > 0) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i < height.length - 1) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (Math.min(leftMax[i], rightMax[i]) - height[i] > 0) {
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return sum;
    }

}
