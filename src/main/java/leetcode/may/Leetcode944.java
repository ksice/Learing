package leetcode.may;

/**
 * 删列造序
 *
 * @Version : 1.0
 * @Creation : 2022/5/12 下午3:01
 * @Author : ksice_xt
 */
public class Leetcode944 {
    public int minDeletionSize(String[] strs) {

        int n = strs.length, m = strs[0].length(), ans = 0;

        out:
        for (int i = 0; i < m; i++) {
            for (int j = 0, cur = -1; j < n; j++) {
                char c = strs[j].charAt(i);
                if (c < cur && ++ans >= 0) {
                    continue out;
                }
                cur = c;
            }
        }
        return ans;
    }
}
