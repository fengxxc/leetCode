package junior;

import model.Node;
import util.Nodes;

/**
 * @author fengxxc
 *
 * N 叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 *  
 *
 * 示例 1：
 *      1
 *    / | \
 *   3  2  4
 *  / \
 * 5   6
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 *        1
 *   /  /   \   \
 *  2   3   4   5
 *     / \  |  / \
 *    6  7  8 9  10
 *       |  | |
 *      11 12 13
 *      |
 *     14
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 104] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 */
public class _559_MaximumDepthOfNaryTree {
    /**
     * 2021/08/31 19:12 一周目
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        if (root.children == null) {
            return max;
        }
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i)) + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _559_MaximumDepthOfNaryTree().maxDepth(Nodes.instance(new Integer[]{1, null, 3, 2, 4, null, 5, 6})));
        System.out.println(new _559_MaximumDepthOfNaryTree().maxDepth(Nodes.instance(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14})));
    }
}
