package leetcode.may;

/**
 * 增减字符串匹配
 *
 * @Version : 1.0
 * @Creation : 2022/5/9 下午12:51
 * @Author : ksice_xt
 */
public class Leetcode942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0, r = n;
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            //贪心解选最大或最小每次局部选最优解，以达到全局最优
            int ans = s.charAt(i) == 'I' ? l++ : r--;
            ints[i] = ans;
        }
        ints[n] = l;

        return ints;
    }
}
