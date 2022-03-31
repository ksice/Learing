package swordfingeroffer;

/**
 * . 替换空格
 *
 * @Version : 1.0
 * @Creation : 2022/3/31 下午1:51
 * @Author : ksice_xt
 */
public class Offer05 {

    public String replaceSpace(String s) {

//      return   s.replace(" ","%20");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            stringBuilder.append(c == ' ' ? "%20" : c);
        }
        return stringBuilder.toString();
    }
}
