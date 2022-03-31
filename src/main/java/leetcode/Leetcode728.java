package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数
 *
 * @Version : 1.0
 * @Creation : 2022/3/31 上午10:43
 * @Author : ksice_xt
 */
public class Leetcode728 {

    public static void main(String[] args) {
        System.out.println(2 % 10);

    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();

        //指定标签，让循环中的循环可以直接跳到这个循环上
       out:for (int i = left; i <= right; i++) {
            int cur = i;

            //得出i的个位数例如123得到3
            while (cur != 0) {
                int i1 = cur % 10;

                //不能除尽就换下一位
                if (i1 == 0 || cur % i1 != 0) {
                     continue out;
                }
                //然后再除以10，取下一位数字，例如123 变成12在取模得到2，感觉这个方式很牛逼
                cur /= 10;

            }
            list.add(i);
        }
        return list;
    }
}
