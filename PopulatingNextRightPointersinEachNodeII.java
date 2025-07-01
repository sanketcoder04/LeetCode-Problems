// Given a binary tree
// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL
// Initially, all next pointers are set to NULL.

// Example 1:
// Input: root = [1,2,3,4,5,null,7]
// Output: [1,#,2,3,#,4,5,7,#]
// Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

// Example 2:
// Input: root = []
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 6000].
// -100 <= Node.val <= 100
 
class PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            Node prev = null;
            for(int i=1;i<=levelSize;i++) {
                Node node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if(prev != null) {
                    prev.next = node;
                }
                prev = node;
            }
            prev.next = null;
        }
        return root;
    }
}
