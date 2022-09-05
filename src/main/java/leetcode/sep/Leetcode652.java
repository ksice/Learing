package leetcode.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs+hash
 *
 * @author ksice
 * @since 2022-09-05 上午11:32
 */
public class Leetcode652 {
    List<TreeNode> ans = new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        return null;

    }

    String dfs(TreeNode node) {
        if (node == null) {
            return " ";
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(node.val);

        stringBuilder.append(dfs(node.left)).append(dfs(node.right));
        String key = stringBuilder.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);

        if (map.get(key) == 2) {
            ans.add(node);
        }
        return key;
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
