// Given the root of a binary tree, return the sum of all left leaves.
// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
  
// Example 2:
// Input: root = [1]
// Output: 0
 
// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// -1000 <= Node.val <= 1000


// We will track the parent of every node at prev node, Now we will check for every node if it is a,
// Leaf node and left child of every parent node 

class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,null);
    }

    private int sumOfLeftLeaves(TreeNode node, TreeNode prev) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null && prev != null && node == prev.left) {
            return node.val;
        }
        if(node.left == null && node.right == null) {
            return 0;
        }
        prev = node;
        int leftSum = calculate(node.left, prev);
        int rightSum = calculate(node.right, prev);
        return leftSum + rightSum;
    }
}
