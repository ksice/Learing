package leetcode.may;

/**
 * 分割等和子集（拆分背包问题）
 * 将一个集合拆分成两个和相等的两个子集
 *
 * @Version : 1.0
 * @Creation : 2022/5/1 下午12:50
 * @Author : ksice_xt
 */
public class Leetcode416 {
//
//    public boolean canPartition(int[] nums) {
//        int n = nums.length;
//
//        int sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//        }
//
//        //先得出集合的数组和，如果和不为偶数即为false
//        if ((sum & 1) == 1) {
//            return false;
//        }
//        //得出子集的和，然后当成背包容量
//        int target = sum / 2;
//
//        boolean[][] dp = new boolean[n][target + 1];
//        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
//        if (nums[0] <= target) {
//            dp[0][nums[0]] = true;
//        }
//
//        for (int i = 1; i < n; i++) {
//
//            for (int j = 0; j <= target; j++) {
//
//                dp[i][j] = dp[i - 1][j];
//
//                if (nums[i] == j) {
//                    dp[i][j] = true;
//                    continue;
//                }
//
//                if (nums[i] <= j) {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
//                }
//
//            }
//        }
//        return dp[n - 1][target];
//    }

    /**
     * 从二维表前到后
     * 时间复杂度：O(NC)O(NC)：这里 NN 是数组元素的个数，CC 是数组元素的和的一半。
     * 空间复杂度：O(NC)O(NC)
     *
     * @param nums
     * @return
     */
//    public boolean canPartition(int[] nums) {
//        int n = nums.length;
//
//        int sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//        }
//
//        //先得出集合的数组和，如果和不为偶数即为false
//        if ((sum & 1) == 1) {
//            return false;
//        }
//        //得出子集的和，然后当成背包容量
//        int target = sum / 2;
//
//        boolean[][] dp = new boolean[n][target + 1];
//
//        //为了后面j-num[i]=0
//        dp[0][0] = true;
//
//        for (int i = 1; i < n; i++) {
//
//            for (int j = 0; j <= target; j++) {
//
//                dp[i][j] = dp[i - 1][j];
//
//                //如果哦nums[i]小于等于j值，因为dp[0][0] = true;所以可以将等于放在一起
//                if (nums[i] <= j) {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
//                }
//
//                //提前结束，类似减枝操作
//                if (dp[i][target]) {
//                    return true;
//                }
//            }
//        }
//        //最后返回还是最后一行和目标列
//        return dp[n - 1][target];
//    }


    /**
     * 逆序操作，二维降一维，滚动数组
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        //先得出集合的数组和，如果和不为偶数即为false
        if ((sum & 1) == 1) {
            return false;
        }
        //得出子集的和，然后当成背包容量
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        //为了后面j-num[i]=0
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {

            for (int j = target; nums[i] <= j; j--) {

                if (dp[target]) {
                    return true;
                }

                dp[j] = dp[j] || dp[j - nums[i]];

            }
        }
        //最后返回还是最后一行和目标列
        return dp[target];
    }
}
