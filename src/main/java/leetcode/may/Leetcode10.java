package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/3 上午11:51
 * @Author : ksice_xt
 */
public class Leetcode10 {

    public static void main(String[] args) {
        System.out.println(isMatch("abc", "abce*"));
    }

    /**
     * p[j] 为普通字符：匹配的条件是前面的字符匹配，同时 s 中的第 i 个字符和 p 中的第 j 位相同。 即 f(i,j) = f(i - 1, j - 1) && s[i] == p[j] 。
     * p[j] 为 '.'：匹配的条件是前面的字符匹配， s 中的第 i 个字符可以是任意字符。即 f(i,j) = f(i - 1, j - 1) && p[j] == '.'。
     * p[j] 为 '*'：读得 p[j - 1] 的字符，例如为字符 a。 然后根据 a* 实际匹配 s 中 a 的个数是 0 个、1 个、2 个 ...
     * 3.1. 当匹配为 0 个：f(i,j) = f(i, j - 2)
     * 3.2. 当匹配为 1 个：f(i,j) = f(i - 1, j - 2) && (s[i] == p[j - 1] || p[j - 1] == '.')
     * 3.3. 当匹配为 2 个：f(i,j) = f(i - 2, j - 2) && ((s[i] == p[j - 1] && s[i - 1] == p[j - 1]) || p[j - 1] == '.')
     *
     * @param s 字符串
     * @param p 正则
     * @return
     */
    public  boolean isMatchbak(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;

        for (int i = 0; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (j + 1 <= m && p[j + 1] == '*') {
                    continue;
                }

                if (i - 1 >= 0 && p[j] != '*') {
                    // 对应了 p[j] 为普通字符和 '.' 的两种情况
                    //f[i-1][j-1]是得出他的前面的字符串是否能匹配上 ,还有普通字符和.是否相等
                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                } else if (p[j] == '*') {
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) || (i - 1 >= 0 && f[i - 1][j]) && (s[i] == p[j - 1] || p[j - 1] == '.');
                }
            }

        }
        return f[n][m];
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];

                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    System.out.println(i + "and" + j);

                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

        }

        return dp[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
