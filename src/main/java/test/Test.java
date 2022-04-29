package test;

import java.util.*;

/**
 * @Version : 1.0
 * @Creation : 2022/4/2 下午4:57
 * @Author : ksice_xt
 */
public class Test {

    public static void main(String[] args) {
        String[] strings = {"a","b","c","d"};
        v1(strings);
    }

    public static List<String> v1(String[] str) {
        Map<String, Integer> map = new HashMap<>();

        int n = str.length;

        int max = 0;
        for (int i = 0; i < n; i++) {
            Integer orDefault = map.getOrDefault(str[i], 0);
            orDefault += 1;
            map.put(str[i], orDefault);
            max = orDefault > max ? orDefault : max;
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == max) {
                list.add(m.getKey());
                System.out.println(m.getKey());
            }
        }

        return list;
    }
}
