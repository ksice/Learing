package leetcode.april;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Version : 1.0
 * @Creation : 2022/4/13 下午2:14
 * @Author : ksice_xt
 */
public class Leetcode380 {
    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.insert(1);
        randomizedSet.insert(3);
        randomizedSet.insert(6);

        randomizedSet.remove(1);

    }

    static class RandomizedSet {

        HashMap<Integer, Integer> hashMap = new HashMap();

        Random random = new Random();
        int[] ints = new int[200010];

        int index = -1;

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            }

            ints[++index] = val;
            hashMap.put(val, index);

            for (int i = 0; i < index + 1; i++) {
                System.out.println(ints[i]);
            }
            for (Map.Entry<Integer, Integer> m : hashMap.entrySet()) {
                System.out.println(m);
            }
            return true;
        }

        public boolean remove(int val) {
            if (!hashMap.containsKey(val)) {
                return false;
            }
            //返回的map 的value值
            Integer remove = hashMap.remove(val);

            //就是判断移除的是不是最后一个值，如果不是最后一个值就将，最后的值对应成移除的remove的下标
            if (remove != index) {
                hashMap.put(ints[index], remove);
            }

            //然后将最后的ints的值挪到数组的被移除的那个位置，同时index-1
            ints[remove] = ints[index--];

            return true;
        }

        public int getRandom() {
            return ints[random.nextInt(index + 1)];
        }
    }
}
