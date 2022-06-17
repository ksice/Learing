package leetcode.june;

/**
 * @Version : 1.0
 * @Creation : 2022/6/17 上午10:30
 * @Author : ksice_xt
 */
public class Leetcode1089 {
    public void duplicateZeros(int[] arr) {
        int i = 0, j = 0, n = arr.length;
        //去得出只需要arr的i长度即可复写填满数组
        while (j < n) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        //因为数组从0开始，否则会越界
        i--;
        j--;

        //[1,0,2,3,0,4,5,0]例如这个这时候i的长度就是6，j是8
        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            //这个&&会短路所以不用考虑后面减减
            if (arr[i] == 0 && --j > 0) {
                //这就是复写0
                arr[j] = 0;
            }
            --i;
            --j;
        }
    }
}
