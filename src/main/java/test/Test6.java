package test;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @Version : 1.0
 * @Creation : 2022/5/16 下午8:10
 * @Author : ksice_xt
 */
public class Test6 {

    public static void main(String[] args) {
        test(new int[]{2, 0, 2, 1, 1, 0});
    }

    /**
     * 给定一个只包含0、1、2三类数字的数组，只遍历一次完成排序，示例如下。
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */
    public static int[] test(int[] ints) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < ints.length; i++) {
            List<Integer> orDefault = map.getOrDefault(ints[i], new ArrayList<>());
            orDefault.add(ints[i]);
            map.put(ints[i], orDefault);
        }

        List<Integer> list = map.get(0);

        List<Integer> list1 = map.get(1);

        List<Integer> list2 = map.get(2);

        list.addAll(list1);
        list.addAll(list2);

        for (Integer a : list) {
            System.out.println(a);
        }

        return null;
    }
}
