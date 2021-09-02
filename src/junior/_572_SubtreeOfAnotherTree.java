package junior;

import model.TreeNode;
import util.TreeNodes;

/**
 * @author fengxxc
 *
 * 另一棵树的子树
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *  
 * 示例 1：
 *      root
 *       3
 *      /  \        sybRoot
 *    4     5         4
 *   /  \            /  \
 * 1     2         1     2
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 *      root
 *       3
 *      /  \       subRoot
 *    4     5        4
 *   /  \           /  \
 * 1     2        1     2
 *      /
 *    0
 *
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 */
public class _572_SubtreeOfAnotherTree {

    /**
     * 2021/09/02 15:20 一周目
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode node, TreeNode node1) {
        if (node == null && node1 == null) {
            return true;
        }
        if (node == null || node1 == null) {
            return false;
        }
        if (node.val != node1.val) {
            return false;
        }
        return isSameTree(node.left, node1.left) && isSameTree(node.right, node1.right);
    }

    public static void main(String[] args) {
        // System.out.println(TreeNodes.toString(TreeNodes.instance(new Integer[]{3, 4, 5, 1, 2})));
        // System.out.println(TreeNodes.toString(TreeNodes.instance(new Integer[]{3,4,5,1,2,null,null,null,null,0})));
        System.out.println(new _572_SubtreeOfAnotherTree().isSubtree(TreeNodes.instance(new Integer[]{3, 4, 5, 1, 2}), TreeNodes.instance(new Integer[]{4, 1, 2})));
        System.out.println(new _572_SubtreeOfAnotherTree().isSubtree(TreeNodes.instance(new Integer[]{3,4,5,1,2,null,null,null,null,0}), TreeNodes.instance(new Integer[]{4, 1, 2})));
    }
}
