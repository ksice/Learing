package leetcode.may;

import java.util.Arrays;

/**
 * 供暖器
 * @Version : 1.0
 * @Creation : 2022/5/24 上午10:48
 * @Author : ksice_xt
 */
public class Leetcode475 {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        for (int i = 0; i < houses.length; i++) {
            int min = Integer.MAX_VALUE;
            //其实可以将heaters排序这样就不需要遍历玩heaters
            for (int j = 0; j < heaters.length; j++) {
                min = Math.min(min, Math.abs(heaters[j] - houses[i]));
            }
            ans = Math.max(ans, min);
        }
        return ans;
    }
}
