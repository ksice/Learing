package leetcode.june;

import java.util.Random;

/**
 * @Version : 1.0
 * @Creation : 2022/6/9 上午11:06
 * @Author : ksice_xt
 */
public class Leetcode497 {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(random.nextInt(3));
    }
    class Solution {
        int[][] rs;
        int[] sum;
        int n;
        Random random = new Random();

        public Solution(int[][] rects) {
            rs = rects;
            n = rs.length;
            sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                //通过前缀和得出，第一个矩形有多少个点，第二个矩形一起有多少个点，+1是为了算点数
                sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1]+1);
            }
        }

        public int[] pick() {
            //例如总共18个点，两个矩形，然后随机选了一个点
            //判断是在前九个点，还是后九个点，例如两个矩形都是九个点，从而判断这个点处于第几个矩形
            int val = random.nextInt(sum[n]) + 1;
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (sum[mid] >= val) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            int[] cur = rs[r - 1];
            //然后基于矩形的左下标去加，加的范围不超过右上方的节点到左下方节点的长度，+1是为了可以选择边界值
            int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0];
            int y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];

            return new int[]{x, y};
        }
    }


}
