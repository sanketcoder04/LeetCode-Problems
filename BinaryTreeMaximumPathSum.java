// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. 
// Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.

// Example 1:
// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
  
// Example 2:
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 
// Constraints:
// The number of nodes in the tree is in the range [1, 3 * 104].
// -1000 <= Node.val <= 1000

class BinaryTreeMaximumPathSum {
    int answer = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return answer;
    }

    private int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);

        // To exclude negative valued paths 
        leftSum = Math.max(leftSum,0);
        rightSum = Math.max(rightSum,0);

        int pathSum = leftSum + rightSum + node.val;
        answer = Math.max(answer,pathSum);
        return Math.max(leftSum, rightSum) + node.val;
    }
}
