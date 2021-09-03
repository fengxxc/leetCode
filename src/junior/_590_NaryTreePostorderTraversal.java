package junior;

import model.Node;
import util.Nodes;

import java.util.*;

/**
 * @author fengxxc
 *
 * N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *  
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *  
 *
 * 示例 1：
 *
 *        1
 *     /  |  \
 *    3   2   4
 *  /  \
 * 5    6
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 *
 *          1
 *     /  |  \   \
 *    2   3   4   5
 *       / \  |   / \
 *     6   7  8  9  10
 *         |  |  |
 *        11 12 13
 *        |
 *        14
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 *  
 *
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class _590_NaryTreePostorderTraversal {
    /**
     * 2021/09/02 16:42 一周目
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        final LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        final Deque<Node> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            final Node node = stack.pollLast();
            res.addFirst(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.offerLast(node.children.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _590_NaryTreePostorderTraversal().postorder(Nodes.instance(1, null, 3, 2, 4, null, 5, 6)).toArray()));
        System.out.println(Arrays.toString(new _590_NaryTreePostorderTraversal().postorder(Nodes.instance(1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14)).toArray()));
    }
}