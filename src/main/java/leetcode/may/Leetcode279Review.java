package leetcode.may;

import java.util.Arrays;

/**
 * 完全平方数
 *
 * @Version : 1.0
 * @Creation : 2022/5/6 下午1:34
 * @Author : ksice_xt
 */
public class Leetcode279Review {

    public static int numSquares(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            int min = 0x3f3f3f3f;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }
}
