package leetcode.june;

import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/6/28 上午10:11
 * @Author : ksice_xt
 */
public class Leetcode324 {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int x = (nums.length + 1) / 2;
        for (int i = 0, j = x - 1, k = nums.length - 1; i < nums.length; i += 2, j--, k--) {

            //每次加二因为要插入两次
            nums[i] = clone[j];
            if (i + 1 < nums.length) {
                nums[i + 1] = clone[k];
            }
        }
    }

}
