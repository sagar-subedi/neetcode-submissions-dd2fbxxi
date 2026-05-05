/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count;
    int kthSmallest;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        dfs (root, k);
        return kthSmallest;
        
    }

    public void dfs( TreeNode root, int k) {
        if(root == null ) return;

        dfs ( root.left, k);

        if ( ++count == k   ){
            kthSmallest = root.val;
        }

        dfs ( root.right, k );

    }
}
