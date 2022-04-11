package leetcode;

/**
 * 统计各位数字都不同的数字个数(排列组合)
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *
 * @Version : 1.0
 * @Creation : 2022/4/11 上午10:14
 * @Author : ksice_xt
 */
public class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {

        int ans = 10;

        //n为0返回一个数字
        if (n == 0) {
            return 1;
        }

        //排列组合问题，如果是两位，第一位可以选择9种排除0.第二个选择9种，因为不能和第一个数字一样，同时可以为0
        //然后把两位的数目和三位的数目加上就是总和
        for (int i = 2, last = 9; i <= n; i++) {
            int cur = last * (10 - i + 1);
            ans += cur;
            last = cur;
        }

        return ans;
    }
}
