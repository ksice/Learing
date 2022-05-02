package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Version : 1.0
 * @Creation : 2022/4/2 下午4:57
 * @Author : ksice_xt
 */
public class Test1 {

    /**
     * Community = [
     * {
     * "super_market": false,
     * "school": true,
     * "hospital": false
     * },
     * {
     * "super_market": true,
     * "school": false,
     * "hospital": false
     * },
     * {
     * "super_market": true,
     * "school": true,
     * "hospital": false
     * },
     * {
     * "super_market": false,
     * "school": true,
     * "hospital": false
     * },
     * {
     * "super_market": false,
     * "school": true,
     * "hospital": true
     * },
     * <p>
     * ]
     * Requirements: ['super_market', 'school']
     *
     * @param args
     */
    public static void main(String[] args) {
    }

//    public static List<String> v1(Object[] str, String[] target) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        int min = str.length;
//
//        for (int i = 0, j = str.length; i < j; i++) {
//
//            for (int k = 0; k < target.length; k++) {
//                int l = i;
//                int r = i;
//
//                int ans = 0;
//
//                while (l > 0 && r < str.length) {
//                    String s = str[l--];
//
//                    String item = str[r++];
//
//                    if (target[k].equals(s)) {
//                        int cha = l - i;
//                        ans = cha > ans ? cha : ans;
//                        break;
//                    }
//
//                    if (item.equals(target[k])) {
//                        int cha = r - i;
//                        ans = cha > ans ? cha : ans;
//                        break;
//                    }
//
//                }
//
//                min = ans < min ? ans : min;
//
//                map.put(i, ans);
//            }
//
//        }
//
//
//        return null;
//    }
}
