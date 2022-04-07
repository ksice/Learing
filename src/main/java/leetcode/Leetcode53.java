package leetcode;

/**
 * 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 *
 * @Version : 1.0
 * @Creation : 2022/4/7 下午2:10
 * @Author : ksice_xt
 */
public class Leetcode53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        //动态规划
        for (int x : nums) {
            //通过前一个位置的状态判断下一个为位置的状态,加了x要是变小了说明pre是负数，那么舍弃之前的值从x位置重新算
            pre = Math.max(pre + x, x);
            //统计每次的最大值
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
