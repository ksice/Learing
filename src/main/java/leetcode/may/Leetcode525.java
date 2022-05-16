package leetcode.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 连续数组
 *
 * @Version : 1.0
 * @Creation : 2022/5/16 下午5:33
 * @Author : ksice_xt
 */
public class Leetcode525 {

    public int findMaxLength(int[] nums) {

        int[] ints = new int[nums.length + 1];

        //通过前缀和处理统计i之前是否01相等
        for (int i = 1; i <= nums.length; i++) {
            ints[i] = ints[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 2; i <= nums.length; i++) {

            if (!map.containsKey(ints[i - 2])) {
                map.put(ints[i - 2], i - 2);
            }

            if (map.containsKey(ints[i])) {
                ans = Math.max(ans, i - map.get(ints[i]));
            }

        }

        return ans;
    }
}
