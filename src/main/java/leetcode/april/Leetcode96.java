package leetcode.april;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * <p>
 * 标签：动态规划
 * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
 * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
 * <p>
 * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
 * f(i) = G(i-1)*G(n-i)f(i)=G(i−1)∗G(n−i)
 * <p>
 * 综合两个公式可以得到 卡特兰数 公式
 * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
 * <p>
 *题解https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
 * @Version : 1.0
 * @Creation : 2022/4/7 下午2:41
 * @Author : ksice_xt
 */
public class Leetcode96 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
    }
    public int numTrees(int n) {
        //搜索二叉树的左节点要小于节点值，右节点大于节点值
        //动态规划是用来统计最值，然后上个情况的解会用于下个情况
        int[] dp = new int[n + 1];
        //如果n是1那么组合方式只有一种
        dp[0] = 1;
        dp[1] = 1;
        //一个节点的组合方式只有一种所以是1，然后计算从2个节点的组合开始开始
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
