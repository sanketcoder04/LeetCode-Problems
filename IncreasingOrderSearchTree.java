// Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, 
// and every node has no left child and only one right child.

// Example 1:
// Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
// Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
  
// Example 2:
// Input: root = [5,1,7]
// Output: [1,null,5,null,7]
 
// Constraints:
// The number of nodes in the given tree will be in the range [1, 100].
// 0 <= Node.val <= 1000

class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        TreeNode newRoot = list.get(0);
        constructTree(list, newRoot, 1);
        return newRoot;
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if(node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

    private void constructTree(List<TreeNode> list, TreeNode node, int index) {
        if(index == list.size()) {
            node.right = null;
            node.left = null;
            return;
        }
        TreeNode newNode = list.get(index);
        node.right = newNode;
        node.left = null;
        constructTree(list, newNode, index+1);
    }
}
