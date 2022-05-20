package leetcode.may;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Version : 1.0
 * @Creation : 2022/5/20 上午10:03
 * @Author : ksice_xt
 */
public class Leetcode436 {

    public int[] findRightInterval(int[][] intervals) {

        int[][] clone = new int[intervals.length][2];

        int[] ans = new int[intervals.length];
        //将每个区间的起始值都存下来
        for (int i = 0; i < intervals.length; i++) {
            clone[i] = new int[]{intervals[i][0], i};
        }

        Arrays.sort(clone, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {

            int start = 0;

            int end = intervals.length - 1;

            while (start < end) {

                int mid = end + start >> 1;

                if (clone[mid][0] >= intervals[i][1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }

            }
            ans[i] = clone[end][0] >= intervals[i][1] ? clone[end][1] : -1;
        }
        return ans;
    }
}
