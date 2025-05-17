// You are given the root of a binary search tree (BST) and an integer val.
// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Example 1:
// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]

// Example 2:
// Input: root = [4,2,7,1,3], val = 5
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [1, 5000].
// 1 <= Node.val <= 107
// root is a binary search tree.
// 1 <= val <= 107

class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root,val);
    }

    private TreeNode search(TreeNode node, int value) {
        if(node == null) {
            return null;
        }
        if(node.val == value) {
            return node;
        }
        else if(value < node.val) {
            return search(node.left, value);
        }
        else {
            return search(node.right, value);
        }
    }
}
