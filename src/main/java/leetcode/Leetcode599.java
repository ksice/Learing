package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ksice
 * @since 2022-03-14 下午4:51
 */
public class Leetcode599 {

    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0, size1 = list1.length; i < size1; i++) {
            map.put(list1[i], i);
        }

        int min = 10000;

        List<String> list = new ArrayList<>();

        for (int i = 0, size2 = list2.length; i < size2; i++) {
            String key = list2[i];
            if (!map.containsKey(key)) {
                continue;
            } else {
                int j = i + map.get(key);
                if (j < min) {
                    min = j;
                    list.clear();
                    list.add(key);
                } else if (j == min) {
                    list.add(key);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
