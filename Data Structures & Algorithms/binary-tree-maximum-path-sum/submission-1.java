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
  int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

       gain(root);
      return maxSum;
        
    }


    public int gain(TreeNode node){

      //base case
      if(node == null){
        return 0;
      }

      // left gain
      int leftGain = Math.max(0, gain(node.left));

      //right gain
      int rightGain = Math.max(0, gain(node.right));

      //current path
      int currentPath = leftGain + node.val + rightGain;

      //update maximum
      maxSum = Math.max(maxSum, currentPath);

      // parent have to return only one side max
      return node.val + Math.max(leftGain, rightGain);
    }
}
