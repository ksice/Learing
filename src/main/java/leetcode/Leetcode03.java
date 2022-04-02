package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串（滑动窗口）
 *
 * @Version : 1.0
 * @Creation : 2022/4/2 下午3:54
 * @Author : ksice_xt
 */
public class Leetcode03 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        //滑动窗口左边界
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                //如果发现重复的，将left挪到前面那个字符的下标的下一位，然后通过max防止left往回走
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);

            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}
