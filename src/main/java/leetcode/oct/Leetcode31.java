package leetcode.oct;

/**
 * @author ksice
 * @since 2022-10-17 3:08 PM
 */
public class Leetcode31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        //反向判断，是否当前数字是最大数字
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //如果当前数据不是最大值则位置互换
        if (i >= 0) {
            int j = nums.length - 1;

            //
            //找到比i大的最小值，然后进行互换
            //例如[4,5,2,6,3,1] ，nums[i] 为2，找到之后和nums[j](3)互换，变成
            //[4,5,3,6,2,1],再反转变成 [4,5,3,1,2,6]
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    /**
     * 将ij互换
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 将nums中的start位置到最后的位置进行互换
     *
     * @param nums
     * @param start
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
