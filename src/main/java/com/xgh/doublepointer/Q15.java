package com.xgh.doublepointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author xgh 2022/8/24
 */
public class Q15 {
    @Test
    public void test(){
        //        System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));
        //        System.out.println(threeSum(new int[]{0,0,0,0,0,0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int l = 0, r = nums.length - 1;
            while (r > i && i > l) {
                sum = nums[l] + nums[i] + nums[r];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[l], nums[i], nums[r]);
                    if (!exist(lists, list)) {
                        lists.add(list);
                    }
                    r--;
                    l++;
                } else if (sum > 0) {
                    if (--r == i) {
                        break;
                    }
                } else {
                    if (++l == i) {
                        break;
                    }
                }
            }
        }
        return lists;
    }

    private boolean exist(List<List<Integer>> lists, List<Integer> list) {
        mark:
        for (List<Integer> integers : lists) {
            for (int i = 0; i < integers.size(); i++) {
                if (!Objects.equals(list.get(i), integers.get(i))) {
                    continue mark;
                }
            }
            return true;
        }
        return false;
    }
}
