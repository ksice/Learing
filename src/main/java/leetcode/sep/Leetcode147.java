package leetcode.sep;

/**
 * 插入排序
 *
 * @author ksice
 * @since 2022-09-07 上午11:01
 */
public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode ansNode = new ListNode(0);

        ansNode.next = head;

        //将原有的head赋值给lastsorted，curr代表next
        ListNode lastSorted = head, curr = head.next;

        while (curr != null) {
            //插入排序
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = ansNode;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                //将currnext进行存储
                lastSorted.next = curr.next;

                curr.next = prev.next;

                prev.next = curr;

            }

            curr = lastSorted.next;
        }

        return ansNode.next;

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
