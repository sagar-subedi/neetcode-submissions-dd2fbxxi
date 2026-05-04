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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        queue.offer(root);

        while(!queue.isEmpty()){
            boolean isRightestElementOfCurrentLevel = true;

            int size = queue.size();
            for ( int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if( isRightestElementOfCurrentLevel){
                    isRightestElementOfCurrentLevel = false;
                    list.add(node.val);
                }
                
                if (node.right != null ){
                    queue.offer( node.right);
                
                }
                if ( node.left != null ) { 
                    queue.offer ( node.left);
                }
                


            }
        }
        return list;

    }
}
