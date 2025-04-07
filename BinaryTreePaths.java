// Given the root of a binary tree, return all root-to-leaf paths in any order.
// A leaf is a node with no children.

// Example 1:
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
  
// Example 2:
// Input: root = [1]
// Output: ["1"]
 
// Constraints:
// The number of nodes in the tree is in the range [1, 100].
// -100 <= Node.val <= 100

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        findPaths(root, list, "");
        return list;
    }

    private void findPaths(TreeNode node, List<String> list, String str) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            list.add(str + node.val);
            return;
        }
        findPaths(node.left, list, str + node.val + "->");
        findPaths(node.right, list, str + node.val + "->");
    }
}
