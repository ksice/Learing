package leetcode.may;

import java.util.HashSet;
import java.util.Set;

/**
 * 在长度 2N 的数组中找出重复 N 次的元素
 * @Version : 1.0
 * @Creation : 2022/5/21 上午11:57
 * @Author : ksice_xt
 */
public class Leetcode961 {

    public int repeatedNTimes(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

}
