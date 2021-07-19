package model;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	 
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
