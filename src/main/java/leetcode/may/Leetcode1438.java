package leetcode.may;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 绝对差不超过限制的最长连续子数组
 *
 * @Version : 1.0
 * @Creation : 2022/5/22 下午2:22
 * @Author : ksice_xt
 */
public class Leetcode1438 {
    /**
     * 暴力搜索
     *
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int min = Integer.MAX_VALUE;
            int max = 0;

            for (int j = i; j < n; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);

                if (max - min > limit) {
                    break;
                }

                ans = Math.max(j - i + 1, ans);
            }
            //如果现有长度大于剩下长度可以直接不判断下面的
            if (ans > n - i + 1) break;

        }
        return ans;
    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param limit
     * @return
     */
//    public int longestSubarray(int[] nums, int limit) {
//
//        int n = nums.length;
//
//        int ans = 0;
//
//        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
//        for (int r = 0, l = 0; r < n; r++) {
//            while (!max.isEmpty() && nums[r] >= nums[max.peekLast()])
//                max.pollLast();
//
//            while (!min.isEmpty() && nums[r] <= nums[min.peekLast()])
//                min.pollLast();
//
//            max.addLast(r);
//            min.addLast(r);
//
//            while (Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
//                l++;
//                if (max.peekFirst() < l)
//                    max.pollFirst();
//                if (min.peekFirst() < l) {
//                    min.pollFirst();
//                }
//            }
//            ans = Math.max(ans, r - l + 1);
//
//
//        }
//
//        return ans;
//    }

}
