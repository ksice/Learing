package leetcode.april;

import java.util.HashSet;
import java.util.Set;

/**
 * 唯一摩尔斯密码词
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 *
 * @Version : 1.0
 * @Creation : 2022/4/10 下午1:12
 * @Author : ksice_xt
 */
public class Leetcode804 {


    public int uniqueMorseRepresentations(String[] words) {
        String[] mos = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                stringBuilder.append(mos[c - 'a']);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}
