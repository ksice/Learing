package leetcode.may;

/**
 * 零钱兑换二，有多少种兑换方式
 *
 * @Version : 1.0
 * @Creation : 2022/5/5 上午11:17
 * @Author : ksice_xt
 */
public class Leetcode518 {

    public static void main(String[] args) {
        change(3, new int[]{2});
    }

    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;
        //完全背包算法,将物品的值放在循环外层
        for (int i = 1; i <= coins.length; i++) {
            int x = coins[i - 1];

            for (int j = x; j <= amount; j++) {
                dp[j] += dp[j - x];
            }

        }

        return dp[amount];
    }

}
