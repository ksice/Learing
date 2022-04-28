package leetcode.april;

import javax.swing.tree.TreeNode;

/**
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Description : 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2022/3/19 5:27 下午</li>
 * <li>Author      : ksice_xt</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
public class Leetcode606 {
    StringBuilder stringBuilder = new StringBuilder();

    public String dfs(TreeNode root) {
        stringBuilder.append("(");
        stringBuilder.append(root.val);

        if (root.left != null) {
            dfs(root.left);
        } else if (root.right != null) {
            stringBuilder.append("()");

        }
        if (root.right != null) {
            dfs(root.right);
        }
        stringBuilder.append(")");

        return stringBuilder.substring(1, stringBuilder.length() - 1);
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
