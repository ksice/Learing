package leetcode.may;

/**
 * 最后一个石头重量
 * @Version : 1.0
 * @Creation : 2022/5/6 下午1:54
 * @Author : ksice_xt
 */
public class Leetcode1049Review {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;

        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int avg = sum / 2;
        int[] dp = new int[avg + 1];

        for (int i = 0; i < stones.length; i++) {

            for (int j = avg; stones[i] <= j; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return Math.abs(sum - dp[avg] * 2);
    }
}
