// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.
// The most significant bit is at the head of the linked list.

// Example 1:
// Input: head = [1,0,1]
// Output: 5
// Explanation: (101) in base 2 = (5) in base 10
  
// Example 2:
// Input: head = [0]
// Output: 0
 
// Constraints:
// The Linked List is not empty.
// Number of nodes will not exceed 30.
// Each node's value is either 0 or 1.

class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        int result = 0;
        int i = 0;
        while(!stack.empty()){
            int elem = stack.pop();
            result += elem * Math.pow(2,i);
            i++;
        }
        return result;
    }
}
