package leetcode.april;

/**
 * 交替位二进制数
 *
 * @Version : 1.0
 * @Creation : 2022/3/28 上午10:16
 * @Author : ksice_xt
 */
public class Leetcode693 {
    public static void main(String[] args) {
        hasAlternatingBits(5);
    }

    public static boolean hasAlternatingBits(int n) {
        //5 二进制0101 向右移动一位010
        //异或运算符 相同为0不同为1
        int a = n ^ (n >> 1);
        //异或所有结果都是1

        //与运算符  两个都为1才是1其他都是0
        // a的结果0111 +1之后 1000 进行与运算
        return (a & (a + 1)) == 0;
    }
}
