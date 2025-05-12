// Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [3.00000,14.50000,11.00000]
// Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
// Hence return [3, 14.5, 11].

// Example 2:
// Input: root = [3,9,20,15,7]
// Output: [3.00000,14.50000,11.00000]
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1

class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        TreeNode node = root;
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for(int i=1;i<=levelSize;i++) {
                node = queue.poll();
                sum += (double)node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            Double average = Double.valueOf(sum/levelSize);
            result.add(average);
        }
        return result;
    }
}
