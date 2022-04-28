package leetcode.april;

/**两数之和
 * @Version : 1.0
 * @Creation : 2022/4/15 下午3:15
 * @Author : ksice_xt
 */
public class Leetcode01 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];

            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (nums[j] != result) {
                        continue;
                    }
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
