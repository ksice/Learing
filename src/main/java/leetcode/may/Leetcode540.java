package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/24 下午2:52
 * @Author : ksice_xt
 */
public class Leetcode540 {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int l = 0, r = n - 1;

        while (l < r) {

            int mid = l + r >> 1;

            //因为是有序的数组，那么可以通过前后两值的比较判断多的那个数字在左边还是右边
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (mid + 1 < n && nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[r];

    }
}
