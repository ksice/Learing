package leetcode;

import java.util.*;

/**
 * 随机数索引
 * hash表处理
 *
 * @Version : 1.0
 * @Creation : 2022/4/25 上午11:27
 * @Author : ksice_xt
 */
public class Leetcode398 {


    Random r = new Random();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public Leetcode398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);

        Integer integer = list.get(r.nextInt(list.size()));

        return list.get(integer);
    }
}
