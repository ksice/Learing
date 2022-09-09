package leetcode.sep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ksice
 * @since 2022-09-08 下午3:19
 */
public class Leetcode382 {

//    Random random = new Random(10000);
//    List<Integer> list = new ArrayList<>();
//
//
//    public Leetcode382(ListNode head) {
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//    }
//
//    public int getRandom() {
//        int index = random.nextInt(list.size());
//
//        return list.get(index);
//    }


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

    //蓄水池抽样管理,将池子中的抽样出的对象，同时保证这些对象概率一致

    ListNode listNode;

    Random random = new Random(10000);

    public Leetcode382(ListNode head) {
        listNode = head;
    }

    public int getRandom() {
        int index = 0, ans = 0;
        ListNode t = listNode;
        while (t != null && ++index >= 0) {
            if (random.nextInt(index) == 0) {
                ans = t.val;
            }
            t = t.next;
        }
        return ans;
    }


}


