package leetcode.may;

/**
 * 区域和检索 - 数组不可变
 *
 * @Version : 1.0
 * @Creation : 2022/5/15 下午12:48
 * @Author : ksice_xt
 */
public class Leetcode303 {
    class NumArray {

        int[] _nums;

        public NumArray(int[] nums) {
            _nums = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                _nums[i] = _nums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {

            return _nums[right + 1] - _nums[left];
        }
    }

}
