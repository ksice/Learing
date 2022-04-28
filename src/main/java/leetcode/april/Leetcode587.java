package leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 安装栅栏
 * 凸包算法
 *
 * @Version : 1.0
 * @Creation : 2022/4/23 上午10:29
 * @Author : ksice_xt
 */
public class Leetcode587 {

    public int[][] outerTrees(int[][] trees) {

        int n = trees.length, tp = 0;
        //如果小于4个点，那么三个点都是坐标，三点成面
        if (n < 4) {
            return trees;
        }

        Arrays.sort(trees, (a, b) -> {
            //将每个点进行排序，如果x轴相同则按y轴排序，升序
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] stk = new int[n + 10];

        boolean[] vis = new boolean[n + 10];

        stk[++tp] = 0;

        //获取下包部分
        for (int i = 1; i < n; i++) {

            int[] c = trees[i];

            while (tp >= 2) {
                int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                if (getArea(a, b, c) < 0) {
                    vis[stk[tp--]] = false;
                } else {
                    break;
                }
            }
            stk[++tp] = i;
            vis[i] = true;
        }

        int size = tp;

        //获取上包部分
        for (int i = n - 1; i >= 0; i--) {
            if (vis[i]) {
                continue;
            }
            int[] c = trees[i];

            while (tp > size) {
                int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                if (getArea(a, b, c) < 0) {
                    tp--;
                } else {
                    break;
                }
            }
            stk[++tp] = i;
        }

        int[][] ans = new int[tp - 1][2];
        for (int i = 1; i < tp; i++) {
            ans[i - 1] = trees[stk[i]];
        }
        return ans;
    }

    //向量相减
    int[] subtraction(int[] a, int[] b) {
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    //叉乘
    double cross(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    // 向量 ab 转为 向量 ac 过程中扫过的面积
    double getArea(int[] a, int[] b, int[] c) {
        return cross(subtraction(b, a), subtraction(c, a));
    }


}


