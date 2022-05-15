package leetcode.may;

import java.nio.file.Path;

/**
 * 最大三角形面积
 *
 * @Version : 1.0
 * @Creation : 2022/5/15 下午12:20
 * @Author : ksice_xt
 */
public class Leetcode812 {

    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; i++) {

            for (int j = i + 1; j < points.length; j++) {

                for (int k = j + 1; k < points.length; k++) {
                    int cur = cross(points[j][0] - points[i][0], points[j][1] - points[i][1],
                            points[k][0] - points[i][0], points[k][1] - points[i][1]);
                    ans = Math.max(ans, Math.abs(cur / 2.0));
                }
            }
        }
        return ans;
    }

    int cross(int a, int b, int c, int d) {
        //对于已知三个点
        //S = 1/2 * |(x2 - x1) * (y3-y1) - (y2 - y1) * (x3 - x1)向量叉乘除以2
        return a * d - c * b;
    }
}
