package junior;

import model.TreeNode;

/**
 * @author fengxxc
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

	private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
		if (l > r) {
			return null;
		}
		int m = l + ((r - l) >> 1); // same of: (l + r) / 2
		TreeNode node = new TreeNode(nums[m]);
		node.left = sortedArrayToBST(nums, l, m-1);
		node.right = sortedArrayToBST(nums, m+1, r);
		return node;
	}
	
	public static void main(String[] args) {
	}
}
