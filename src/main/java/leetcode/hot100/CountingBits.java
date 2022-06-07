package leetcode.hot100;

/**
 * Counting Bits
 *
 * @Version : 1.0
 * @Creation : 2022/6/7 下午12:09
 * @Author : ksice_xt
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = getit(i);
        }
        return ans;
    }

    int getit(int n) {
        int ans = 0;
        while (n > 0) {
            //没与一次就少个1
            n &= n - 1;
            ans++;
        }
        return ans;
    }
}
