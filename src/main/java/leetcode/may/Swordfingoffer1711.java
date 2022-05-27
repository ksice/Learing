package leetcode.may;

/**
 * @Version : 1.0
 * @Creation : 2022/5/27 下午3:03
 * @Author : ksice_xt
 */
public class Swordfingoffer1711 {

    public int findClosest(String[] words, String word1, String word2) {

        int q = -1, p = -1;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (word.equals(word1)) {
                q = i;
            }

            if (word.equals(word2)) {
                p = i;
            }
            if (q != -1 && p != -1) {
                int abs = Math.abs(q - p);
                ans = Math.min(ans, abs);
            }
        }
        return ans;
    }

}
