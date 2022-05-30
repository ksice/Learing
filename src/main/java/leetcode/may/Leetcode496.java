package leetcode.may;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 *
 * @Version : 1.0
 * @Creation : 2022/5/30 上午10:53
 * @Author : ksice_xt
 */
public class Leetcode496 {

    //单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;

        for (int i = n - 1; i >= 0; i--) {
            int item = nums2[i];

            //单调递增栈
            while (!stack.isEmpty() && item >= stack.peek()) {
                stack.pop();
            }

            //因为单调栈里面存取的都是都是比item大的值，如果没有就是-1
            map.put(item, stack.isEmpty() ? -1: stack.peek());

            stack.push(item);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
