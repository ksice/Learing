package swordfingeroffer;

/**左旋转字符串
 * @Version : 1.0
 * @Creation : 2022/3/31 下午2:23
 * @Author : ksice_xt
 */
public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        //这都没啥解释的了
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
