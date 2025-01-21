// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
  
// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 
// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;     // checking because if k > length it gets the effective value of rotation
        if (k == 0) {
            return head;    // if k == length then after rotating k times, the list remains same
        }
        while(k > 0){
            head = rotate(head);    // rotate the list and make the end node as head one by one k times
            k--;
        }
        return head;
    }

    public ListNode rotate(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next = head;
        head = temp;
        return head;
    }
}
