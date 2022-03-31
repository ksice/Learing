package swordfingeroffer;

import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/3/31 下午2:28
 * @Author : ksice_xt
 */
public class Offer03 {
    static int N = 100000;

    static int[] item = new int[N];

    public int findRepeatNumber(int[] nums) {
        Arrays.fill(item, 0);
        //就取一个重复的数字
        int repeat = 0;

        for (int i = 0; i < nums.length; i++) {
            item[nums[i]] = ++item[nums[i]];

            if (item[nums[i]] > 1) {
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }
}
