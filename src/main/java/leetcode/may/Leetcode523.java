package leetcode.may;

import java.util.HashSet;
import java.util.Set;

/**
 * 连续的子数组和
 *
 * @Version : 1.0
 * @Creation : 2022/5/16 下午12:13
 * @Author : ksice_xt
 */
public class Leetcode523 {

    public static void main(String[] args) {
        checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {

        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        //同余定理,a % m余数为c  b % m余数为d 那么a-b是m的整数倍
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= nums.length; i++) {
            System.out.println(sum[i - 2]);
            set.add(sum[i - 2] % k);
            System.out.println(sum[i - 2] % k);

            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}
