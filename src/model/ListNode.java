package model;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {}

	public ListNode(int x) { val = x; }

	public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	public ListNode setNextVal(int nextVal) {
		this.next = new ListNode(nextVal);
		return this.next;
	}

	@Override
	public String toString() {
		if (this.next == null) {
			return this.val + "";
		}
		return this.val + " -> " + this.next.toString();
	}
}
