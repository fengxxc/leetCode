package util;

import model.TreeNode;

import java.util.*;

/**
 * 二叉树 工具类
 * @author fengxxc
 * @date 2021-08-16
 */
public class TreeNodes {

    /**
     * 构造实例
     * @param arr
     * @return
     */
    public static TreeNode instance(Integer[] arr) {
        if (arr[0] == null) {
            return null;
        }
        int index = 0;
        final TreeNode root = new TreeNode(arr[index++]);
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean stop = false;
        while (true) {
            final int n = queue.size();
            for (int i = 0; i < n; i++) {
                final TreeNode node = queue.poll();

                // left
                if (index == arr.length) {
                    stop = true;
                    break;
                }
                if (arr[index] == null) {
                    node.left = null;
                } else {
                    final TreeNode leftChild = new TreeNode(arr[index]);
                    node.left = leftChild;
                    queue.offer(node.left);
                }
                index++;

                // right
                if (index == arr.length) {
                    stop = true;
                    break;
                }
                if (arr[index] == null) {
                    node.right = null;
                } else {
                    final TreeNode rightChild = new TreeNode(arr[index]);
                    node.right = rightChild;
                    queue.offer(node.right);
                }
                index++;
            }
            if (stop) {
                break;
            }
        }
        return root;
    }

    /**
     * 可视化打印
     *
     * @param root  [3, 9, 20, null, null, 15, 7]
     * @param paddingLeft 左补白数量
     * @return
     *                 3
     *               /   \
     *             9      20
     *                  /   \
     *                 15     7
     */
    public static String toString(TreeNode root, int paddingLeft) {
        // 横向松散程度
        int LOOSE_X = 3;

        // 偏移量
        int offset = 0;
        List<List<TreeNodePlus>> temp = new ArrayList<>();
        final Queue<TreeNodePlus> queue = new LinkedList<>();
        queue.offer(new TreeNodePlus(root, 0));
        while (!queue.isEmpty()) {
            final int n = queue.size();
            List<TreeNodePlus> row = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                final TreeNodePlus treeNodePlus = queue.poll();
                if (treeNodePlus.node == null) {
                    continue;
                }
                row.add(treeNodePlus);
                queue.offer(new TreeNodePlus(treeNodePlus.node.left, treeNodePlus.pos - LOOSE_X));
                queue.offer(new TreeNodePlus(treeNodePlus.node.right, treeNodePlus.pos + LOOSE_X));
                offset = Math.max(offset, Math.abs(treeNodePlus.pos));
            }
            temp.add(row);
        }

        final StringBuffer res = new StringBuffer("");
        for (List<TreeNodePlus> row : temp) {
            // print value
            if (row == null || row.size() == 0) {
                continue;
            }
            res.append('\n');
            TreeNodePlus last = null;
            // 下行的斜杠
            StringBuffer nextRowSlash = new StringBuffer();
            for (TreeNodePlus treeNodePlus : row) {
                int spaceCount = (last == null) ? treeNodePlus.pos + offset + paddingLeft
                                                : treeNodePlus.pos - last.pos - String.valueOf(last.node.val).length();
                last = treeNodePlus;
                res.append(makeBlank(spaceCount));
                res.append(treeNodePlus.node.val);
                nextRowSlash.append(makeBlank(spaceCount - 1));
                nextRowSlash.append(treeNodePlus.node.left != null ? '/' : ' ');
                if (treeNodePlus.node.right != null) {
                    nextRowSlash.append(makeBlank(LOOSE_X - 1)).append('\\');
                }
            }
            res.append('\n').append(nextRowSlash);
        }
        return res.toString();
    }

    public static String toString(TreeNode root) {
        return toString(root, 0);
    }

    /**
     * 生成count个空格
     * @param count
     * @return
     */
    public static final String makeBlank(int count) {
        final StringBuffer res = new StringBuffer();
        for (int i = 0; i < count; i++) res.append(' ');
        return res.toString();
    }

    static class TreeNodePlus {
        public TreeNode node = null;
        public int pos = 0;

        public TreeNodePlus(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + node.val +
                    ", pos=" + pos +
                    '}';
        }
    }


    public static void main(String[] args) {
        System.out.println(TreeNodes.toString(TreeNodes.instance(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(TreeNodes.toString(TreeNodes.instance(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));
        System.out.println(TreeNodes.toString(TreeNodes.instance(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        System.out.println(TreeNodes.toString(TreeNodes.instance(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1})));
    }
}
