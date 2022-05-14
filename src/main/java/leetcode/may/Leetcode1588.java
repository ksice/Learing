package leetcode.may;

/**
 * 所有奇数长度子数组的和
 *
 * @Version : 1.0
 * @Creation : 2022/5/14 上午11:50
 * @Author : ksice_xt
 */
public class Leetcode1588 {

    /**
     * 前缀和
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {

        int[] sum = new int[arr.length + 1];

        int ans = 0;

        //先求出前缀和
        int length = arr.length;
        for (int i = 1; i <= length; i++) {
            //得出1 2 3的前缀和
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        for (int i = 1; i <= length; i += 2) {

            for (int j = 0; j + i - 1 < length; j++) {
                //下标移动减一
                int len = j + i;

                //len因为上面的前缀和本身就是+1所以不减了
                ans += sum[len] - sum[j];
            }
        }

        return ans;
    }
}
