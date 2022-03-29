package leetcode;

import java.nio.file.Path;

/**
 * 考试的最大困扰度(滑动窗口问题)
 * https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/solution/a-fei-suan-fa-by-a-fei-8-5e0i/
 * 这个题解很详细
 *
 * @Version : 1.0
 * @Creation : 2022/3/29 上午11:01
 * @Author : ksice_xt
 */
public class Leetcode2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int _K = k;
        //寻找F的最大连续值
        int fCount = getcnt(answerKey, 'T', _K);

        //寻找T的最大连续值
        int tCount = getcnt(answerKey, 'F', _K);

        return Integer.max(fCount, tCount);
    }

    public int getcnt(String answerKey, char item, int k) {
        int length = answerKey.length();
        int res = 0;
        for (int r = 0, l = 0, cnt = 0; r < length; r++) {
            //计算从r开始有多少个item值
            if (answerKey.charAt(r) == item) {
                cnt++;
            }

            //当cnt超过k值说明r到l之间，通过修改值也已经不能再连续
            while (cnt > k) {

                //l++是为了将下标挪到item值的下一位
                if (answerKey.charAt(l++) == item) {
                    //移动左窗口下标，移到为item的值的地方，进行修改一次，然后将cnt次数减一
                    //同时l++移到item值的下一位置，重新计算下一个窗口内的连续值
                    cnt--;
                }
            }
            //r-l+1算出r-l窗口内最大连续值,+1是加上l本身
            res = Integer.max(r - l + 1, res);

        }
        return res;
    }
}
