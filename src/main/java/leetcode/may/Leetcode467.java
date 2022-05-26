package leetcode.may;

import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/5/25 下午2:09
 * @Author : ksice_xt
 */
public class Leetcode467 {
    public int findSubstringInWraproundString(String _p) {
        char[] chars = _p.toCharArray();

        int[] dp = new int[26];

        int k = 0;
        for (int i = 0; i < _p.length(); i++) {
            //判断字母是否连续
            if (i > 0 && (_p.charAt(i) - _p.charAt(i - 1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            dp[_p.charAt(i) - 'a'] = Math.max(dp[_p.charAt(i) - 'a'], k);
        }

        return Arrays.stream(dp).sum();
    }
}
