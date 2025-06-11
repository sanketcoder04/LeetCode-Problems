// You are given the head of a linked list with n nodes.
// For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
// Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

// Example 1:
// Input: head = [2,1,5]
// Output: [5,5,0]
  
// Example 2:
// Input: head = [2,7,4,3,5]
// Output: [7,0,5,5,0]
 
// Constraints:
// The number of nodes in the list is n.
// 1 <= n <= 104
// 1 <= Node.val <= 109

class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode prev = null;
        int arr[] = new int[size];
        temp = head;
        int i = 0;
        while(temp != null) {
            prev = temp;
            int max = prev.val;
            int b = max;
            while(temp != null) {
                if(max < temp.val) {
                    max = temp.val;
                    break;
                }
                temp = temp.next;
            }
            if(max == b) {
                arr[i] = 0;
            }
            else {
                arr[i] = max;
            }
            i++;
            temp = prev.next;
        }
        return arr;
    }
}
