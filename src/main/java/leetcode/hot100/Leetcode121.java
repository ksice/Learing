package leetcode.hot100;

/**
 * 买卖股票的最佳时机
 * @Version : 1.0
 * @Creation : 2022/6/20 上午11:32
 * @Author : ksice_xt
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {

        int max = 0;
        int min = Integer.MAX_VALUE;
        //找到最小值后面的最大差值
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
