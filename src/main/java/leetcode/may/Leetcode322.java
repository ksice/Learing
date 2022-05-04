package leetcode.may;

import com.sun.org.apache.xml.internal.security.Init;

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
        //第一个dp为0,否则的出下面的dp都是max
        dp[0] = 0;
        //完全背包和0-1背包主要就是循环的区别
        //得出从1开始凑到amount金额的最小硬币数
        for (int i = 1; i <= amount; i++) {
            //硬币数放在内部循环
            for (int j = 0; j < coins.length; j++) {
                //硬币数要小于等于amount值
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
