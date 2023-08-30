package com.xgh.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xgh 2023/8/24
 */
public class IntArrays {

    public static int[] sample() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\git\\leetcode\\src\\main\\java\\com\\xgh\\sort\\A.txt"));

            List<String> list = reader.lines().collect(Collectors.toList());
            int[] ints = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ints[i] = Integer.parseInt(list.get(i));
            }
            return ints;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    public static int[] sampleB() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\git\\leetcode\\src\\main\\java\\com\\xgh\\sort\\B.txt"));

            List<String> list = reader.lines().collect(Collectors.toList());
            int[] ints = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ints[i] = Integer.parseInt(list.get(i));
            }
            return ints;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    public static int[] sampleC() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\git\\leetcode\\src\\main\\java\\com\\xgh\\sort\\C.txt"));

            List<String> list = reader.lines().collect(Collectors.toList());
            int[] ints = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ints[i] = Integer.parseInt(list.get(i));
            }
            return ints;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void ascSorted(int[] nums) {
        if (nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
