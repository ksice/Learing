package leetcode.june;

/**
 * 最长特殊序列 II
 * 查找最长的字串,即不能是其他字符串的子序列
 *
 * @Version : 1.0
 * @Creation : 2022/6/27 下午2:34
 * @Author : ksice_xt
 */
public class Leetcode522 {
    public int findLUSlength(String[] strs) {

        int ans = -1;
        int length = strs.length;
        out:
        for (int i = 0; i < length; i++) {

            String str = strs[i];


            for (int j = 0; j < length; j++) {

                //如果是子串就跳过
                if (j != i && isSub(str, strs[j])) {
                    continue out;
                }
            }

            ans = Math.max(ans, str.length());

        }
        return ans;
    }

    public boolean isSub(String ori, String tar) {

        int m = ori.length(), n = tar.length();
        //如果字串大于比较的字符串就返回false
        if (m > n) {
            return false;
        }
        int i = 0;

        for (int j = 0; i < m && j < n; j++) {

            if (ori.charAt(i) == tar.charAt(j)) {
                i++;
            }
        }
        return i == m;
    }
}
