// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
// construct and return the binary tree.

// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
  
// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 
// Constraints:
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.

class ConstructBinaryTreefromPreorderandInorderTraversal { 

    // First Approach 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }

        int r = preorder[0];
        int index = 0;

        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == r) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }

    // Another approach using Hashmap
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        int[] index = {0};
        return helper(preorder, inorder,  0, preorder.length - 1, map, index);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer,Integer> map, int[] index) {
        if(left > right) {
            return null;
        }
        int current = preorder[index[0]];
        index[0]++;

        TreeNode node = new TreeNode(current);
        if(left == right) {
            return node;
        }
        int currIndex = map.get(current);
        node.left = helper(preorder, inorder, left, currIndex-1, map, index);
        node.right = helper(preorder, inorder, currIndex+1, right, map, index);
        return node;
    }
}
