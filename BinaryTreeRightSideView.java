// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,2,3,4,null,null,null,5]
// Output: [1,3,4,5]

// Example 3:
// Input: root = [1,null,3]
// Output: [1,3]

// Example 4:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Taking only the rightMost Node and adding into the List by BFS Algo

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=1;i<=levelSize;i++) {
                TreeNode node = queue.poll();

                if(i == levelSize) {
                    list.add(node.val);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }
}
