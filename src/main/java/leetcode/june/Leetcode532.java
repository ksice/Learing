package leetcode.june;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version : 1.0
 * @Creation : 2022/6/16 上午11:55
 * @Author : ksice_xt
 */
public class Leetcode532 {
    //hash处理
    public int findPairs(int[] nums, int k) {

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        //先将所有的值的个数通过hash进行保存
        for (int obj : nums) {
            map.put(obj, map.getOrDefault(obj, 0) + 1);
        }

        for (int obj : nums) {

            //如果为0代表这个数已经比较过了
            if (map.get(obj) == 0) {
                continue;
            }
            if (k == 0) {
                //就是有两个一样的值就加1
                if (map.get(obj) > 1) ans++;
            } else {


                int a = obj - k, b = obj + k;


                //3, 1, 4, 1, 5
                //同一组数字只能一次当到5的时候减k为3这时候不会重复记录，因为3已经为0了
                if (map.getOrDefault(a, 0) > 0) {
                    ans++;
                }

                if (map.getOrDefault(b, 0) > 0) {
                    ans++;
                }
            }

            map.put(obj, 0);
        }

        return ans;
    }


}
