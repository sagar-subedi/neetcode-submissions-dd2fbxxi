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
    public int goodNodes(TreeNode root) {

        return dfs (root, Integer.MIN_VALUE);
        
    }

    public int dfs (TreeNode root, int maxValueTillNow){
        int count = 0;
        if(root == null) return count;

        if ( root.val >= maxValueTillNow ) {
            count = 1;
            maxValueTillNow = root.val;
        }

        count+= dfs ( root.left, maxValueTillNow );
        count+= dfs (root.right, maxValueTillNow );

        return count;

    }
}
