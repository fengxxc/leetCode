package junior;

import model.TreeNode;
import util.TreeNodes;

import java.util.*;

/**
 * @author fengxxc
 *
 * 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 */
public class _257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private static void dfs(TreeNode root, String prePath, List<String> res) {
        if (root == null) {
            return;
        }
        String path = prePath + root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        dfs(root.left, path + "->", res);
        dfs(root.right, path + "->", res);
    }

    public static void main(String[] args) {
        final TreeNode node = TreeNodes.instance(new Integer[]{1, 2, 3, null, 5});
        System.out.println(TreeNodes.toString(node));
        final List<String> list = new _257_BinaryTreePaths().binaryTreePaths(node);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
