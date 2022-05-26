package leetcode.may;

import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/5/25 下午2:59
 * @Author : ksice_xt
 */
public class Leetocde467 {
    public int findSubstringInWraproundString(String _p) {
        int[] dp = new int[26];

        int k = 0;
        for (int i = 0; i < _p.length(); i++) {
            //判断字母是否连续，同时只要连续就+1 a就是一个子串 ab就是两个子串 abc就是三个子串，
            if (i > 0 && (_p.charAt(i) - _p.charAt(i - 1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            //防止一个同样的子串，然后取最大的值
            dp[_p.charAt(i) - 'a'] = Math.max(dp[_p.charAt(i) - 'a'], k);
        }


        return Arrays.stream(dp).sum();
    }
}
