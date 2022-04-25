package leetcode;

import java.util.*;

/**
 * 随机数索引
 * hash表处理
 *
 * @Version : 1.0
 * @Creation : 2022/4/25 上午11:27
 * @Author : ksice_xt
 */
public class Leetcode398 {
    //
//    Random r = new Random();
//
//    Map<Integer, List<Integer>> map = new HashMap<>();
//
//    //hash表预处理，将数组提前处理,同时传入的是定长的数组，以空间换时间
//    public Leetcode398(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
//            orDefault.add(i);
//            map.put(nums[i], orDefault);
//        }
//    }
//
//    public int pick(int target) {
//        List<Integer> list = map.get(target);
//
//        Integer integer = list.get(r.nextInt(list.size()));
//
//        return list.get(integer);
//    }
//
//
//
    //蓄水池处理，因为假如数组没有定长，那么就没法进行预处理
    Random r = new Random();
    int nums[];

    //hash表预处理，将数组提前处理,同时传入的是定长的数组
    public Leetcode398(int[] _nums) {
        nums = _nums;
    }

    public int pick(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; i++) {
            //通过r.nextInt同等概率进行赋值，如果只有一个那么第一次进入nextint就是i值
            if (nums[i] == target) {
                cnt++;
                //第一次ans是1所以if百分比成功，后面的次数重新分配,以时间换空间，没有多余的空间创建
                if (r.nextInt(cnt) == 0) {
                    ans = i;
                }
            }

        }
        return ans;
    }


}
