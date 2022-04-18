package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * @Version : 1.0
 * @Creation : 2022/4/18 上午10:48
 * @Author : ksice_xt
 */
public class Leetcode386 {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0, j = 1; i < n; i++) {
            //乘以10找到十叉树最后一层然后开始dfs
            list.add(j);

            if (j * 10 <= n) {
                j *= 10;
            } else {
                //判断乘以10之后是否越界然后除以10开始+1，都是为了找到十叉树最后一层
                //j % 10 == 9 是因为这一层统计完了要往上一层统计
                while (j % 10 == 9 || j + 1 > n) {
                    j /= 10;
                }
                j++;
            }
        }
        return list;
    }
}
