package leetcode.may;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * @Version : 1.0
 * @Creation : 2022/5/7 下午2:18
 * @Author : ksice_xt
 */
public class Leetcode215 {
    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    /**
     * 小顶堆处理，还可以采用快排处理
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        //使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组
        //将堆进行升序排好序,堆顶就是我们所需要的元素,小顶堆，大顶堆设置Collections.reverseOrder()
        PriorityQueue<Integer> minheap = new PriorityQueue<>(k);

        //[3,2,1,5,6,4]
        //将前k个元素添加到minheap里
        for (int i = 0; i < k; i++) {
            minheap.offer(nums[i]);
        }
        //minheap[2,3]

        //将k后面的元素也添加到最小堆里面
        for (int i = k; i < len; i++) {
            //查看是否有必要替换
            Integer topElement = minheap.peek();
            if (nums[i] > topElement) {
                minheap.poll();
                minheap.offer(nums[i]);
            }
        }

        return minheap.peek();
    }
}
