package com.xgh.doublepointer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xgh 2022/8/29
 */
public class Q31 {
    @Test
    public void test() {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 找到最后一组升序的,前一个与后面序列中较大于该数进行交换,
     * 然后对后面序列进行升序排列,由于该序列为降序,翻转即可
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int r = nums.length - 1;
        while (r != 0) {
            if (nums[r - 1] >= nums[r]) {
                r--;
            } else {
                int biggerIdx=nums.length - 1;
                while (nums[biggerIdx]<=nums[r-1]){
                    biggerIdx--;
                }
                int temp = nums[biggerIdx];
                nums[biggerIdx] = nums[r - 1];
                nums[r - 1] = temp;
                reverse(nums,r,nums.length-1);
                return;
            }
        }
        reverse(nums,0,nums.length-1);
    }


    private void reverse(int[] nums,int l ,int r) {
        int temp;
        while (r > l) {
            temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
