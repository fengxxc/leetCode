package junior;

/**
 * 树
 * @author fengxxc
 *
 */
public class SolutionTree {
	/**
	 * Definition for a binary tree node.
	 * @author fengxxc
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * 二叉树的最大深度
	 * 给定一个二叉树，找出其最大深度。
	 * 二叉树的深度为根节点到最远叶节点的最长路径上的节点数。
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int leftDepth = maxDepth(root.left) + 1;
		int rightDepth = maxDepth(root.right) + 1;
		return Math.max(leftDepth, rightDepth);
	}
	
	/**
	 * 98. 验证二叉搜索树
	 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	 * 假设一个二叉搜索树具有如下特征：
	 * 节点的左子树只包含小于当前节点的数。
	 * 节点的右子树只包含大于当前节点的数。
	 * 所有左子树和右子树自身必须也是二叉搜索树。
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || maxVal <= root.val) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    
    public static void main(String[] args) {
    	
	}
}
