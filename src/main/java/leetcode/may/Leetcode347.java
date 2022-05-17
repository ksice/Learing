package leetcode.may;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 最小堆
 *
 * @Version : 1.0
 * @Creation : 2022/5/17 下午2:45
 * @Author : ksice_xt
 */
public class Leetcode347 {

    public static void main(String[] args) {
        topKFrequent(new int[]{1}, 1);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++orDefault);
        }

        Set<Integer>[] list = new Set[nums.length + 1];

        //桶排序，用空间换时间
        for (int i = 0; i < nums.length; i++) {

            Integer integer = map.get(nums[i]);
            if (list[integer] == null) {
                list[integer] = new HashSet<>();
            }
            list[integer].add(nums[i]);
        }

        int[] ints = new int[k];

        int tar = 0;

        //求最大的两个数那就倒序查询
        for (int i = nums.length - 1; i >= 0 && tar < k; i--) {
            if (list[i+1] == null) {
                continue;
            } else {
                Set<Integer> list1 = list[i+1];
                for (Integer s : list1) {
                    System.out.println();
                    ints[tar++] = s;
                }
            }
        }
        return ints;

    }
//    public int[] topKFrequent(int[] nums, int k) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            Integer orDefault = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], ++orDefault);
//        }
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1) - map.get(o2);
//            }
//        });
//
//
//        for (Integer key : map.keySet()) {
//
//            if (priorityQueue.size() < k) {
//                priorityQueue.add(key);
//            } else {
//                if (map.get(key) > map.get(priorityQueue.peek())) {
//                    priorityQueue.poll();
//                    priorityQueue.offer(key);
//                }
//            }
//        }
//
//        int[] res = new int[k];
//        int i = 0;
//        while (!priorityQueue.isEmpty()) {
//            res[i++] = priorityQueue.poll();
//        }
//        return res;
//    }


}
