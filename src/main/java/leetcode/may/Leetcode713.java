package leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 乘积小于 K 的子数组
 *
 * @Version : 1.0
 * @Creation : 2022/5/5 上午10:04
 * @Author : ksice_xt
 */
public class Leetcode713 {

//    List<List<Integer>> list = new ArrayList<>();

    /**
     * 无脑做法
     */
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//            int j = i + 1;
//            if (nums[i] < k) {
//                int sum = nums[i];
//                ++ans;
//
//                while (j < nums.length) {
//                    sum *= nums[j];
//                    if (sum < k) {
//                        ++ans;
//                    } else {
//                        break;
//                    }
//                    j++;
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;

        if (k <= 1) {
            return ans;
        }
        for (int i = 0, j = 0, cur = 1; i < nums.length; i++) {
            //从0开始的乘积
            cur *= nums[i];

            //如果遇到超过的值，就将之前左边的值进行剔除这样得到一个以j作为左边界 i作为右边界的端口,然后i开始右移
            while (cur >= k) {
                cur /= nums[j++];
            }
            ans += i - j + 1;
        }

        return ans;
    }
}
