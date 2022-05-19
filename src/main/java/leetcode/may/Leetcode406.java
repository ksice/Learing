package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 根据身高重建队列
 *
 * @Version : 1.0
 * @Creation : 2022/5/19 下午12:22
 * @Author : ksice_xt
 */
public class Leetcode406 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(0, "1");
        list.add(1, "1");
        list.add(2, "1");

        list.add(2, "2");


        System.out.println(list);


    }

    /**
     * [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
     * [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
     * [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
     * [ 1, 3, 5 ]          [ 6, 1 ] 3
     * [ 1, 5 ]             [ 7, 1 ] 5
     * [ 1 ]                [ 7, 0 ] 1
     * [ [ 5, 0 ], [ 7, 0 ], [ 5, 2 ], [ 6, 1 ], [ 4, 4 ], [ 7, 1 ] ]
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        //按照身高降序，相同就升序排人数
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        List<int[]> ans = new ArrayList<int[]>();

        for (int[] item : people) {
            ans.add(item[1], item);
        }
        return ans.toArray(new int[ans.size()][]);
    }


}
