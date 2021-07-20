package medium;

import model.TreeNode;

import java.util.*;

/**
 * @author fengxxc
 *
 * 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class _103_BinaryTreeZigzagOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean revel = false;
        while (!queue.isEmpty()) {
            final LinkedList<Integer> level = new LinkedList<>();
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                if (revel) {
                    level.addFirst(node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            revel = !revel;
        }
        return res;
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        final List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> level : lists) {
            System.out.println(Arrays.toString(level.toArray()));
        }
    }
}
