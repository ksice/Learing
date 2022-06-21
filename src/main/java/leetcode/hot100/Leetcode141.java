package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 *
 * @Version : 1.0
 * @Creation : 2022/6/20 下午3:02
 * @Author : ksice_xt
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {

            //如果set已经存在则插入为false
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}
