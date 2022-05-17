package leetcode.may;

import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/5/17 上午11:53
 * @Author : ksice_xt
 */
public class Leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        //循环进行排序，i越小越在前面order.charAt(i) - 'a' 例如h-a 为7 代表第七位是优先级最高的
        for (int i = 0; i < 26; i++) ord[order.charAt(i) - 'a'] = i;
        String[] clone = words.clone();

        //通过字母进行排序处理
        Arrays.sort(clone, (a, b)->{
            int n = a.length(), m = b.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                int c1 = a.charAt(i) - 'a', c2 = b.charAt(j) - 'a';

                if (c1 != c2) return ord[c1] - ord[c2];
                i++; j++;
            }
            if (i < n) return 1;
            if (j < m) return -1;
            return 0;
        });

        //将words的单词排好序然后和原先的word进行比较如果不一致报错
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (!clone[i].equals(words[i])) return false;
        }
        return true;
    }
}
