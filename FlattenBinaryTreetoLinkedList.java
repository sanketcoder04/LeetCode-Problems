// Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
// Example 1:
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]
  
// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [0]
// Output: [0]
 
// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100

class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        constructList(root, list, 1);
    }

    private void preOrder(TreeNode node, List<TreeNode> list) {
        if(node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private void constructList(TreeNode prev, List<TreeNode> list, int index) {
        if(index == list.size()) {
            return;
        }
        TreeNode node = new TreeNode(list.get(index).val);
        prev.right = node;
        prev.left = null;
        constructList(node, list, index + 1);
    }
}
