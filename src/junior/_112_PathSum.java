package junior;

import model.TreeNode;
import util.TreeNodes;

/**
 * @author fengxxc
 *
 * 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *  
 *
 * 示例 1：
 *
 *          5
 *         /  \
 *       4     8
 *      /    /  \
 *    11    13    4
 *   /  \          \
 * 7     2           1
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 示例 2：
 *
 *       1
 *      /  \
 *    2     3
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *  
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 */
public class _112_PathSum {
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }

    private void dfs(TreeNode node, int targetSum, int parentSum) {
        if (node == null) {
            return;
        }
        if (res) {
            return;
        }
        final int sum = node.val + parentSum;
        if (sum == targetSum && node.left == null && node.right == null) {
            res = true;
            return;
        }
        dfs(node.left, targetSum, sum);
        dfs(node.right, targetSum, sum);
    }

    public static void main(String[] args) {
        // final TreeNode node = TreeNodes.instance(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        // final TreeNode node = TreeNodes.instance(new Integer[]{1, 2});
        final TreeNode node = TreeNodes.instance(new Integer[]{-2, null, -3});
        System.out.println(TreeNodes.toString(node));
        final boolean hasPathSum = new _112_PathSum().hasPathSum(node, -5);
        System.out.println(hasPathSum);
    }
}
