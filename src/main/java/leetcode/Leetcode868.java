package leetcode;

/**
 * 二进制间距
 *
 * @Version : 1.0
 * @Creation : 2022/4/24 下午2:04
 * @Author : ksice_xt
 */
public class Leetcode868 {

    public static void main(String[] args) {
        binaryGap(20);
    }

    public static int binaryGap(int n) {
        int ans = 0;

        for (int i = 31, j = -1; i >= 0; i--) {
            //找到1的位置
            if ((n >> i & 1) == 1) {

                //第一次找到1的位置不进行判断，必须要有两个1才进行距离判断
                if (j != -1) {
                    ans = Math.max(ans, j - i);
                }

                //找到一个1之后将第一个1的位置赋值
                j = i;
            }
        }
        return ans;
    }
}
