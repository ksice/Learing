package leetcode.june;

/**
 * @Version : 1.0
 * @Creation : 2022/6/2 下午2:49
 * @Author : ksice_xt
 */
public class Leetcode44 {
    public boolean isMatch(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();

        char[] p = pp.toCharArray();

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;

        return false;
    }
}
