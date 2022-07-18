package leetcode.july;

/**
 * @author ksice
 * @since 2022-07-18 下午3:51
 */
public class Leetcode704 {
    public int search(int[] nums, int target) {


        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid - 1;
            } else {
                r = mid + 1;
            }
        }
        return -1;
    }
}
