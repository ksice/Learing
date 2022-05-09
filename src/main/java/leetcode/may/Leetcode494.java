package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/9 下午1:11
 * @Author : ksice_xt
 */
public class Leetcode494 {
    static int ans = 0;

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1, 1}, 3);
    }

    static int findTargetSumWays(int[] nums, int t) {
        dfs(nums, t, 0, 0);
        return ans;
    }

    /**
     * u代表下标，cur代表结果值，
     *
     * @param nums
     * @param t
     * @param u
     * @param cur
     */
    static void dfs(int[] nums, int t, int u, int cur) {
        System.out.println(+u + "||" + cur);

        if (u == nums.length) {
            ans += cur == t ? 1 : 0;
            return;
        }

        int add = cur + nums[u];
        dfs(nums, t, u + 1, add);

        System.out.println("=======");

        int sub = cur - nums[u];
        dfs(nums, t, u + 1, sub);
    }
}
