package swordfingeroffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Version : 1.0
 * @Creation : 2022/3/31 上午11:20
 * @Author : ksice_xt
 */
public class Offer61 {

    public boolean isStraight(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;

        //0是可以变的，总共五个数，所以最大值减去最小值<5肯定是顺子，set去重
        for (int i = 0; i < nums.length; i++) {

            //大小王不管去除
            if (nums[i] == 0) {
                continue;
            }
            max = Integer.max(max, nums[i]);
            min = Integer.min(min, nums[i]);

            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return max - min < 5;
    }

}
