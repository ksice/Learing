package leetcode.may;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 最近的请求次数
 *
 * @Version : 1.0
 * @Creation : 2022/5/6 上午10:22
 * @Author : ksice_xt
 */
public class Leetcode933 {

    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

}
