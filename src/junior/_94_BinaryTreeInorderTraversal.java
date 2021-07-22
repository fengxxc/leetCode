package junior;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fengxxc
 *
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *  
 *
 * 示例 1：
 *    1
 *     \
 *      2
 *    /
 *   3
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 *    1
 *   /
 *  2
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 示例 5：
 *    1
 *     \
 *      2
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class _94_BinaryTreeInorderTraversal {
    // 递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    // 迭代
    public static List<Integer> inorderTraversal2(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // Morris 官方题解
    public static List<Integer> inorderTraversal3(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前root节点向左走一步，然后一直向右走直至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让predecessor的右指针指向root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
                continue;
            }
            // 如果没有左孩子，则直接访问又孩子
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 根据 颜色标记法 改编
    public static List<Integer> inorderTraversal4(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<Object> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final Object node = stack.pop();
            if (node == null) continue;
            if (node instanceof TreeNode) {
                TreeNode treeNode = ((TreeNode) node);
                stack.push(treeNode.right);
                stack.push(treeNode.val);
                stack.push(treeNode.left);
            } else {
                res.add((Integer) node);
            }
        }
        return res;
    }

}
