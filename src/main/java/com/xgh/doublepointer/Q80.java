package com.xgh.doublepointer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * @author xgh 2022/8/29
 */
public class Q80 {
    @Test
    public void test(){
        int[] ints = {1, 1, 1, 2, 2, 3};
        removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
    }
    public int removeDuplicates(int[] nums) {
        int p=0;
        for (int i = 0; i < nums.length; i++) {
           if (p>1&&nums[i]==nums[p-1]&&nums[i]==nums[p-2]){
               continue;
           }
           nums[p++]=nums[i];
        }
        return p;
    }
}
