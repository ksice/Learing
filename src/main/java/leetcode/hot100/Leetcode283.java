package leetcode.hot100;

/**移动0
 * @Version : 1.0
 * @Creation : 2022/6/22 下午5:44
 * @Author : ksice_xt
 */
public class Leetcode283 {

    //双下标
    public void moveZeroes(int[] nums) {

        //用来记录非0个数
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
