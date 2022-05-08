package leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/5/8 上午11:31
 * @Author : ksice_xt
 */
public class Leetcode442 {

//    public List<Integer> findDuplicates(int[] nums) {
//
//        List<Integer> list = new ArrayList<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//
//            int index = Math.abs(nums[i]) - 1;
//            if (nums[index] > 0) {
//                nums[index] = -nums[index];
//            } else {
//                list.add(index + 1);
//            }
//        }
//
//        return list;
//    }

    public static void main(String[] args) {
        findDuplicates(new int[]{1, 1, 2});

    }

    /**
     * 原地哈希
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            int t = nums[i];

            //t-1==i说明这个值处于他所应该在的下标值,然后设置t<0是为了防止一个值被重复处理，因为处理后就变成负数了
            if (t < 0 || t - 1 == i) {
                continue;
            }

            //因为数组从0开始，那么例如t=3 那nums[2]如果等于3说明是重复的，因为上面已经校验过t-1==i
            //找到这个值后将这个重复值设置为负数
            if (nums[t - 1] == t) {
                list.add(t);
                nums[i] *= -1;
            } else {
                //如果不相等就开始进行位置交换，将t放到t-1的下标，然后将原有的t-1的下标值放到目前的i的下标，同时进行减一再次的进行判断
                int c = nums[t - 1];
                nums[t - 1] = t;
                nums[i--] = c;
            }
        }

        return list;
    }

}
