package util;

import model.ListNode;

/**
 * @author fengxxc
 * @date 2021-09-10
 */
public class ListNodes {
    public static final ListNode instance(Integer... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        final ListNode root = new ListNode(arr[0]);
        ListNode node = root;
        for (int i = 1; i < arr.length; i++) {
            node = node.setNextVal(arr[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(ListNodes.instance(1, 2, 3, 4, 5).toString());
        System.out.println(ListNodes.instance(1, 2, 3, 4, 5, 6).toString());
    }
}
