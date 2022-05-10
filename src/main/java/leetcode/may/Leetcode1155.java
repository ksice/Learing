package leetcode.may;

/**
 * 掷骰子的N种方法
 *
 * @Version : 1.0
 * @Creation : 2022/5/10 上午10:49
 * @Author : ksice_xt
 */
public class Leetcode1155 {

    /**
     * 分组背包，递推
     *
     * @param n
     * @param k
     * @param target
     * @return
     */
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) 1e9 + 7;

        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        //每个骰子个数
        for (int i = 1; i <= n; i++) {
            //目标值
            for (int j = 0; j <= target; j++) {
                //每一面
                for (int l = 1; l <= k; l++) {
                    if (j >= k) {
                        //每次的总和都基于上一行的结果值
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
                    }

                }
            }
        }
        return dp[n][target];
    }

}
