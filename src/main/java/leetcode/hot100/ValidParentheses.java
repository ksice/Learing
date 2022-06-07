package leetcode.hot100;

/**Valid parentheses
 * @Version : 1.0
 * @Creation : 2022/6/7 上午10:47
 * @Author : ksice_xt
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            return  isValid(s.replace("()", "").replace("{}", "").replace("[]", ""));
        }else{
         return    "".equals(s);
        }
    }
}
