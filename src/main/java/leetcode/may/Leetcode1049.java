package leetcode.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Version : 1.0
 * @Creation : 2022/5/2 上午10:33
 * @Author : ksice_xt
 */
public class Leetcode1049 {

    public static void main(String[] args) {
        lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
    }

    /**
     * 最后一块石头的重量
     * <p>
     * 0-1背包问题，不看题解根本看不出
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;

        //[2,7,4,1,8,1]
        //sum为23 avg=11 然后重里面凑石头找到最多能凑多少石头
        //得出小于等于这个背包的最大的石头重量，然后拿总值减去双倍重量就是差值
        for (int i = 0, l = n; i < l; i++) {
            sum += stones[i];
        }

        int avg = sum / 2;

        //因为数组从0开始所以加1
        int[] dp = new int[avg + 1];

        //一维逆序背包
        for (int i = 1; i <= n; i++) {

            int x = stones[i - 1];

            System.out.println(x+"-------");
            for (int j = avg; j >= x; j--) {
                dp[j] = Math.max(dp[j], dp[j - x] + x);

                System.out.println(dp[j]);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }

        return Math.abs(sum - 2 * dp[avg]);
    }

}
