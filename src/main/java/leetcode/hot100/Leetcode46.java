package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 *
 * @author ksice
 * @since 2022-07-18 下午4:03
 */
public class Leetcode46 {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int length = nums.length;

        List<Integer> list = new ArrayList<>(length);

        //用boolean数组判断是否被选择
        boolean[] flag = new boolean[length];

        backtrace(nums, flag, list, 0);
        return lists;
    }

    public void backtrace(int[] nums, boolean[] flag, List<Integer> list, int count) {

        if (count == nums.length) {
            //需要重新拷贝否则会是空因为是引用
            lists.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {

                list.add(nums[i]);
                flag[i] = true;
                backtrace(nums, flag, list, count + 1);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
}
