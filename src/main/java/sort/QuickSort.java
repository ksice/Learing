package sort;

/**
 * @Version : 1.0
 * @Creation : 2022/5/20 上午10:25
 * @Author : ksice_xt
 */
public class QuickSort {

    public static void main(String[] args) {
        int i;
        int a[] = {2, 7, 8, 5, 4, 3, 1,};

        quickSort(a, 0, a.length - 1);

        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j]);
        }
    }

    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int x, j, k;

            j = l;
            k = r;
            x = a[j];

            while (j < k) {

                //从右到左第一个小于x的数
                while (j < k && a[k] > x) {
                    k--;
                }
                //将右边和左边的数字互换
                if (j < k) {
                    a[j++] = a[k];
                }

                //从左到右第一个大于x的数
                while (j < k && a[j] < x) {
                    j++;
                }
                if (j < k) {
                    a[k--] = a[j];
                }
            }

            //第一位查完比较第二位
            a[j] = x;

            quickSort(a, j, r - 1);

            quickSort(a, j + 1, r);
        }
    }
}
