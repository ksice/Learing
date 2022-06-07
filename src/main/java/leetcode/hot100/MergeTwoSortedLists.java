package leetcode.hot100;

/**
 * Merge Two Sorted Lists
 * @Version : 1.0
 * @Creation : 2022/6/7 上午11:45
 * @Author : ksice_xt
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = list1;
        ListNode listNode2 = list2;
        ListNode pre = listNode;

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        while (listNode1.val != Integer.MAX_VALUE || listNode2.val != Integer.MAX_VALUE) {

            if (listNode1.val > listNode2.val) {
                pre.next = listNode2;
                listNode2 = listNode2.next == null ? new ListNode(Integer.MAX_VALUE) : listNode2.next;
            } else {
                pre.next = listNode1;
                listNode1 = listNode1.next == null ? new ListNode(Integer.MAX_VALUE) : listNode1.next;
            }
            pre = pre.next;
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
