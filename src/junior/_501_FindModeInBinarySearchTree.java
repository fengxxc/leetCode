package junior;

import model.TreeNode;
import util.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fengxxc
 *
 *  二叉搜索树中的众数
 *
 *  给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 */
public class _501_FindModeInBinarySearchTree {
    Integer base = -1;
    Integer count = 0;
    Integer max = Integer.MIN_VALUE;

    /**
     * 2021/08/27 14:16 一周目
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }
        final List<Integer> res = new ArrayList<>();
        dfs(root, res);
        // return res.stream().mapToInt(Integer::intValue).toArray();
        final int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        if (root.val != base) {
            base = root.val;
            count = 1;
        } else {
            count++;
        }
        if (max.equals(count)) {
            res.add(base);
        } else if (count > max) {
            max = count;
            res.clear();
            res.add(base);
        }
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        // final TreeNode node = TreeNodes.instance(new Integer[]{1, null, 2, 2});
        final TreeNode node = TreeNodes.instance(new Integer[]{1,null,2});
        System.out.println(TreeNodes.toString(node));
        final int[] res = new _501_FindModeInBinarySearchTree().findMode(node);
        System.out.println(Arrays.toString(res));
    }
}
