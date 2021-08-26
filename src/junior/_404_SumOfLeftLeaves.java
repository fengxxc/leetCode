package junior;

import model.TreeNode;
import util.TreeNodes;

/**
 * @author fengxxc
 *
 * 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 */
public class _404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = dfs(root, false, 0);
        return res;
    }

    private int dfs(TreeNode root, boolean isLeft, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? sum += root.val : sum;
        }
        return dfs(root.left, true, sum) + dfs(root.right, false, sum);
    }

    public static void main(String[] args) {
        final TreeNode node = TreeNodes.instance(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(TreeNodes.toString(node));
        System.out.println(new _404_SumOfLeftLeaves().sumOfLeftLeaves(node));
    }
}
