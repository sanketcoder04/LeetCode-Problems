// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

// Example 1:
// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
  
// Example 2:
// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false
 
// Constraints:
// The number of nodes in each tree will be in the range [1, 200].
// Both of the given trees will have values in the range [0, 200].

class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeafSequence(root1, list1);
        getLeafSequence(root2, list2);

        return list1.equals(list2);
    }

    private void getLeafSequence(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        getLeafSequence(node.left, list);
        getLeafSequence(node.right, list);
    }
}
