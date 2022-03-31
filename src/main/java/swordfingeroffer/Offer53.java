package swordfingeroffer;

/**
 * 在排序数组中查找数字
 * nums 是一个非递减数组
 *
 * @Version : 1.0
 * @Creation : 2022/3/31 下午2:53
 * @Author : ksice_xt
 */
public class Offer53 {

    public int search(int[] nums, int target) {
        //数组是个递增数组，所以用二分法
        //例如1 2 3 4 5 6 6 7 8  target 6 那第一个得到的就是第一个6的下标，第二个得到的是7的下标
        //第一个得到target的右边界，第二个得到target-1的右边界，即为target的下标，然后相减得到target个数
        return findtarget(nums, target) - findtarget(nums, target - 1);
    }

    int findtarget(int[] nums, int target) {
        //二分法类似滑动窗口
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            //每次都重新进行二分查找
            int m = (i + j) / 2;

            if (nums[m] <= target) {
                //m下标值小于target了，说明i的下标要往右移
                i = m + 1;
            } else {
                //如果值大于target, j的下标要左移动
                j = m - 1;
            }
        }
        return i;
    }
}
