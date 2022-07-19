package leetcode.july;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的日程安排表 I
 *
 * @author ksice
 * @since 2022-07-19 上午11:40
 */
public class Leetcode729 {

    class MyCalendar {

        List<int[]> list = new ArrayList<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {

            for (int[] item : list) {
                if (start < item[1] && end > item[0]) {
                    return false;
                }
            }
            list.add(new int[]{start, end});

            return true;
        }
    }

}
