package leetcode.april;

/**
 * 二分查找
 *
 * @Version : 1.0
 * @Creation : 2022/4/2 下午2:11
 * @Author : ksice_xt
 */
public class Leetcode704 {

    public int search(int[] nums, int target) {
        int l = 0;

        int r = nums.length - 1;

        int tarGetIndex = 0;

        while (l <= r) {
            int i1 = (l + r) / 2;

            if (nums[i1] == target) {
                return i1;
            }

            if (nums[i1] > target) {
                //因为nums[i1] 大于目标，所以i1不算，从i1左边开始算，小于，反之
                r = i1 - 1;
            } else {
                l = i1 + 1;
            }
        }
        return -1;
    }

}
