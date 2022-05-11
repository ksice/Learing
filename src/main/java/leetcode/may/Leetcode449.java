package leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 将查询二叉树序列化和反序列化
 *
 * @Version : 1.0
 * @Creation : 2022/5/11 上午11:27
 * @Author : ksice_xt
 */
public class Leetcode449 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();

        dfs(root, list);
        StringBuffer stringBuffer = new StringBuffer();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i));
            if (i != list.size() - 1) {
                stringBuffer.append(",");
            }
        }

        return stringBuffer.toString();
    }

    /**
     * 前序遍历
     *
     * @param root
     * @param strings
     */
    void dfs(TreeNode root, List<String> strings) {
        if (root == null) {
            return;
        }
        int val = root.val;
        strings.add(String.valueOf(val));
        dfs(root.left, strings);
        dfs(root.right, strings);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.split(",");
        TreeNode treeNode = dfs1(0, split.length - 1, split);

        return treeNode;
    }

    TreeNode dfs1(int l, int r, String[] ss) {

        if (l > r) {
            return null;
        }

        //得到当前的头结点
        int j = l + 1, t = Integer.parseInt(ss[l]);

        TreeNode ans = new TreeNode(t);

        while (j <= r && Integer.parseInt(ss[j]) <= t) {
            j++;
        }

        ans.left = dfs1(l + 1, j - 1, ss);

        ans.right = dfs1(j, r, ss);

        return ans;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
