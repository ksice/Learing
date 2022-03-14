import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
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
