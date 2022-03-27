package swordfingeroffer;

import java.util.ArrayList;

/**
 * @Version : 1.0
 * @Creation : 2022/3/27 下午2:50
 * @Author : ksice_xt
 */
public class Offer06 {
    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {
        reverse(head);

        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }

    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        tmp.add(head.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
