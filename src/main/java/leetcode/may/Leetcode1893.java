package leetcode.may;

/**
 * 检查是否区域内所有整数都被覆盖
 *
 * @Version : 1.0
 * @Creation : 2022/5/17 上午11:33
 * @Author : ksice_xt
 */
public class Leetcode1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {

        for (int i = left; i <= right; i++) {

            boolean isValid = false;
            for (int j = 0; j < ranges.length; j++) {
                if (i >= ranges[j][0] && i <= ranges[j][1]) {
                    isValid = true;
                    continue;
                }
            }
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}
