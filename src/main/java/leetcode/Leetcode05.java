package leetcode;

import sun.jvm.hotspot.memory.StringTable;

/**
 * 最长回文子串
 *
 * @Version : 1.0
 * @Creation : 2022/4/2 上午10:51
 * @Author : ksice_xt
 */
public class Leetcode05 {

    public static void main(String[] args) {
        longestPalindrome("bb");
    }

    public static String longestPalindrome(String s) {

        int length = s.length();
        //小于两个直接返回
        if (length < 2) {
            return s;
        }

        //booleans默认是false
        boolean[][] booleans = new boolean[length][length];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < length; i++) {
            booleans[i][i] = true;
        }
        int begin = 0;
        int max = 1;
        //这个是算回文串长度，要加上=length的，否则子串长度为2的进不去判断
        for (int i = 2; i <= length; i++) {

            //从0开始遍历是否存在回文串
            for (int l = 0; l < length; l++) {

                //回文串长度为2，然后加上左边界得到右边界
                int r = i + l - 1;

                if (r >= length) {
                    break;
                }
                //如果不相等lr为false
                if (s.charAt(l) != s.charAt(r)) {
                    booleans[l][r] = false;
                } else {
                    //如果小于三就说明只有两个数字，里面没有包含子串
                    if (r - l < 3) {
                        booleans[l][r] = true;
                    } else {
                        //如果l和r为回文串，这时候判断它包含的内部子串是不是回文串,如果是就是true不是就是false
                        booleans[l][r] = booleans[l + 1][r - 1];
                    }
                }

                //得出最大值和起始点
                if (booleans[l][r] && r - l + 1 > max) {
                    max = r - l + 1;
                    begin = l;
                }
            }
        }

        return s.substring(begin, begin + max);
    }
}
