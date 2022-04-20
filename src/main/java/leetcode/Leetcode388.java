package leetcode;

import java.util.Arrays;

/**
 * 文件的最长绝对路径
 *
 * @Version : 1.0
 * @Creation : 2022/4/20 上午10:42
 * @Author : ksice_xt
 */
public class Leetcode388 {
    static int[] has = new int[10010];

    public static void main(String[] args) {
        int i = lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }
    public static int lengthLongestPath(String input) {
        Arrays.fill(has, -1);

        int length = input.length(), ans = 0;

        for (int i = 0; i < length;) {

            int level = 0;
            while (i < length && input.charAt(i) == '\t' && ++level >= 0) {
                i++;
            }

            int j = i;

            boolean isDir = true;

            while (j < length && input.charAt(j) != '\n') {
                //判断是不是文件还是文件夹
                if (input.charAt(j++) == '.') {
                    isDir = false;
                }
            }

            Integer cur = j - i;

            //将
            Integer prev = level - 1 >= 0 ? has[level - 1] : -1;

            Integer path = prev + 1 + cur;
            System.out.println(path+"22");

            if (isDir) {
                has[level] = path;
                System.out.println(level+""+path);
            } else if (path > ans) {
                ans = path;
            }
            i = j + 1;
        }
        return ans;
    }
}
