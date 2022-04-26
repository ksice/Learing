package leetcode;

/**
 * 三维形体投影面积
 *
 * @Version : 1.0
 * @Creation : 2022/4/26 下午6:03
 * @Author : ksice_xt
 */
public class Leetcode883 {
    public int projectionArea(int[][] g) {
        int ans1 = 0, ans2 = 0, ans3 = 0;
        int n = g.length;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] > 0) ans1++;
                a = Math.max(a, g[i][j]);
                b = Math.max(b, g[j][i]);
            }
            ans2 += a;
            ans3 += b;
        }
        return ans1 + ans2 + ans3;
    }

}
