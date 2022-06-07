package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 *
 * @Version : 1.0
 * @Creation : 2022/6/7 下午2:44
 * @Author : ksice_xt
 */
public class Leetcode17 {
    //暴搜
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> list = new ArrayList<>();
        List<String> b;

        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            b = new ArrayList<>();
            String s = phoneMap.get(chars[i]);

            char[] chars1 = s.toCharArray();
            for (int j = 0; j < chars1.length; j++) {
                if (list.isEmpty()) {
                    char c = chars1[j];
                    b.add(String.valueOf(c));
                } else {
                    for (String item : list) {
                        b.add(item + chars1[j]);
                    }
                }
            }
            if(!b.isEmpty()){
                list = b;
            }
        }


        return list;

    }


}
