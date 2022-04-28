package leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 山羊拉丁文
 *
 * @Version : 1.0
 * @Creation : 2022/4/21 上午10:23
 * @Author : ksice_xt
 */
public class Leetcode824 {

    public String toGoatLatin(String sentence) {

        String a = "a";
        String[] s = sentence.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            int i1 = "AEIOUaeiou".indexOf(s[i].substring(0, 1));
            String item = s[i];

            if (i1 == -1) {
                item = item.substring(1, item.length()) + item.substring(0, 1);
            }

            String ma = "ma";
            item = item + ma;
            for (int j = 0; j < i + 1; j++) {
                item += "a";
            }
            stringBuilder.append(item + " ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
