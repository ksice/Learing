package leetcode.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组序号转换
 *
 * @author ksice
 * @since 2022-07-28 上午10:30
 */
public class Leetcode1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();

        Arrays.sort(clone);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;

        for (int i = 0; i < clone.length; i++) {

            if (!map.containsKey(clone[i])) {
                map.put(clone[i], ++idx);
            }
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
