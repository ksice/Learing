package leetcode.may;

/**
 * 分割等和子集
 *
 * @Version : 1.0
 * @Creation : 2022/5/6 上午11:23
 * @Author : ksice_xt
 */
public class Leetcode416Review {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //要当心总数是不是偶数
        if ((sum & 1) == 1) {
            return false;
        }
        int mid = sum / 2;

        boolean[] dp = new boolean[mid + 1];

        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {

            for (int j = mid; nums[i] <= j; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[mid];
    }
}
