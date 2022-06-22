package leetcode.hot100;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * @Version : 1.0
 * @Creation : 2022/6/22 下午5:30
 * @Author : ksice_xt
 */
public class Leetcode169 {


    public int majorityElement(int[] nums) {
        int count = 1;
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (ans == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    ans = nums[i];
                }
            }
        }

        return ans;
//排序取中间值就行
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
    }


}
