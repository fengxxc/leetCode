package junior;

import model.Node;
import util.Nodes;

import java.util.*;

/**
 * @author fengxxc
 *
 * N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
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
 * 输出：[1,3,5,6,2,4]
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
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *  
 *
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 */
public class _589_NaryTreePreorderTraversal {
    private List<Integer> res = new ArrayList<>();

    /**
     * 2021/09/02 15:42 一周目 递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        return res;
    }

    /**
     * 2021/09/02 16:05 一周目 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        final Deque<Node> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            final Node node = stack.pollLast();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.offerLast(node.children.get(i));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _589_NaryTreePreorderTraversal().preorder(Nodes.instance(1, null, 3, 2, 4, null, 5, 6)).toArray()));
        System.out.println(Arrays.toString(new _589_NaryTreePreorderTraversal().preorder(Nodes.instance(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14)).toArray()));
        System.out.println(Arrays.toString(new _589_NaryTreePreorderTraversal().preorder(Nodes.instance()).toArray()));
        System.out.println("----------------------------");
        System.out.println(Arrays.toString(new _589_NaryTreePreorderTraversal().preorder2(Nodes.instance(1, null, 3, 2, 4, null, 5, 6)).toArray()));
        System.out.println(Arrays.toString(new _589_NaryTreePreorderTraversal().preorder2(Nodes.instance(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14)).toArray()));
        System.out.println(Arrays.toString(new _589_NaryTreePreorderTraversal().preorder2(Nodes.instance()).toArray()));
    }
}
