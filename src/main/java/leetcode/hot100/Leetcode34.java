package leetcode.hot100;

/**
 * @author ksice
 * @since 2022-07-18 上午11:39
 */
public class Leetcode34 {


    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10};
        searchRange(nums, 10);

    }

    public static int searchRange(int[] nums, int target) {
        int r = nums.length;
        int l = 0;

        while (l < r) {
            int avg = (l + r) / 2;

            if (nums[avg] > target) {
                r = avg;
            } else {
                l = avg + 1;
            }
        }

        System.out.println(r);
        return r;
    }

}
