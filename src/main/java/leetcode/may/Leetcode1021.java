package leetcode.may;

import java.util.Stack;

/**
 * 删除最外层的括号
 * @Version : 1.0
 * @Creation : 2022/5/28 下午12:30
 * @Author : ksice_xt
 */
public class Leetcode1021 {
    public String removeOuterParentheses(String s) {

        //采用栈或者计数方式都可以
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ')') {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                stringBuilder.append(chars[i]);
            }

            if (chars[i] == '(') {
                stack.push(chars[i]);
            }
        }

        return stringBuilder.toString();

    }
}
