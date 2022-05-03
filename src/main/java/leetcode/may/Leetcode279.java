package leetcode.may;

import java.util.*;

/**
 * @Version : 1.0
 * @Creation : 2022/5/3 上午10:07
 * @Author : ksice_xt
 */
public class Leetcode279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    //动态规划 从小算到大，然后后面的数据基于先前数据进行计算
    public static int numSquares(int n) {

        //从0开始所以+1
        int[] dp = new int[n + 1];

        //从0开始没必要算
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            //要取最小值，得出凑成i最少需要几个数字
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            //然后加1是因为dp[i - j * j] j算一个数字
            dp[i] = min + 1;
        }

        //dp包含0到n的所有的最小平方数个数
        return dp[n];
    }
}
