package leetcode;

/**
 * 二进制表示中质数个计算置位
 *
 * @Version : 1.0
 * @Creation : 2022/4/5 下午3:09
 * @Author : ksice_xt
 */
public class Leetcode762 {
    static boolean[] hash = new boolean[40];

    static {
        //因为int的二进制数的1最多32个，然后我们只需要算32里面有哪些数字是质数，然后将他们统计
        int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int x : nums) {
            hash[x] = true;
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int cnts = 0;
        for (int i = left; i <= right; i++) {
            //得出int和long类型的数下的二进制1的个数
            int i1 = Integer.bitCount(i);
            if (hash[i1]) {
                ++cnts;
            }
        }
        return cnts;
    }

}
