package leetcode.may;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 *
 * @Version : 1.0
 * @Creation : 2022/5/24 上午10:28
 * @Author : ksice_xt
 */
public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;

        int[] clone = nums.clone();

        Arrays.sort(clone);

        int i = 0, j = length - 1;
        //从前面找到第一个变化的值
        while (i <= j && nums[i] == clone[i]) {
            i++;
        }
        //从后面找到第一个变化的值
        while (i <= j && nums[j] == clone[j]) {
            j--;
        }
        //然后将两个值互减,长度要加1因为从0开始
        return j - i + 1;
    }
}
