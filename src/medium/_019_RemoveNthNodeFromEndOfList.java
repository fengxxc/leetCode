package medium;

import model.ListNode;
import util.ListNodes;

/**
 * @author fengxxc
 *
 * 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 * 示例 1：
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 *          ↓
 * 1 -> 2 -> 3 ------> 5
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
public class _019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            // return new ListNode();
            return null;
        }
        final ListNode root = new ListNode(-1, head);
        ListNode l = root;
        ListNode r = root.next;
        int dis = 0;
        while (r != null) {
            if (dis == n) {
                l = l.next;
            } else {
                dis++;
            }
            r = r.next;
        }
        l.next = l.next.next;
        return root.next;
    }

    public static void main(String[] args) {
        System.out.println(new _019_RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNodes.instance(1, 2, 3, 4, 5), 2).toString());
        System.out.println(new _019_RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNodes.instance(1), 1).toString());
        System.out.println(new _019_RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNodes.instance(1, 2), 1).toString());
        System.out.println(new _019_RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNodes.instance(1, 2), 2).toString());
    }
}
