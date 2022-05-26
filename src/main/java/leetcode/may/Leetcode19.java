package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/25 下午2:28
 * @Author : ksice_xt
 */
public class Leetcode19 {

    /**
     * 可用栈先进后出进行倒序或者双指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode listNode = new ListNode(0, head);

        ListNode first = head;

        ListNode second = listNode;

        //让first和second隔n个距离
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        //这样的话first比second早n个结束,就可以得到倒数的个数
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

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
