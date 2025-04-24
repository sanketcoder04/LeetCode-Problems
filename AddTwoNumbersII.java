// You are given two non-empty linked lists representing two non-negative integers. 
// The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]
  
// Example 2:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]
  
// Example 3:
// Input: l1 = [0], l2 = [0]
// Output: [0]
 
// Constraints:
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.

class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode result = null;
        while(!stack1.empty() || !stack2.empty()) {
            int a = 0;
            int b = 0;
            if(!stack1.empty()) {
                a = stack1.pop();
            }
            if(!stack2.empty()) {
                b = stack2.pop();
            }
            int total = a + b + carry;
            ListNode temp = new ListNode(total % 10);
            carry = total / 10;
            if(result == null) {
                result = temp;
            }
            else {
                temp.next = result;
                result = temp;
            }
        }
        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
