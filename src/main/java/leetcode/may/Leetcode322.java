package leetcode.may;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @Version : 1.0
 * @Creation : 2022/5/4 上午10:04
 * @Author : ksice_xt
 */
public class Leetcode322 {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            //完全背包算法，一个物品可以被使用多次
            //0-1背包是每个物品只能使用一次
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    //因为每个硬币都在这重新加一
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
