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
    public int diameterOfBinaryTree(TreeNode root) {
        if( root == null) return 0;
        return maxDiameterOfNode(root, 0);
    }

    public int maxDiameterOfNode(TreeNode node, int max) {
        if(node==null) return max;
        int maxDiamOfCurrentNode =  Math.max (maxDepth(node.left) + maxDepth(node.right), max);
        return Math.max (maxDiameterOfNode(node.right, maxDiamOfCurrentNode), maxDiameterOfNode(node.left, maxDiamOfCurrentNode));
    }

    public int maxDepth(TreeNode node){
        if (node == null ) return 0;
        return Math.max(maxDepth (node.left), maxDepth(node.right)) + 1;
    }
}
