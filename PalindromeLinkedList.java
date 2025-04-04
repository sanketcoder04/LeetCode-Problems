// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true
  
// Example 2:
// Input: head = [1,2]
// Output: false
 
// Constraints:
// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(!stack.empty()){
            if(stack.pop() != temp.val){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
