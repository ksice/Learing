package leetcode;

import java.sql.RowId;

/**
 * 最大回文数乘积
 *
 * @Version : 1.0
 * @Creation : 2022/4/16 下午12:13
 * @Author : ksice_xt
 */
public class Leetcode479 {

    public static void main(String[] args) {
        int left = 99;
        int p = 99;

        for (int x = left; x > 0; x /= 10) {
            p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
        }
        System.out.println(p);
    }

    public int largestPalindrome(int n) {
        int ans = 0;
        if (n == 1) {
            return 9;
        }
        //得到每n个数的最大值
        int max = (int) (Math.pow(10, n) - 1);
        //设计ans==0用来找到最大值，如果ans不等于0说明找到了就不在进行下次循环
        for (int i = max; ans == 0; --i) {

            long p = i;
            for (int j = i; j > 0; j /= 10) {
                //根据i生成每一个i的回文子串
                p = p * 10 + (j % 10);
            }

            //然后在循环的将最大回文子串进行所有数取余，如果能等于0说明是j*i得到的最大值，因为是从最大值到最小值
            for (long j = max; j * j >= p; --j) {
                if (p % j == 0) {
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
