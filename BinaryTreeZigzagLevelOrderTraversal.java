// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
  
// Example 2:
// Input: root = [1]
// Output: [[1]]
  
// Example 3:
// Input: root = []
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100

class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode node = root;
        if(node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        boolean reverse = false;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=1;i<=levelSize;i++) {
                if(!reverse) {
                    node = queue.pollFirst();
                    list.add(node.val);

                    if(node.left != null) {
                        queue.addLast(node.left);
                    }
                    if(node.right != null) {
                        queue.addLast(node.right);
                    }
                }
                else {
                    node = queue.pollLast();
                    list.add(node.val);

                    if(node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if(node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(list);
        }
        return result;
    }
}
