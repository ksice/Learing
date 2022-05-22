package leetcode.may;

/**
 * 连续字符
 *
 * @Version : 1.0
 * @Creation : 2022/5/22 下午1:38
 * @Author : ksice_xt
 */
public class Leetcode1446 {
    public int maxPower(String s) {

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            max = Math.max(j - i, max);
        }

        return max;
    }
}
