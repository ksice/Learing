package leetcode.april;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Version : 1.0
 * @Creation : 2022/4/19 下午1:44
 * @Author : ksice_xt
 */
public class Leetcode821 {

    //遍历方法从左扫描一遍然后从右在扫描一遍
    public int[] shortestToChar(String s, char c) {

        int length = s.length();
        int[] indexs = new int[length];

        //先填充所有值
        Arrays.fill(indexs, length + 1);

        for (int i = 0, j = -1; i < s.length(); i++) {
            //loveleetcode
            //先找到目标值，如果有多个目标值就开始替换目标值的下标
            if (s.charAt(i) == c) {
                j = i;
            }

            //找到目标值开始算距离
            if (j != -1) {
                indexs[i] = i - j;
            }
        }

        for (int i = length - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            //从右边开始扫描得出最小值
            if (j != -1) {
                indexs[i] = Math.min(j - i, indexs[i]);
            }
        }

        return indexs;

    }


    public static void main(String[] args) {
        int[] bfs = bfs("loevlcaaae", 'e');
    }

    /**
     * bfs
     *
     * @param s
     * @param c
     * @return
     */
    public static int[] bfs(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                queue.offer(i);
                //i即为c
                ans[i] = 0;
            }
        }

        //先找到c作为出发点，两边开始拓展，同时用-1作为判断防止重复入值，然后通过前缀和加1得出路径
        //通过-1来判断不能重复判断，不用担心多个C，先进先出，loevlcaaae 近的肯定已经先判断插入值了
        while (!queue.isEmpty()) {
            int pos = queue.poll();

            if (pos - 1 >= 0 && ans[pos - 1] == -1) {
                queue.offer(pos - 1);
                ans[pos - 1] = ans[pos] + 1;
            }

            if (pos + 1 < n && ans[pos + 1] == -1) {
                queue.offer(pos + 1);
                ans[pos + 1] = ans[pos] + 1;
            }
        }
        return ans;
    }
}
