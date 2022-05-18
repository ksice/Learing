package leetcode.may;

/**
 * 乘法表中第k小的数
 *
 * @Version : 1.0
 * @Creation : 2022/5/18 上午11:10
 * @Author : ksice_xt
 */
public class Leetcode668 {

    public static void main(String[] args) {
        findKthNumber(3, 4, 6);
    }

    public static int findKthNumber(int _m, int _n, int _k) {

        int l = 1, r = _m * _n;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0;

            //m 代表行 n代表列数
            //例如m 3 n 4 mid 6 2
            //6除以1说明第一行的全部小于他
            //1 2 3 4
            //2 4 6 8
            //3 6 9 12
            //计算每一行小于等于x的个数
            for (int i = 1; i <= _m; i++) {
                count += Math.min((mid / i), _n);
            }
            //判断当前小于的数量是否大于k
            if (count >= _k) {
                //说明k太大要变小一些，右下边左移
                r = mid;
            } else {
                //左下标右移
                l = mid + 1;
            }
        }
        return l;
    }


}
