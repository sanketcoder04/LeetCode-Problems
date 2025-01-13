// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
  
// Example 2:
// Input: head = [1], n = 1
// Output: []
  
// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz

class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 1;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        if(size == 1){
            head = null;
            return head;
        }
        if(size == 2 && n == 1){
            head.next = null;
            return head;
        }
        if(size == 2 && n == 2){
            head = head.next;
            return head;
        }
        int length = size-n;
        if(length == 0){
            head = head.next;
            return head;
        }
        temp = head;
        length--;
        while(length > 0){
            temp = temp.next;
            length--;
        }
        temp.next = temp.next.next;
        return head;
    }
}
