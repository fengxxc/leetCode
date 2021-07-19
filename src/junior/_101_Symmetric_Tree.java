package junior;

import model.TreeNode;

public class _101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

	private boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) 
			return true;
		else if (l == null || r == null) 
			return false;
		else if (l.val == r.val) 
			return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
		return false;			
	}
	
	public static void main(String[] args) {
		
	}
}
