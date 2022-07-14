package leetcode.july;

/**
 * @Version : 1.0
 * @Creation : 2022/7/13 下午4:14
 * @Author : ksice_xt
 */
public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        //求1的个数
        int i = Integer.bitCount(x ^ y);

        int ans = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                ans++;
            }

            if (x != 0) {
                x = x >> 1;
            }

            if (y != 0) {
                y = y >> 1;
            }
        }
        return ans;
    }
}
