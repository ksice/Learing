package leetcode;


/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 链表可以选用迭代或递归方式完成反转
 * @Version : 1.0
 * @Creation : 2022/3/24 10:15 上午
 * @Author : ksice_xt
 */
public class Leetcode206 {

    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;

        ListNode cru = head;
        while (cru != null) {
            ListNode next = cru.next;
            //先将第一个node的next置为null然后第二次循环将上次循环的节点放置到next
            cru.next = pre;
            //将这次的节点放置到下次next使用
            pre = cru;
            //开始倒转下一个节点
            cru = next;
        }
        return pre;
    }

    //迭代
    public ListNode recurrence(ListNode head) {

        //分支最后一个节点next为空指针,head放前面分支空指针
        if (head == null || head.next == null) {
            return head;
        }
        //将最后的节点进行第一次处理出栈，对链表数据反着处理
        ListNode newNode = recurrence(head.next);

        //将下个节点的指针指向自己，反转指向
        head.next.next = head;
        //然后将自己的本身的指向置为null，留给下一个节点指向
        head.next = null;

        return newNode;
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
