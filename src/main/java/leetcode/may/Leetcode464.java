package leetcode.may;

import java.util.HashMap;
import java.util.Map;

/**
 * can i win 博弈论（kill me）
 *
 * @Version : 1.0
 * @Creation : 2022/5/22 下午1:29
 * @Author : ksice_xt
 */
public class Leetcode464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (maxChoosableInteger * (maxChoosableInteger + 1) < (desiredTotal * 2)) {
            return false;
        }

        Map<Integer, Boolean> memory = new HashMap<>(1 << maxChoosableInteger);

        return dfs(maxChoosableInteger, 0, desiredTotal, 0, memory);
    }


    private boolean dfs(int maxChoosableInteger, int state, int desiredTotal, int curTotal, Map<Integer, Boolean> memory) {

        if (!memory.containsKey(state)) {
            boolean ans = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                //state的第i位表示 第i+1个数字被使用
                if (((state >> i) & 1) == 1) {
                    continue;
                }
                //先手取i看 能不能赢 不能赢则轮到对手取数字
                if (curTotal + i + 1 >= desiredTotal) {
                    ans = true;
                    break;
                }
                //轮到对手取数字 若对手不能赢（必然输掉的状态） 则我方赢
                //state | (1 << i), 将state的第i位置为已使用
                if (!dfs(maxChoosableInteger, state | (1 << i), desiredTotal, curTotal + i + 1, memory)) {
                    ans = true;
                    break;
                }
            }
            memory.put(state, ans);
        }
        return memory.get(state);
    }
}
