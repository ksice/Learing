package leetcode.april;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最常见的单词(简单模拟题)
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-common-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Version : 1.0
 * @Creation : 2022/4/17 上午11:21
 * @Author : ksice_xt
 */
public class Leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {

        char[] chars = paragraph.toCharArray();

        int length = chars.length;


        Set<String> set = new HashSet<>();

        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }

        Map<String, Integer> map = new HashMap<>();

        String ans = null;
        for (int i = 0; i < length; ) {

            //判断是否为字母
            if (!Character.isLetter(chars[i]) && ++i >= 0) {
                continue;
            }

            int j = i;

            while (j < length && Character.isLetter(chars[j])) {
                j++;
            }
            String s = paragraph.substring(i, j).toLowerCase();

            i = j + 1;

            if (set.contains(s)) {
                continue;
            }

            //如果key值不存在默认给0
            map.put(s, map.getOrDefault(s, 0) + 1);

            if (ans == null || map.get(s) > map.get(ans)) {
                ans = s;
            }
        }

        return ans;

    }
}
