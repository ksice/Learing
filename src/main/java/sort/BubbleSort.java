package sort;

/**
 * @Version : 1.0
 * @Creation : 2022/5/20 上午10:24
 * @Author : ksice_xt
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 2};

        //n个数比较n-1次
        for (int i = 0; i < arr.length - 1; i++) {

            //每比较一次就下次就少比较一次
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int cur = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = cur;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
