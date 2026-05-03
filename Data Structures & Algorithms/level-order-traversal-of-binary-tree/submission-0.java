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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if ( root == null ) return result;
        nodes.offer(root);

        while(!nodes.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            int size = nodes.size();
            for (  int i = 0; i < size; i ++){
                TreeNode node = nodes.poll();

                currentLevel.add (node.val);
                if( node.left != null ){
                    currentLevelNodes.add(node.left);
                }

                if( node.right != null ){

                    currentLevelNodes.add(node.right);
                }

            }

            for (TreeNode node : currentLevelNodes){
                nodes.offer(node);
            }
            result.add(currentLevel);



        }
        return result;
        
    }
}
