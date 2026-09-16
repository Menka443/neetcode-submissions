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

             // 1. Base case
            if(node == null){
                return 0;
            }

           // 2. Left subtree ka maximum useful gain
            int leftGain = Math.max(0, gain(node.left));

              // 2. Right subtree ka maximum useful gain
            int rightGain = Math.max(0, gain(node.right));

               // 4. Current node par complete path
               int currentPath = leftGain + node.val + rightGain;

                 // 5. Global maximum update
                //  “Kya ye complete path ab tak ke answer se bada hai?”
                 maxSum = Math.max(maxSum, currentPath);


                   // 6. Parent ko sirf ek bigger side return
                   return node.val + Math.max(leftGain, rightGain);


        }

     }





