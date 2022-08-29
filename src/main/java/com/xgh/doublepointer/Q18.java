package com.xgh.doublepointer;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author xgh 2022/8/24
 */
public class Q18 {
    @Test
    public void test() {
        long start = System.currentTimeMillis();
        System.out.println(fourSum(new int[]{-500, -481, -480, -469, -437, -423, -408, -403, -397, -381, -379, -377, -353, -347, -337, -327, -313,
                -307, -299, -278, -265, -258, -235, -227, -225, -193, -192, -177, -176, -173, -170, -164, -162, -157, -147, -118, -115, -83, -64, -46, -36,
                -35, -11, 0, 0, 33, 40, 51, 54, 74, 93, 101, 104, 105, 112, 112, 116, 129, 133, 146, 152, 157, 158, 166, 177, 183, 186, 220, 263, 273, 320, 328, 332,
                356, 357, 363, 372, 397, 399, 420, 422, 429, 433, 451, 464, 484, 485, 498, 499}, 2139));
        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        System.out.println(fourSum2(new int[]{-500, -481, -480, -469, -437, -423, -408, -403, -397, -381, -379, -377, -353, -347, -337, -327, -313,
//                -307, -299, -278, -265, -258, -235, -227, -225, -193, -192, -177, -176, -173, -170, -164, -162, -157, -147, -118, -115, -83, -64, -46, -36,
//                -35, -11, 0, 0, 33, 40, 51, 54, 74, 93, 101, 104, 105, 112, 112, 116, 129, 133, 146, 152, 157, 158, 166, 177, 183, 186, 220, 263, 273, 320, 328, 332,
//                356, 357, 363, 372, 397, 399, 420, 422, 429, 433, 451, 464, 484, 485, 498, 499}, 2139));
//        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(fourSum3(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
        System.out.println(1000000000+1000000000+1000000000+1000000000);
        System.out.println(System.currentTimeMillis() - start);
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums==null||nums.length<4){
            return list;
        }
        outi:
        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                if (i >= nums.length - 4) {
                    break outi;
                }
                i++;
            }
            outj:
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j > i+1 && nums[j] == nums[j - 1]) {
                    if (j >= nums.length - 3) {
                        break outj;
                    }
                    j++;
                }
                outk:
                for (int k = j + 1; k < nums.length - 1; k++) {
                    while (k > j+1 && nums[k] == nums[k - 1]) {
                        if (k >= nums.length - 2) {
                            break outk;
                        }
                        k++;
                    }
                    outl:
                    for (int l = k + 1; l < nums.length; l++) {
                        while (l > k+1 && nums[l] == nums[l - 1]) {
                            if (l >= nums.length-1) {
                                break outl;
                            }
                            l++;
                        }
                        if (((long)nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                            list.add(Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l] ));
                        }
                    }
                }
            }
        }
        return list;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }


    /**
     * 暴力递归 超时
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        check(new ArrayList<>(), 0, 0, nums, list, target);
        return list;
    }

    public void check(List<Integer> values, int sum, int nidx, int[] org, List<List<Integer>> list, int target) {
        if (sum > target) {
            return;
        }
        if (values.size() == 4 && sum == target) {
            if (!exist(list, values)) {
                list.add(values);
            }
        } else if (values.size() > 4) {
            return;
        } else {
            if (nidx <= org.length - 1) {
                check(new ArrayList<>(values), sum, nidx + 1, org, list, target);
                ArrayList<Integer> arrayList = new ArrayList<>(values);
                arrayList.add(org[nidx]);
                check(arrayList, sum + org[nidx], nidx + 1, org, list, target);

            } else {
                return;
            }
        }
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
