package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @Version : 1.0
 * @Creation : 2022/6/8 下午1:17
 * @Author : ksice_xt
 */
public class Leetcode22 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return list;
        }
        getParenthesis("", n, n);

        return list;
    }

    void getParenthesis(String str, int left, int right) {

        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }

        if (left == right) {
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }

}
