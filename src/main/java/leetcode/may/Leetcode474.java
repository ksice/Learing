package leetcode.may;

/**
 * 一和零
 * @Version : 1.0
 * @Creation : 2022/5/8 上午11:31
 * @Author : ksice_xt
 */
public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        int[][] cnt = new int[len][2];

        for (int i = 0; i < len; i++) {

            int zero = 0, one = 0;

            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            //先将每个字符串的0 1个数都统计一下
            cnt[i] = new int[]{zero, one};
        }

        int[][] f = new int[m + 1][n + 1];

        for (int k = 0; k < len; k++) {

            //0的个数，1的个数
            int zero = cnt[k][0], one = cnt[k][1];

            for (int i = m; i >= zero; i--) {

                for (int j = n; j >= one; j--) {
                    f[i][j] = Math.max(f[i][j], f[i - zero][j - one] + 1);
                }
            }
        }
        return f[m][n];
    }
}
