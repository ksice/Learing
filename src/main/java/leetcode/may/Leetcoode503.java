package leetcode.may;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Version : 1.0
 * @Creation : 2022/5/30 上午11:21
 * @Author : ksice_xt
 */
public class Leetcoode503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int item = nums[i % n];

            while (!stack.isEmpty() && item > nums[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop]=item;
            }
            stack.push(i % n);
        }
        return ans;
    }
}
