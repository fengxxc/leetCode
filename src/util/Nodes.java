package util;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * N叉数 工具类
 * @author fengxxc
 * @date 2021-08-31
 */
public class Nodes {

    /**
     * 构造实例
     * @param arr
     * @return
     */
    public static final Node instance(Integer ...arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (arr.length == 1) {
            return new Node();
        }
        Node cur = new Node(-1, new ArrayList<>());
        final Node root = cur;
        final Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        int index = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            while (arr[index] != null) {
                final Node child = new Node(arr[index], new ArrayList<>());
                cur.children.add(child);
                queue.offer(child);
                index++;
                if (index >= arr.length) {
                    break;
                }
            }
            index++;
            if (index >= arr.length) {
                break;
            }
        }
        return root.children.get(0);
    }

    public static final String toString(Node node) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        // System.out.println(Nodes.instance(new Integer[]{1, null, 3, 2, 4, null, 5, 6}).toString());
        System.out.println(Nodes.instance(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14}).toString());
    }
}
