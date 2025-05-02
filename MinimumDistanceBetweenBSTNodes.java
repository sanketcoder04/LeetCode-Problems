// Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

// Example 1:
// Input: root = [4,2,6,1,3]
// Output: 1
  
// Example 2:
// Input: root = [1,0,48,null,null,12,49]
// Output: 1
 
// Constraints:
// The number of nodes in the tree is in the range [2, 100].
// 0 <= Node.val <= 105

class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int min = Integer.MAX_VALUE;

        for(int i=0;i<list.size()-1;i++) {
            for(int j=i+1;j<list.size();j++) {
                int diff = Math.abs(list.get(i) - list.get(j));
                min = Math.min(diff, min);
            }
        }
        return min;
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
