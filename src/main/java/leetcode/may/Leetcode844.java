package leetcode.may;

import sun.misc.Regexp;

/**
 * @Version : 1.0
 * @Creation : 2022/5/24 下午3:21
 * @Author : ksice_xt
 */
public class Leetcode844 {
    public static void main(String[] args) {
        String str = "aa##";
    }

    //
    public boolean backspaceCompare(String s, String t) {
        String replace = replace(s);
        String replace1 = replace(t);

        return replace.equals(replace1);
    }

    String replace(String str) {
        if (str.length() > 0) {
            char c = str.charAt(0);
            if (c == '#') {
                str = str.substring(1, str.length() - 1);
            }
        }
        boolean contains = str.contains("#");
        if (contains) {
            str = str.replaceAll("[a-zA-Z\\d]#", "");
            return replace(str);
        }
        return str;
    }
}
