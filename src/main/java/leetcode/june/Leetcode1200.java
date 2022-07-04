package leetcode.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 绝对值最小差
 *
 * @Version : 1.0
 * @Creation : 2022/7/4 上午11:22
 * @Author : ksice_xt
 */
public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> lists = new ArrayList<>();

        int min = arr[1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            int item = arr[i + 1] - arr[i];
            if (item < min) {
                lists.clear();
                min = item;
            }

            if (item == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                lists.add(list);
            }
        }

        return lists;
    }

}
