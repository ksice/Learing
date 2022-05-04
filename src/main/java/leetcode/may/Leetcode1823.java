package leetcode.may;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 找出游戏的获胜者
 *
 * @Version : 1.0
 * @Creation : 2022/5/4 上午10:03
 * @Author : ksice_xt
 */
public class Leetcode1823 {
    /**
     * 模拟+队列先进先出
     *
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {

            for (int i = 1; i < k; i++) {
                //从1开始，已经第k位要被移除，将k位之前的值取出重新推进队列，fifo先进先出
                queue.offer(queue.poll());
            }

            queue.poll();
        }

        return queue.peek();
    }

}
