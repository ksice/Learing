package leetcode.may;

/**
 * 爬楼梯，一次爬一阶或者两阶
 *
 * @Version : 1.0
 * @Creation : 2022/5/11 下午4:54
 * @Author : ksice_xt
 */
public class Leetcode70 {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

//        dp[0] = 1;
//        dp[1] = 1;
        int first = 1;
        int second = 2;
        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
//            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return second;
    }
}
