package leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 两棵二叉搜索树中的所有元素
 *
 * @Version : 1.0
 * @Creation : 2022/5/1 上午11:28
 * @Author : ksice_xt
 */
public class Leetcode1305 {

    //正无穷大值
    int max = 0x3f3f3f3f;

    //本来想bfs然后在集合遍历，题解dfs利用 bst二叉搜索树的特性，得到两棵树的有序集合，在进行归并排序
    //采用中序排序，得到有序集合
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);

        dfs(root2, list2);

        //将两个有序队列合并成一个有序队列,采用归并排序n(nlogn)
        int i = 0, j = 0, n1 = list1.size(), n2 = list2.size();

        List<Integer> ans = new ArrayList<>();

        while (i < n1 || j < n2) {

            //max作用是当i已经排序完之后，那么取一个最大值，分支后序的a继续++，b同理
            int a = i < n1 ? list1.get(i) : max;
            int b = j < n2 ? list2.get(j) : max;

            //谁小就先加谁
            if (a <= b) {
                ans.add(a);
                i++;
            } else {
                ans.add(b);
                j++;
            }
        }

        return ans;
    }

    void dfs(TreeNode root, List<Integer> list) {
        //通过root为null找到最底下那层
        if (root == null) {
            return;
        }
        //中序遍历，左根右
        //前序遍历，根左右
        //后序遍历，左右根

        //先查左节点，添加后再添加根节点，后面再查右节点
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
