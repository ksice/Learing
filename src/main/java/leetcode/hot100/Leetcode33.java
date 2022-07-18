package leetcode.hot100;

/**
 * @author ksice
 * @since 2022-07-18 下午3:17
 */
public class Leetcode33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            //用来判断mid0到mid是否有序
            if (nums[0] <= nums[mid]) {

                //有序就正常二分法查找
                if (nums[mid] >= target && nums[0] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //无序[4,5,6,1,2,3] mid如果为3那么tartget小于mid，这时候l就开始移动到3这，r要反着来
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
