package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/5/20 下午4:27
 * @Author : ksice_xt
 */
public class MergeSort {

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 8, 10, 12};
        int b[] = {8, 9, 13};

        int i = 0, j = 0;
        int n = a.length, m = b.length;
        List<Integer> list = new ArrayList<>();
        while (i < n || j < m) {
            int c = i < n ? a[i] : Integer.MAX_VALUE;

            int d = j < m ? b[j] : Integer.MAX_VALUE;

            if (c <= d) {
                list.add(c);
                ++i;
            } else {
                list.add(d);
                ++j;
            }
        }

        for (Integer s : list) {
            System.out.println(s);
        }
    }
}
