package leetcode.july;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Version : 1.0
 * @Creation : 2022/7/13 下午3:43
 * @Author : ksice_xt
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {

        Deque<Integer> deque = new ArrayDeque<>();

        while (head != null) {
            deque.addLast(head.val);
            head = head.next;
        }


        while (!deque.isEmpty()) {

            if(deque.size()==1){
                return true;
            }
            Integer integer = deque.pollFirst();
            if (!integer.equals(deque.pollLast())) {
                return false;
            }

        }

        return true;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
