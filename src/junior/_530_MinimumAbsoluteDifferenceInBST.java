package junior;

import model.TreeNode;
import util.TreeNodes;

/**
 * @author fengxxc
 *
 *  二叉搜索树的最小绝对差
 *
 *  给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 */
public class _530_MinimumAbsoluteDifferenceInBST {
    int last = -1;
    int min = Integer.MAX_VALUE;

    /**
     * 2021/08/27 15:21 一周目 是有点索然无味哦
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (last == -1) {
            last = root.val;
        } else {
            if (root.val - last < min) {
                min = root.val - last;
            }
            last = root.val;
        }

        dfs(root.right);
    }

    public static void main(String[] args) {
        // final TreeNode node = TreeNodes.instance(new Integer[]{1, null, 3, 2});
        // System.out.println(TreeNodes.toString(node));
        // System.out.println(new _530_MinimumAbsoluteDifferenceInBST().getMinimumDifference(node));

        final TreeNode node2 = TreeNodes.instance(new Integer[]{543, 384, 652, null, 445, null, 699});
        System.out.println(TreeNodes.toString(node2));
        System.out.println(new _530_MinimumAbsoluteDifferenceInBST().getMinimumDifference(node2));
    }
}
