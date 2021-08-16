package junior;

import model.TreeNode;
import util.TreeNodes;

/**
 * @author fengxxc
 *
 * 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *  
 *
 * 示例 1：
 *
 *    3
 *  /  \
 * 9    20
 *     /  \
 *    15   7
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *          1
 *        /  \
 *       2    2
 *     /  \
 *    3    3
 *  /  \
 * 4    4
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 */
public class _110_BalancedBinaryTree {
    // 自顶向下
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 自底向上
    public boolean isBalanced2(TreeNode root) {
        return height2(root) != -1;
    }

    private static int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        final int leftHeight = height2(node.left);
        if (leftHeight < 0) {
            return -1;
        }
        final int rightHeight = height2(node.right);
        if (rightHeight < 0) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight , rightHeight) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodes.instance(new Integer[]{1,2,2,3,null,null,3,4,null,null,4});
        System.out.println(TreeNodes.toString(root));
        final boolean balanced = new _110_BalancedBinaryTree().isBalanced(root);
        System.out.println(balanced);
    }
}


