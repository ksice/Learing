package leetcode.hot100;

import java.util.*;

/**
 * @Version : 1.0
 * @Creation : 2022/6/7 下午4:05
 * @Author : ksice_xt
 */
public class Leetcode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int[] ints = new int[nums.length + 1];
        ints[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = 1;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                list.add(i);
            }

        }

        return list;
    }
}
