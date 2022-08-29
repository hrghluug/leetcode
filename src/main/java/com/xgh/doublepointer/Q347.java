package com.xgh.doublepointer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author xgh 2022/8/29
 */
public class Q347 {
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
