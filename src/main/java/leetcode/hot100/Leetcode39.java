package leetcode.hot100;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/6/17 下午2:50
 * @Author : ksice_xt
 */
public class Leetcode39 {

    List<List<Integer>> lists = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates, 0, target);
        return lists;
    }

    public void dfs(int[] candidates, int u, int target) {
        //如果target小于0说明已经未负数不用往下找了
        if (target < 0) {
            return;
        }
        //如果为0就把path路径记录下来，其实本质上就类似一颗二叉树
        if (target == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i = u; i < candidates.length; i++) {
            if (candidates[i] <= target) {

                path.add(candidates[i]);
                dfs(candidates, i, target - candidates[i]);
                //回溯将之前记录清空重新找
                path.remove(path.size() - 1);
            }

        }
    }
}
