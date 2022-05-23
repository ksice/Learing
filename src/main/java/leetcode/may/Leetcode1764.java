package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/23 上午10:22
 * @Author : ksice_xt
 */
public class Leetcode1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length;
        int m = nums.length;

        int ans = 0;

        //滑动窗口i代表groups下标，j代表nums下标
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (check(groups[i], nums, j)) {
                //如果有成功了一个就要哦将nums的下标往前挪length长度
                j += groups[i++].length;
                ans++;
            } else {
                //还不如while循环一直查查不到就返回
                j++;
            }
        }

        return ans == groups.length;
    }

    boolean check(int[] g, int[] nums, int k) {
        int j = 0;

        for (;k<nums.length && j < g.length; j++, k++) {
            if (nums[k] != g[j]) {
                return false;
            }
        }

        return j == g.length;
    }
}
