// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
// height-balanced binary search tree.

// Example 1:
// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
  
// Example 2:
// Input: head = []
// Output: []
 
// Constraints:
// The number of nodes in head is in the range [0, 2 * 104].
// -105 <= Node.val <= 105

class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return createBST(head,null);
    }
  
    private TreeNode createBST(ListNode start, ListNode end) {
        if(start == end) {
            return null;
        }
        ListNode mid = getMidNode(start,end);
        TreeNode node = new TreeNode(mid.val);
        node.left = createBST(start,mid);
        node.right = createBST(mid.next,end);
        return node;
    }
  
    private ListNode getMidNode(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;

        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        } 
        return slow;
    }
}
