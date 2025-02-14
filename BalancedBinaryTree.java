// Given a binary tree, determine if it is height-balanced.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: true
  
// Example 2:
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
  
// Example 3:
// Input: root = []
// Output: true
 
// Constraints:
// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104

class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
