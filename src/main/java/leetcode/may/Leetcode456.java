package leetcode.may;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 132 模式
 * i<j<k
 * nums[i] < nums[k] < nums[j]非连续子串
 *
 * @Version : 1.0
 * @Creation : 2022/5/29 上午11:19
 * @Author : ksice_xt
 */
public class Leetcode456 {

    public static void main(String[] args) {
        find132pattern(new int[]{3,1,4,2,3});
    }

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;

        Deque<Integer> d = new ArrayDeque<>();

        int k = Integer.MIN_VALUE;

        //123代表ijk
        //倒序插入查找队列里面是k，
        //例如3,1,4,2,3
        //队列里面放着2,3这就是k，然后找到4的时候去把小于4的最大值给取出来就是j
        //然后再去判断四的左边是否有比j小的，有就是true
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                k = Math.max(k, d.pollLast());
                System.out.println(k);
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}
