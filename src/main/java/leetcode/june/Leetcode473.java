package leetcode.june;

import java.util.Arrays;

/**
 * @Version : 1.0
 * @Creation : 2022/6/1 上午10:28
 * @Author : ksice_xt
 */
public class Leetcode473 {

    public static void main(String[] args) {
        Leetcode473 leetcode473=new Leetcode473();
        leetcode473.makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3});
    }
    int[] ms;
    int t;

    public  boolean makesquare(int[] matchsticks) {
        this.ms=matchsticks;
        int sum = Arrays.stream(matchsticks).sum();
        int ite = sum % 4;
        if (ite != 0) {
            return false;
        }
        t = sum / 4;

        Arrays.sort(ms);

        return  dfs(matchsticks.length-1,new int[4]);
    }

    boolean dfs(int idx, int[] cur) {

        //如果是最后一条判断四条边是否一致
        if (idx == -1) {
            boolean ok = true;
            for (int i : cur) {
                if (i != t) {
                    ok = false;
                }
            }
            return ok;
        }
        for (int i = 0; i < 4; i++) {

            //每次将这个对象和四条边进行判断，判断四条边是否能满足
            int u = this.ms[idx];

            if (cur[i] + u > t) {
                continue;
            }
            cur[i] += u;
            if (dfs(idx - 1, cur)) {
                return true;
            }
            cur[i] -= u;
        }
        return false;
    }

}
