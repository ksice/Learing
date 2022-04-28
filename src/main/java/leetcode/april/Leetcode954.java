package leetcode.april;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 二倍数对数组
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -100000 <= arr[i] <= 100000
 *
 * @Version : 1.0
 * @Creation : 2022/4/1 上午11:26
 * @Author : ksice_xt
 */
public class Leetcode954 {
    //最大值不超过100000,所以多赋值10怕下标越界，平铺张开，然后因为2* x所以m是两倍
    static int N = 100010, M = N * 2;
    //然后有正负值就有双倍乘以2
    static int[] cnts = new int[M * 2];

    public static void main(String[] args) {
        canReorderDoubled(new int[]{4, -2, 2, -4});
    }

    /**
     * 看了大半个小时终于看懂了，看懂之后突然发现这个原理很简单，果然是我太菜了
     *
     * @param arr
     * @return
     */
    public static boolean canReorderDoubled(int[] arr) {
        // cnts 数组是静态的，所以每次调用非静态方法时先清零
        Arrays.fill(cnts, 0);

        //优先队列先将数据取绝对值进行排序，用于后面先将小的先++赋值，后面大的进行--清空
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));

        for (int i : arr) {
            q.add(i);
        }

        //然后通过zeroCount标志位判断是不是全是二倍数对数组，防止后面再去循环cnts数组一次
        int zeroCount = 0;

        while (!q.isEmpty()) {

            //最精华的部分，先将数组数据取出来，然后判断自己是不是某个数的两倍
            //x代表原有数，t代表两倍，
            int x = q.poll(), t = x * 2;

            //例如一个第一次x为2 然后t就是4，这时候m+t就是100004 然后下标100004为一，这时候如果数组里面有个4
            //那么x+M就是100004，正好匹配上于是--为0
            if (cnts[x + M] != 0) {
                cnts[x + M]--;
                zeroCount--;
                continue;
            }

            zeroCount++;

            //然后t+M就是将自身的两倍下标位置为1，然后等数组里面如果有一个是这个x的两倍的数字，
            // 那么他在上面x+M的时候就会不为0，然后就--掉，这样就认为有一组数字是成对的
            cnts[t + M]++;
        }

        return zeroCount == 0;
    }

}
