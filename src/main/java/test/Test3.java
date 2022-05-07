package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version : 1.0
 * @Creation : 2022/5/6 下午7:40
 * @Author : 熊涛
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}{[]}"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * 输入：s = "()[]{}{[]}"
     * 输出：true
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     * 输入：s = "{{[()}]}"
     * 输出：false
     */
    public static boolean isValid(String s) {

        if (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            return isValid(s.replace("{}", "").replace("()", "").replace("[]", ""));
        } else {
            return "".equals(s);
        }
//        if ((s.length() & 1) == 1) {
//            return false;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//
//        Map<Character, Character> key = new HashMap<>();
//
//        key.put('{', '}');
//        key.put('(', ')');
//        key.put('[', ']');
//
//        String ss = "{([";
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (ss.indexOf(c) != -1) {
//
//                Integer orDefault = map.getOrDefault(c, 0);
//
//                map.put(c, ++orDefault);
//
//                int count = 0;
//
//                for (int j = s.length() - 1; j > i; j--) {
//                    char c1 = s.charAt(j);
//
//                    if (c1 == key.get(c)) {
//                        count++;
//                        if (map.get(c) == count) {
//                            if (((j - i + 1) & 1) == 1) {
//                                return false;
//                            }
//                            break;
//                        }
//                    } else if (j - 1 == i && count != key.get(c)) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
    }
}
