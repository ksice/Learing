package test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Version : 1.0
 * @Creation : 2022/6/21 下午3:35
 * @Author : ksice_xt
 */
public class Test7 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);

        ListNode listNode1 = new ListNode(2);

        ListNode listNode2 = new ListNode(4);

        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(5);

        ListNode listNode5 = new ListNode(6);

        ListNode listNode6 = new ListNode(4);

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        addTwoNumbers(listNode, listNode4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        Deque<Integer> stack3 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode newHead = new ListNode(-1);
        test test=new test();
       // test.setVal(2);

        test test1=new test();
        test1.setVal(3);
        test.setVal(test1.getVal());

        test1.setVal(4);
        System.out.println(test.val);

        ListNode dump=newHead;
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || add != 0) {
            int sum = add;
            sum += stack1.isEmpty() ? 0 : stack1.poll();
            sum += stack2.isEmpty() ? 0 : stack2.poll();
            add = sum / 10;
            stack3.push(sum % 10);
        }

        while (!stack3.isEmpty()) {
            ListNode listNode = new ListNode(stack3.pop());
            newHead.next=listNode;
            newHead=listNode;
        }

        return dump;
    }

    public static class ListNode {
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

    public static class test {
        int val;
        test test;
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
