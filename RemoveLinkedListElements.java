// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

// Example 1:
// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
  
// Example 2:
// Input: head = [], val = 1
// Output: []
  
// Example 3:
// Input: head = [7,7,7,7], val = 7
// Output: []
 
// Constraints:
// The number of nodes in the list is in the range [0, 104].
// 1 <= Node.val <= 50
// 0 <= val <= 50

class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null){
            if(temp == head && temp.val == val){
                temp = temp.next;
                head = temp;
                continue;
            }
            if(temp != head && temp.val == val){
                prev.next = temp.next;
                temp = temp.next;
                continue;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
