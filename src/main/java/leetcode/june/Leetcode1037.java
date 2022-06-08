package leetcode.june;

/**
 *
 * Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.
 *
 * A boomerang is a set of three points that are all distinct and not in a straight line.
 *
 * @Version : 1.0
 * @Creation : 2022/6/8 下午12:05
 * @Author : ksice_xt
 */
public class Leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        //向量叉乘用来求三点的面积如果是0就代表着三点在一根直线上
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};

        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};

        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
