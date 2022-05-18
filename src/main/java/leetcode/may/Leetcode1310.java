package leetcode.may;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * 子数组异或查询
 *
 * @Version : 1.0
 * @Creation : 2022/5/18 下午2:22
 * @Author : ksice_xt
 */
public class Leetcode1310 {

    public int[] xorQueries(int[] arr, int[][] qs) {

        int n = arr.length, m = qs.length;

        int[] sum = new int[n + 1];

        for (int i = 1; i <= arr.length; i++) {
            sum[i] = sum[i - 1] ^ arr[i - 1];
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int l = qs[i][0], r = qs[i][1] + 1;
            ans[i] = sum[r] ^ sum[l];
        }

        return ans;
    }


}
