package leetcode.april;

/**
 * 最富有客户的资产总量
 * @Version : 1.0
 * @Creation : 2022/4/14 上午11:05
 * @Author : ksice_xt
 */
public class Leetcode1672 {

    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int[] item : accounts) {
            int sum = 0;
            for (int i = 0; i < item.length; i++) {
                sum += item[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}
