package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * three sum
 *
 * @Version : 1.0
 * @Creation : 2022/6/6 上午10:04
 * @Author : ksice_xt
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 2) {
            return lists;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //如果第一个数就是大于那后面都是大于0的直接跳过
            int num = nums[i];

            //第一个数字都大于0，后面肯定大于0
            if (num > 0) {
                break;
            }

            //如果和上个值一致就排除掉
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -num;

            //查找另外两个数字
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    lists.add(new ArrayList(Arrays.asList(num, nums[left], nums[right])));

                    //这时候查到值后要讲重复值进行过滤掉例如[-1,-1,-1,-1,2,2,2]

                    //判断下一个值是否和当前值一致,同时为了去重
                    right--;
                    left++;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    //小于目标值左下标移动
                    left++;
                } else {
                    right--;
                }
            }
        }

        return lists;
    }
}
