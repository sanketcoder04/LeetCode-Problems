// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
// as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Example 1:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
  
// Example 2:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
  
// Example 3:
// Input: root = [1,2], p = 1, q = 2
// Output: 1
 
// Constraints:
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the tree.

class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        findNodes(root,p,list1);
        findNodes(root,q,list2);

        int i = 0;
        for(;i<list1.size() && i<list2.size();i++) {
            if(list1.get(i) != list2.get(i)) {
                break;
            }
        }
        return list1.get(i-1);
    }

    public boolean findNodes(TreeNode node, TreeNode target, ArrayList<TreeNode> list) {
        if(node == null) {
            return false;
        }
        list.add(node);
        if(node.val == target.val) {
            return true;
        }
        boolean leftFound = findNodes(node.left,target,list);
        boolean rightFound = findNodes(node.right,target,list);

        if(leftFound || rightFound) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
}
