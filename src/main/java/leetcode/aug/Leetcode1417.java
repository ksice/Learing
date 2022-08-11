package leetcode.aug;

import leetcode.april.Leetcode417;

import java.util.ArrayList;
import java.util.List;

/**字符串组合
 * @author ksice
 * @since 2022-08-11 下午3:52
 */
public class Leetcode1417 {

    public static void main(String[] args) {

        Leetcode1417 l = new Leetcode1417();
        l.reformat("a0b1c2");
    }

    public String reformat(String s) {

        List<Character> strings = new ArrayList<>();

        List<Character> number = new ArrayList<>();

        char[] chars = s.toCharArray();

        for (char item : chars) {
            if (item >= 'a') {
                strings.add(item);
            } else {
                number.add(item);
            }
        }
        int ss = strings.size();
        int ns = number.size();

        StringBuilder ans = new StringBuilder();

        if (ss == ns || ss + 1 == ns || ns + 1 == ss) {
            int max = Math.max(ss, ns);

            for (int i = 0; i < max; i++) {

                if(ss>=ns){
                    if (i <= ss - 1) {
                        ans.append(strings.get(i));
                    }
                    if (i <= ns - 1) {
                        ans.append(number.get(i));
                    }
                }else{
                    if (i <= ns - 1) {
                        ans.append(number.get(i));
                    }
                    if (i <= ss - 1) {
                        ans.append(strings.get(i));
                    }
                }

            }
            return ans.toString();
        } else {
            return "";
        }
    }
}
