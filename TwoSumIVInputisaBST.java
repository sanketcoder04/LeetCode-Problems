// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

// Example 1:
// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
  
// Example 2:
// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -104 <= Node.val <= 104
// root is guaranteed to be a valid binary search tree.
// -105 <= k <= 105

class TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        for(int i=0;i<list.size()-1;i++) {
            for(int j=i+1;j<list.size();j++) {
                if(list.get(i) + list.get(j) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
