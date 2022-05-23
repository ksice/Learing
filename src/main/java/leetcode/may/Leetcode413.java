package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/23 上午11:07
 * @Author : ksice_xt
 */
public class Leetcode413 {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i;

            int end = i + 1;

            int diff = nums[end] - nums[start];

            //等差数列
            while (end + 1 < nums.length && nums[end + 1] - nums[end] == diff) {
                end++;
            }

            //真的是数学找规律
            ans += (end - start) * (end - start - 1) / 2;

            i = end - 1;
        }

        return ans;
    }
}
