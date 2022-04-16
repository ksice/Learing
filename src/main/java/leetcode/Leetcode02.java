package leetcode;

import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/4/15 下午3:54
 * @Author : ksice_xt
 */
public class Leetcode02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);

        ListNode cur = listNode;
        //是否进位
        int carry = 0;

        while (l1 != null || l2 != null) {

            int l1val = l1 == null ? 0 : l1.val;

            int l2val = l2 == null ? 0 : l1.val;

            //节点相加再加上进位数
            int sum = l1val + l2val + carry;

            //得出进位数
            carry = sum / 10;

            //得出余位数
            sum = sum % 10;

            //将下个节点的next赋值结果值
            cur.next = new ListNode(sum);

            //然后将cur换成下一个节点
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //因为每个节点值最大为9
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return listNode.next;
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
