package junior;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fengxxc
 *
 * 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 *      谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 */
public class _226_InvertBinaryTree {

    // 递归
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode leftNode = dfs(root.left);
        final TreeNode rightNode = dfs(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    // 迭代 bfs
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                final TreeNode node = queue.poll();
                final TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left  != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // 迭代 dfs
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            for (int i = 0; i < stack.size(); i++) {
                final TreeNode node = stack.pop();
                final TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return root;
    }

}
