package leetcode.hot100;

import java.util.Arrays;

/**
 * 找出数组中唯一的数字，不能使用额外空间
 * @Version : 1.0
 * @Creation : 2022/6/20 上午11:48
 * @Author : ksice_xt
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        //0^0=0，0^1=1 0异或任何数＝任何数
        // 1^0=1，1^1=0 1异或任何数－任何数取反
        //相等为0不等为1
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
