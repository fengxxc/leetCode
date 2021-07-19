package medium;

import model.TreeNode;

import java.util.*;

/**
 * @author fengxxc
 *
 * 二叉树的层序遍历
 * 
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class _102_BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        final List<List<Integer>> res = new ArrayList<>();

        queue.add(root);

        while (queue.size() != 0) {
            List<Integer> level = new ArrayList<>();
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {
        // 1
        testcase1();

        // 2
        testCase2();
    }

    private static void testcase1() {
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        final List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> level : lists) {
            System.out.println(Arrays.toString(level.toArray()));
        }
    }

    private static void testCase2() {
        final TreeNode root2 = null;
        final List<List<Integer>> lists2 = levelOrder(root2);
        for (List<Integer> level : lists2) {
            System.out.println(Arrays.toString(level.toArray()));
        }
    }

}
