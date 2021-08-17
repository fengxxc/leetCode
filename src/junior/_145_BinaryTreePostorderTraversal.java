package junior;

import model.TreeNode;
import util.TreeNodes;

import java.util.*;

/**
 * @author fengxxc
 *
 * 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 */
public class _145_BinaryTreePostorderTraversal {
    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    // 迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        final LinkedList<Integer> res = new LinkedList<>();
        final Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop().left;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _145_BinaryTreePostorderTraversal().postorderTraversal(TreeNodes.instance(new Integer[]{1, null, 2, 3})).toArray()));
        System.out.println(Arrays.toString(new _145_BinaryTreePostorderTraversal().postorderTraversal2(TreeNodes.instance(new Integer[]{1, null, 2, 3})).toArray()));
    }
}


