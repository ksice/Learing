package leetcode.april;

/**
 * 旋转字符串（这个思路简直绝了）
 * 由于每次旋转操作都是将最左侧字符移动到最右侧，因此如果 goal 可由 s 经过多步旋转而来，
 * 那么 goal 必然会出现在 s + s 中，即满足 (s + s).contains(goal)，同时为了 s 本身过长导致的结果成立，我们需要先确保两字符串长度相等
 *
 * @Version : 1.0
 * @Creation : 2022/4/7 上午11:13
 * @Author : ksice_xt
 */
public class Leetcode796 {
    public boolean rotateString(String s, String goal) {
        boolean contains = (s + s).contains(goal);
        return s.length() == goal.length() && contains;
    }

    /**
     * kmp算法模板用来查找str里面是否存在pattern
     */
//
//    static int N = 10010;
//    int[] ne = new int[N];
//
//    public int kmp(String str, String pattern) {
//        if (pattern.length() == 0) {
//            return 0;
//        }
//        int m = str.length();
//        int n = pattern.length();
//        str = " " + str;
//        pattern = " " + pattern;
//        for (int i = 2, j = 0; i <= n; i++) {
//            while (j > 0 && pattern.charAt(i) != pattern.charAt(j + 1)) j = ne[j];
//            if (pattern.charAt(i) == pattern.charAt(j + 1)) j++;
//            ne[i] = j;
//        }
//
//        for (int i = 1, j = 0; i <= m; i++) {
//            while (j > 0 && str.charAt(i) != pattern.charAt(j + 1)) j = ne[j];
//            if (str.charAt(i) == pattern.charAt(j + 1)) j++;
//            if (j == n) {
//                j = ne[j];
//                // 一般用于书写匹配成功后的逻辑
//                return i - n;
//            }
//        }
//        return -1;
//
//    }
}
