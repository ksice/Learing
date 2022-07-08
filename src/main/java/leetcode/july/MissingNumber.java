package leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/7/8 下午2:04
 * @Author : ksice_xt
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
            if (i + 1 == nums.length) {
                return i + 1;
            }
        }
        return 0;
    }
}
