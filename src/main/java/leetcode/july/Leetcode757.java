package leetcode.july;

import java.util.Arrays;

/**
 * 设置交集大小至少为2
 *
 * @author ksice
 * @since 2022-07-22 下午2:53
 */
public class Leetcode757 {
    //将ins进行排序，然后判断每个点和点之间是否重复
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] != b[1] ? a[1] - b[1] : b[0] - a[0];
        });

        int a = -1, b = -1, ans = 0;

        for (int[] i : intervals) {
            if (i[0] > b) {
                //判断下一个开始节点是否和前一个节点是否有交界,无交界就两段距离中都需要取两个点
                a = i[1] - 1;
                b = i[1];
                ans += 2;
            } else if (i[0] > a) {
                //因为else if的原因
                //[[1, 3], [1, 4], [2, 5], [3, 5]]
                //所以[1,3]第一次进入加2，a=2,b=2,[1,4],[2,5]不进入[3,5]在进入一次
                a = b;
                b = i[1];
                ans++;
            }
        }
        return ans;
    }
}
