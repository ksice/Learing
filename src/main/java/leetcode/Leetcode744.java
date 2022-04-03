package leetcode;

/**
 * 寻找比目标字母大的最小字母
 *
 * @Version : 1.0
 * @Creation : 2022/4/3 上午9:31
 * @Author : ksice_xt
 */
public class Leetcode744 {

    public char nextGreatestLetter(char[] letters, char target) {

        int i = 0, j = letters.length - 1;

        //因为j不-1所以去除i=j的选项
        while (i < j) {

            int mid = (i + j) / 2;

            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                //目标字母大的最小字母，所以mid值作为右边界不动
                j = mid;
            }
        }

        return letters[j] > target ? letters[j] : letters[0];
    }

}
