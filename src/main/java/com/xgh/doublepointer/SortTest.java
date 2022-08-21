package com.xgh.doublepointer;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author xgh 2022/8/21
 */
public class SortTest {
    @Test
    public void adasd() {
        _q215(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    /**
     * 用小根堆 java api
     *
     * @param nums
     * @param k
     * @return
     */
    public int q215(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public int _q215(int[] nums, int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (size < k) {
                put(arr, nums[i], size);
                size++;
            } else {
                if (arr[0] < nums[i]) {
                    replace(arr, nums[i]);
                }
            }
        }
        return arr[0];
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void put(int[] arr, int a, int size) {
        arr[size] = a;
        fixUp(arr, size);
    }

    public void fixUp(int[] arr, int idx) {
        while (idx > 0) {
            if (arr[(idx - 1) / 2] > arr[idx]) {
                swap(arr, (idx - 1) / 2, idx);
                idx = (idx - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void replace(int[] arr, int a) {
        arr[0] = a;
        fixDown(arr);
    }

    public void fixDown(int[] arr) {
        int parent = 0;
        int minSonIdx = 0;
        while ((minSonIdx + 1) * 2 < arr.length) {
            if (arr[(minSonIdx + 1) * 2] < arr[(minSonIdx + 1) * 2 - 1]) {
                minSonIdx = (minSonIdx + 1) * 2;
            } else {
                minSonIdx = (minSonIdx + 1) * 2 - 1;
            }
            if (arr[minSonIdx] >= arr[parent]) {
                break;
            } else {
                swap(arr, minSonIdx, parent);
                parent = minSonIdx;
            }
        }
        if ((minSonIdx + 1) * 2 - 1 < arr.length) {
            minSonIdx = (minSonIdx + 1) * 2 - 1;
            if (arr[minSonIdx] < arr[parent]) {
                swap(arr, minSonIdx, parent);
            }
        }
    }

    @Test
    public void aasd() {
        q347(new int[]{1, 1, 1, 2, 2, 3}, 1);
    }

    public int[] q347(int[] nums, int k) {
        HashMap<Integer, AtomicInteger> map = new HashMap<>();
        for (int num : nums) {
            map.computeIfAbsent(num, key -> new AtomicInteger()).incrementAndGet();
        }
        PriorityQueue<Map.Entry<Integer, AtomicInteger>> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.getValue().get()));
        map.entrySet().forEach(
                entry->{
                    if (queue.size()<k) {
                        queue.add(entry);
                    }else {
                        if (queue.peek().getValue().get()<entry.getValue().get()){
                            queue.poll();
                            queue.add(entry);
                        }
                    }
                }
        );
        List<Integer> integerList = queue.stream().map(entry -> entry.getKey()).collect(Collectors.toList());
        int[] ints = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            ints[i]=integerList.get(i);
        }
        return ints;
    }

}
