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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
        
    }

    private void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }

        //save current node value
        sb.append(node.val).append(",");

        //serialize leftsub tree
       serializeHelper(node.left, sb);
       serializeHelper(node.right, sb);

      }


    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split(",");
        int [] index = {0};
        return deserializeHelper(value, index);
        
    }

    private TreeNode  deserializeHelper(String values[], int index[]){

        //read current value
        String value = values[index[0]];
        //move to next value
        
        index[0]++;
        //if no node exit
        if(value.equals("null")){
            return null;
        }

        //create node
        TreeNode node = new TreeNode(Integer.parseInt(value));

        // build left subtree
        node.left = deserializeHelper(values, index);
        node.right = deserializeHelper(values, index);
        return node;

    }
}
