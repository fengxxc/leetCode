package junior;

import model.TreeNode;
import util.TreeNodes;

/**
 * @author fengxxc
 *
 * 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 */
public class _617_MergeTwoBinaryTrees {
    /**
     * 2021/09/03 15:10 一周目
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        final TreeNode node = new TreeNode(0);
        if (root1 == null) {
            node.val = root2.val;
            node.left = root2.left;
            node.right = root2.right;
        } else if (root2 == null) {
            node.val = root1.val;
            node.left = root1.left;
            node.right = root1.right;
        } else {
            node.val = root1.val + root2.val;
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }
        return node;
    }

    public static void main(String[] args) {
        final TreeNode node = new _617_MergeTwoBinaryTrees().mergeTrees(TreeNodes.instance(1, 3, 2, 5), TreeNodes.instance(2, 1, 3, null, 4, null, 7));
        System.out.println(TreeNodes.toString(node));
    }
}
