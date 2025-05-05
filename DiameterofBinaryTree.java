// Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

// Example 1:
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
  
// Example 2:
// Input: root = [1,2]
// Output: 1
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100

class DiameterofBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight = height(node.left);     // left subtree height
        int rightHeight = height(node.right);   // right subtree height

        int d = leftHeight + rightHeight + 1;   // calculating the diameter
        diameter = Math.max(d,diameter);        // changing the global diameter with max value

        return Math.max(leftHeight,rightHeight) + 1;    // returning the height
    }
}
