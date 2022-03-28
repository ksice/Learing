package leetcode;

/**
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * 字典序就是根据数字的前缀进行排序，
 * <p>
 * 比如 10 < 9，因为 10 的前缀是 1，比 9 小。
 * <p>
 * 再比如 112 < 12，因为 112 的前缀 11 小于 12
 *
 * @Version : 1.0
 * @Creation : 2022/3/23 4:40 下午
 * @Author : ksice_xt
 */
public class Leetcode440 {
    public static void main(String[] args) {
        findKthNumber(16, 5);
    }

    /**
     * n是边界，k是第几位数字
     *
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber(int n, int k) {

        int cur = 1;

        int prefix = 1;

        while (cur < k) {
            //得出prefix前缀的值个数
            int count = count(n, prefix);

            //判断前缀的个数是不是大于k，大于k代表k属于prefix的前缀值中
            if (cur + count > k) {
                prefix *= 10; //往下层遍历
                cur++;
            } else {
                prefix++;
                //默认cur是1是为了将边缘最大值包含在内，例如n10 k2,同时只有将cur下标逐渐往前加1
                //先基于k去循环，然后经过m次循环找到前缀值，然后将前缀值依次加上k-m-1，
                //例如10 和2 循环第一次找到为1的前缀，然后再加上剩余的次数1-1，答案为10
                //例如15和4 循环第一次找到为1的前缀 ，然后再加上剩余的次数3-1 答案为12
                cur += count;
            }
        }
        return prefix;
    }

    private static int count(int n, int prefix) {
        long cur = prefix;

        //通过加1得出以cur前缀的值有多少个
        long next = cur + 1;

        int count = 0;

        while (cur <= n) {

            //第一层算完，例如cur是1 next为2，减去为1 个位数的情况下是1
            //            count += next - cur;
            //需要比较next和n大小，防止next超出n，同时n+1再减是为了把n本身算上,例如cur为1 n为10
            count += Math.min(n + 1, next) - cur;//下一峰头减去此峰头
            //往下一层走乘以10，同时next也乘以10，例如1和2
            //同时第二层减去为10通过count相加得出cur为前缀的值的总数
            cur *= 10;

            next *= 10;
        }

        return count;
    }
}
