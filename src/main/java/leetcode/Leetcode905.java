package leetcode;

/**
 * @Version : 1.0
 * @Creation : 2022/4/28 上午11:59
 * @Author : ksice_xt
 */
public class Leetcode905 {
    public static void main(String[] args) {
        sortArrayByParity(new int[]{1, 5, 2, 4, 6});
    }

    public static int[] sortArrayByParity(int[] nums) {

        int n = nums.length;

        //i<j因为每次互换位置后不需要算到最后一位
        for (int i = 0, j = n - 1; i < j; i++) {
            //如果nums[i]为奇数
            //那么将i和j进行位置互换，换完之后需要将j位置上的值肯定是奇数，然后重新算i的值通过i--
            if (nums[i] % 2 == 1) {
                int c = nums[j];
                nums[j--] = nums[i];
                nums[i--] = c;
            }
        }

        return nums;
    }
}
