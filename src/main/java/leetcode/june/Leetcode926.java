package leetcode.june;

/**
 * @Version : 1.0
 * @Creation : 2022/6/11 上午11:03
 * @Author : ksice_xt
 */

public class Leetcode926 {
    public static void main(String[] args) {
        System.out.println('0' - '0');
    }

    //前缀和做法
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        //l表示当前位置及前面1的个数，r表示当前位置后面0的个数
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') r++;
        }
        //初试化res为整个s中0的个数（即表示把所有的0都翻为1）
        int res = r;
        //遍历，寻找最少操作数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                l++;
            }
            if (s.charAt(i) == '0') {
                r--;
            }
            //l+s表示将当前位置前面的1全面翻转为0，后面的0全部翻转为1的总操作数
            res = Math.min(res, l + r);
        }
        return res;
    }
}
