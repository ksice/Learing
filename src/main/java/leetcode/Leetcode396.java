package leetcode;

import java.util.Arrays;

/**
 * 旋转函数
 * @Version : 1.0
 * @Creation : 2022/4/22 下午3:42
 * @Author : ksice_xt
 */
public class Leetcode396 {
    // 找规律题
// sum:                            a0 * 1 + a1 * 1 + a2 * 1 + a3 * 1

// f(0):                              a0 * 0 + a1 * 1 + a2 * 2 + a3 * 3
// f(0) + sum:                        a0 * 1 + a1 * 2 + a2 * 3 + a3 * 4

// f(1):                     a3 * 0 + a0 * 1 + a1 * 2 + a2 * 3              f(1) = f(0) + sum - 4*a[4-1]
// f(1) + sum:               a3 * 1 + a0 * 2 + a1 * 3 + a2 * 4

// f(2):            a2 * 0 + a3 * 1 + a0 * 2 + a1 * 3                   f(2) = f(1) + sum - 4*a[4-2]
// f(2) + sum:      a2 * 1 + a3 * 2 + a0 * 3 + a1 * 4

    // f(3):  a1 * 0 +  a2 * 1 + a3 * 2 + a0 * 3                        f(3) = f(2) + sum - 4*a[4-3]
    // 由上可得f(n) = f(n - 1) + sum - len * a[len - n]
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();

        //得出最原始的值
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;

        //这个规律题真的秀，numsum等于 a0 * 1 + a1 * 1 + a2 * 1 + a3 * 1，
        for (int i = n - 1; i > 0; i--) {
            //然后每次转一次就把最后一位给减去，然后就能得到F(n-i)
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }

        return res;
    }
}
