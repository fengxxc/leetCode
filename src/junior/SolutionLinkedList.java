package junior;

import model.ListNode;

/**
 * 链表
 * @author fengxxc
 *
 */
public class SolutionLinkedList {
	/**
	 * 删除链表的结点
	 * @param node
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	/**
	 * 删除链表的倒数第N个节点
	 * 给定一个链表，删除链表的倒数第 n 个节点并返回头结点。
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp = head, oHead = head;
		for (int i = 0; i < n; i++) {
			tmp = tmp.next;
		}
		if (tmp == null) { // 说明删的是头结点
			head = null;
			return oHead.next;
		}
		for (; tmp != null; tmp = tmp.next) {
			head = head.next;
		}
		head.next = head.next.next;
		return oHead;
	}
}
