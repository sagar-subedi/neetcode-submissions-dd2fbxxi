class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Keep traversing until we find the split point
        while (root != null) {
            
            // If both p and q are smaller than root,
            // LCA must be in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            
            // If both p and q are greater than root,
            // LCA must be in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            
            // If one is on left and one is on right
            // OR current node is p/q
            // then current root is LCA
            else {
                return root;
            }
        }
        
        return null; // safety case
    }
}