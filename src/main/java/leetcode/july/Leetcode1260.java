package leetcode.july;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维网格移动
 *
 * @author ksice
 * @since 2022-07-20 下午4:04
 */
public class Leetcode1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //将二维表格转成一维表进行计算
        int m = grid.length;
        int n = grid[0].length;

        int[][] item = new int[m][n];

        //m是行数，n是列数，现在一维的位置为i*n+j,i等于行数n为列数j为列的位置

        for (int i = 0, total = m * n; i < m; i++) {

            //所以移动后的位置为i*n+j +k
            for (int j = 0; j < n; j++) {
                //取余是怕超出total数
                int nxt = (i * n + j + k) % total;
                //nxt/n第几行，nxt%n第几列
                item[nxt / n][nxt % n] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(item[i][j]);
            }
            ans.add(list);
        }

        return ans;

    }
}
