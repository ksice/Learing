package leetcode.july;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 行星碰撞
 *
 * @Version : 1.0
 * @Creation : 2022/7/13 下午3:10
 * @Author : ksice_xt
 */
public class Leetcode735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        //拿栈比较栈顶元素
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            boolean flag = true;
            //如果都是正数就不可能碰到，所以要有负数，栈顶元素必须大于0，否则就没必要比较
            while (flag &&!deque.isEmpty() && asteroid < 0 && deque.peekLast() > 0) {
                Integer integer = deque.peekLast();
                int b = -asteroid;
                if (integer >= b) {
                    flag = false;
                }
                //小于这个数就不保留出栈
                if (integer <= b) {
                    deque.pollLast();
                }
            }
            if (flag) {
                deque.addLast(asteroid);
            }
        }
        int size = deque.size();

        int[] ans = new int[size];

        while (deque.isEmpty()) {
            ans[--size] = deque.pollLast();
        }
        return ans;
    }
}
