package test;

/**
 * @Version : 1.0
 * @Creation : 2022/5/11 下午8:00
 * @Author : ksice_xt
 */
public class Test5 {

    public static void main(String[] args) {
        test(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
    }

    /**
     * 1,-2,3,10,-4,7,2,-5 18
     * <p>
     * o(n)
     */

    public static void test(int[] ints) {
        int max = 0, ans = 0;

        for (int i = 0; i < ints.length; i++) {
            max = Math.max(max + ints[i], ints[i]);

            ans = Math.max(max, ans);
        }
    }


    public static void mp(int[] a) {


        for (int i = a.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
