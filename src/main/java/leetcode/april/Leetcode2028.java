package leetcode.april;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.Arrays;

/**
 * 找出缺失的观测数据
 *
 * @Version : 1.0
 * @Creation : 2022/3/27 下午1:52
 * @Author : ksice_xt
 */
public class Leetcode2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int cnt = rolls.length + n;

        int sum = mean * cnt;

        //减去已经存在的值
        for (int i = 0, length = rolls.length; i < length; i++) {
            sum -= rolls[i];
        }

        //如果总数小于最小值或者大于最大点数返回空值
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }

        int[] ans = new int[n];

        //通过/将数据进行均摊取整数
        Arrays.fill(ans, sum / n);

        //取整再乘以整数小于sum总值，说明/数据分摊不均，需要加1
        if (sum / n * n < sum) {
            //得出最后还剩多少值去分摊
            int d = sum - (sum / n * n), idx = 0;

            while (d-- > 0) {
                //这里不需要判断是否会超过6因为上面已经过滤过总值不会超过6，同时均摊一个一个加1不会超过6
                ans[idx++]++;
            }

        }
        return ans;
    }
}
