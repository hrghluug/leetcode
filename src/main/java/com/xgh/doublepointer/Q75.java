package com.xgh.doublepointer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xgh 2022/8/29
 */
public class Q75 {
    @Test
    public void test(){
        int[] ints = { 0};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }
    public void sortColors(int[] nums) {
        int a=0,b=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]==0){
                if (i==a){
                    break;
                }
                swap(nums,i,a);
                a++;
            }
        }
        for (int i = a; i < b; i++) {
            while (nums[i]==2){
                if (i==b){
                    break;
                }
                swap(nums,i,b);
                b--;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
