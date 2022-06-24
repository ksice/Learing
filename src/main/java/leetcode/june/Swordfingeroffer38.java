package leetcode.june;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Version : 1.0
 * @Creation : 2022/6/23 下午2:43
 * @Author : ksice_xt
 */
public class Swordfingeroffer38 {

    boolean[] valid = new boolean[10];

    public Set<String> strings = new HashSet<>();

    //回溯算法
    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        dfs(chars, 0, "");
        int size = strings.size();

        String[] item = new String[size];
        int i = 0;
        for (String b : strings) {
            item[i++] = b;
        }
        return item;
    }

    public void dfs(char[] items, int index, String s) {
        if (index == items.length) {
            strings.add(s);
            return;
        }

        for (int i = 0; i < items.length; i++) {
            if (!valid[i]) {
                //回溯精髓
                valid[i] = true;
                dfs(items, index + 1, s + items[i]);
                valid[i] = false;
            }
        }
    }


}
