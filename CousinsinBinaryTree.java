// Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true
// if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
// Two nodes of a binary tree are cousins if they have the same depth with different parents.
// Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

// Example 1:
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false
  
// Example 2:
// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true
  
// Example 3:
// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
 
// Constraints:
// The number of nodes in the tree is in the range [2, 100].
// 1 <= Node.val <= 100
// Each node has a unique value.
// x != y
// x and y are exist in the tree.

class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
            (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    private TreeNode findNode(TreeNode node, int x) {
        if(node == null) {
            return null;
        }
        if(node.val == x) {
            return node;
        }
        TreeNode n = findNode(node.left, x);
        if(n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if(node == null) {
            return false;
        }
        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left,x,y) || isSibling(node.right, x, y)
        );
    }

    private int level(TreeNode node, TreeNode x, int level) {
        if(node == null) {
            return 0;
        }
        if(node == x) {
            return level;
        }
        int l = level(node.left, x, level + 1);
        if(l != 0) {
            return l;
        }
        return level(node.right, x, level + 1);
    }
}
