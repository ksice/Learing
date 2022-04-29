package test;

/**
 * @Version : 1.0
 * @Creation : 2022/4/29 下午3:32
 * @Author : ksice_xt
 */
public class Test2 {

    public static void main(String[] args) {
        int[] s = new int[]{1, 2, 2, 4, 5};
        System.out.println(v2(s, 2));
    }

    public static int v1(int[] ints, int s) {
        int i = 0, j = ints.length - 1;
        int tar = 0;
        while (i <= j) {
            int c = (i + j) / 2;

            tar = c;

            if (ints[c] == s) {
                return c;
            }

            if (ints[c] > s) {
                j = c - 1;
            } else if (ints[c] < s) {
                i = c + 1;
            }
        }
        return tar;
    }


    public static int v2(int[] ints, int tar) {

        int l = 0;
        int r = ints.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (ints[mid] == tar) {

                return mid;
            }

            if (ints[mid] > tar) {
                r = mid + 1;
            } else if (ints[mid] < tar) {
                l = mid - 1;
            }
        }
        return -1;
    }

}
