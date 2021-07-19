package junior;

import model.ListNode;

import java.util.List;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class _206_Reverse_Linked_List {

    /**
     * 递归的解法
     */
    public static ListNode reverseList(ListNode head) {
        return _reverseList(null, head);
    }
    private static ListNode _reverseList(ListNode father, ListNode me) {
        if (me == null) {
            return father;
        }
        ListNode meOleNext = me.next;
        me.next = father;
        return _reverseList(me, meOleNext);
    }

    /**
     * 迭代的解法
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode father = null;
        ListNode me = head;
        while (me != null) {
            final ListNode meOldNext = me.next;
            me.next = father;
            father = me;
            me = meOldNext;
        }
        return father;
    }

    // test
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNextVal(2).setNextVal(3).setNextVal(4).setNextVal(5);

        // ListNode res = reverseList(head);
        ListNode res = reverseList2(head);

        System.out.println(res);
    }
}
