package leetcode.may;

/**
 * 一维数组的动态和
 *
 * @Version : 1.0
 * @Creation : 2022/5/14 上午11:44
 * @Author : ksice_xt
 */
public class Leetcode1480 {

    /**
     * 前缀和
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];

        for (int i = 0; i < sums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = nums[i] + sums[i - 1];
            }
        }
        return sums;
    }
}
