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
    Map<Integer, Integer> map;
    int currentIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currentIndex=0;
        map = new HashMap<>();

        int size = inorder.length;

        for ( int i = 0; i < size; i ++){
            map.put(inorder[i], i);
        }

        return buildTree(preorder,0, size-1);

    }

        public  TreeNode buildTree (int[] preorder, int min, int max){
            if ( min > max ) return null;

            int currentVal = preorder[currentIndex++];
            TreeNode node = new TreeNode(currentVal);

            int index = map.get(currentVal);
        

            node.left = buildTree ( preorder, min, index -1);

            node.right = buildTree ( preorder, index + 1, max);

            return node;
        }
    
}
