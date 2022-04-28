package leetcode.april;

/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * <p>
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * <p>
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/image-smoother
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Version : 1.0
 * @Creation : 2022/3/25 下午1:55
 * @Author : ksice_xt
 */
public class Leetcode661 {

    /**
     * 朴素解法直接将周围九宫格的数据算出来相加求平均值
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];
        //将要加减的下标弄成二维数组多次循环生成二维数组结果
        int[][] dirs = new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tot = 0, cnt = 0;
                for (int[] di : dirs) {
                    int nx = i + di[0], ny = j + di[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    tot += img[nx][ny];
                    cnt++;
                }
                ans[i][j] = tot / cnt;
            }
        }

        return ans;
    }

    /**
     * 前缀和法，将当前节点包括之前的节点的总和得出，类似于计算营业额，每天都统计当天为止的总营业额，
     * 这样可以快速得出具体一个时间区域的营业额，
     * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/ru-he-qiu-er-wei-de-qian-zhui-he-yi-ji-y-6c21/
     * 这个题解很通俗易懂
     *
     * @param img
     * @return
     */
    public int[][] preImage(int[][] img) {
        int m = img.length, n = img[0].length;

        int[][] sum = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //max 0,i-1 得出最小值是0同时i-1和i+1得出九块方块
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);

                //m-1防止越界得到最后一个地址，同时i+1 得出九块地址
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);

                //得出总个方框数
                int cnt = (c - a + 1) * (d - b + 1);

                //因为辅助二维数组从1开始所以cd+1  ab相当og   c+1 d+1 相当od  a d+1相当于oe c+1 b 相当于OF
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ans[i][j] = tot / cnt;
            }
        }
        return ans;
    }


}
