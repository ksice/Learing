package leetcode.april;

/**
 * 最小差值 I
 *
 * @Version : 1.0
 * @Creation : 2022/4/30 上午11:07
 * @Author : ksice_xt
 */
public class Leetcode908 {
    /**
     * 最大元素和最小元素的差值，最小的差值就是0
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {

        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        //最小值无非就是最大值减去最小值，然后再减去二倍的k值

        return Math.max(0, max - min - 2 * k);
    }
}
