package leetcode.june;

/**
 * koko eat bananas
 *
 * @Version : 1.0
 * @Creation : 2022/6/7 上午10:02
 * @Author : ksice_xt
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0, left = 0;
        for (int item : piles) {
            right = Math.max(right, item);
        }

        while (left < right) {
            int mid = (left + right) >> 1;

            //这个数如果满足了，就往左移，看是否有更小的数满足,不满足说明小了
            if (isValid(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    boolean isValid(int[] p, int mid, int h) {
        int ans = 0;

        //判断这个mid是否可以满足吃完所有香蕉
        for (int item : p) {
            ans += Math.ceil(item * 1.0 / mid);
        }

        return ans <= h;
    }
}
