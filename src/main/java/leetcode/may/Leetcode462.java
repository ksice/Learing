package leetcode.may;

import java.util.Arrays;

/**
 * 最少移动次数使数组元素相等
 *
 * @Version : 1.0
 * @Creation : 2022/5/19 上午11:36
 * @Author : ksice_xt
 */
public class Leetcode462 {
    public int minMoves2(int[] nums) {

        //排序找中位数
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[nums.length / 2];
            ans += Math.abs(t - nums[i]);
        }
        return ans;
    }
}
