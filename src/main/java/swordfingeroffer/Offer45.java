package swordfingeroffer;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 把数组排成最小的数
 *
 * @Version : 1.0
 * @Creation : 2022/3/30 下午4:43
 * @Author : ksice_xt
 */
public class Offer45 {
    public static void main(String[] args) {
        minNumber(new int[]{
                10, 2, 3, 5, 4
        });
    }

    public static String minNumber(int[] nums) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }

        list.sort(new Comparator<String>() {
            //例如{10,2,3,5,4},102<201 那么把2放在前面，因为是要最小值
            //-1是升序，1是降序,字符串比较是比较第一位值
            @Override
            public int compare(String o1, String o2) {
                int i = (o1 + o2).compareTo(o2 + o1);
                return i;
            }
        });

        StringBuilder str = new StringBuilder();
        list.forEach(s -> {
            str.append(s);
        });

        return str.toString();

    }


}
